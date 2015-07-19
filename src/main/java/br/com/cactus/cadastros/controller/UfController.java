package br.com.cactus.cadastros.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cactus.cadastros.bo.PaisBO;
import br.com.cactus.cadastros.bo.UfBO;
import br.com.cactus.cadastros.model.Pais;
import br.com.cactus.cadastros.model.Uf;
import br.com.cactus.cadastros.model.vo.UfVO;
import br.com.cactus.cadastros.util.Mensagem;
import br.com.cactus.cadastros.util.Mensagem.TipoMensagem;

@Controller
@RequestMapping(value = "/uf")
public class UfController {
	
	private UfVO ufVO;
	
	@Autowired
	private UfBO ufBO;
	
	@Autowired
	private PaisBO paisBO;
	
	@RequestMapping(value = "/listaUf.do")
	public String telaLista(Model model) {		
				
		return "uf/listaUf";
		
	}
	
	@RequestMapping(value = "cadastroUf.do")
	public String telaCadastro(Model model) {
		
		model.addAttribute("uf", new Uf());
		model.addAttribute("listaPais", listaTodosPais());
		
		return "uf/cadastroUf";
		
	}
	
	public List<Pais> listaTodosPais(){
		
		List<Pais> lista = paisBO.todos();
		
		return lista;
		
	}
	
	@RequestMapping(value = "/listarUf.do", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String listarUf(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, IllegalAccessException {
		
		List<Uf> listaUf = new ArrayList<>();
		
		//CHAMA O METODO QUE DEFINE OS CAMPOS PARA SORT
		//this.tipoSort(request);
				
		String nome = request.getParameter("nome");
		String sigla = request.getParameter("sigla");
		
				
		ufVO = new UfVO();
		
		ufVO.setNome(nome);			
				
		ufVO.setSigla(sigla);
				
		String funcExcluir = request.getParameter("funcExcluir");
				
		//Para fazer uma busca paginada é necessário passar um parâmetro inteiro da posição corrente para o banco
		String posicaoString = request.getParameter("start");

		int posicao = Integer.parseInt(posicaoString);
				
		int quantidadeTotalRegistros = 0;
						
		listaUf = ufBO.listaUf(posicao, 10, ufVO, "", "");
			
		//paisBO.listaUsuarioFiltroCampos(posicao, 10, usuario, this.getSortColuna(), this.getSortAscDesc());
					
		quantidadeTotalRegistros = ufBO.totalUf(ufVO);
								
		System.out.println("lista de retorno: " + listaUf.size());
				
		if (listaUf.size() == 0) {
					
			return "{\"recordsFiltered\":0,\"data\":[],\"recordsTotal\":0}";			

		}

		return geradorDadosTabela(listaUf, quantidadeTotalRegistros, request.getContextPath(), funcExcluir);
		
	}
	
	@SuppressWarnings("unchecked")
	public String geradorDadosTabela(List<Uf> listaDados, int quantidadeTotal, String contextPath, String funcExcluir) throws IllegalArgumentException, IllegalAccessException {
		
		JSONObject jsonObject = new JSONObject();
		
		if (listaDados.size() != 0) {
			
			
			jsonObject.put("recordsTotal", quantidadeTotal);
			jsonObject.put("recordsFiltered", quantidadeTotal);
			
			JSONArray dados = new JSONArray();
			
			
			for (Uf uf : listaDados) {
				JSONArray campos = new JSONArray();
				
				campos.add(uf.getId());
				campos.add(uf.getPais().getNomePtBr());
				campos.add(uf.getSigla());
				campos.add(uf.getNome());
				campos.add(uf.getCodigoIbge());
				
				StringBuilder sbOpcoes = new StringBuilder();
				
				//LINK PARA ALTERAR
				sbOpcoes.append("<a href=");
				sbOpcoes.append(contextPath);
				sbOpcoes.append("/uf/mostrarUf.do?id=");
				sbOpcoes.append(uf.getId());
				sbOpcoes.append(">");
				sbOpcoes.append("<input type=\"button\" value=\"selecionar\" class=\"btn btn-success\" />");												
				sbOpcoes.append("</a>");
				
				//COLOCANDO ESPACO
				sbOpcoes.append("<span style=\"padding-left: 5px\"></span>");
								
				//LINK PARA EXCLUIR				
				sbOpcoes.append("<input type=\"button\" onclick=\"");
				sbOpcoes.append(funcExcluir);
				sbOpcoes.append("(");
				sbOpcoes.append(uf.getId());
				sbOpcoes.append(")");
				sbOpcoes.append("\" id=\"btnExcluir\" value=\"Excluir\" class=\"btn btn-danger\" />");
				
				campos.add(sbOpcoes.toString());
				
				dados.add(campos);
			}
			
			jsonObject.put("data", dados);
		}
		
		
		return jsonObject.toString();
		
	}
	
	@RequestMapping(value = "/salvarUf.do", method = RequestMethod.POST)
	public ModelAndView gravar(Uf uf, HttpServletRequest request, ModelMap map){
		
		try {
			if(uf.getId() == null) {
				
				ufBO.salvar(uf);
				map.put("mensagem", new Mensagem("Estado salvo com sucesso", TipoMensagem.SUCESSO));
				map.put("uf", new Uf());
				
			}else {
				
				ufBO.atualizar(uf);
				map.put("mensagem", new Mensagem("Estado atualizado com sucesso", TipoMensagem.AVISO));
				map.put("uf", new Uf());
				map.put("id", null);
				
			}
			
			//map.put("listaPais", listaTodosPais());
			
		} catch (Exception e) {
			map.addAttribute("mensagem", new Mensagem("Erro na transação", TipoMensagem.ERRO));
		}
		
		return new ModelAndView("/mensagem", map);
		
	}
	
	@RequestMapping(value = "/mostrarUf.do")
	public String mostrar(Integer id, Model model){
		
		Uf uf = new Uf();
		
		uf = ufBO.pesquisarPorId(id);
		
		model.addAttribute("uf", uf);
		
		model.addAttribute("listaPais", listaTodosPais());
		
		return "uf/cadastroUf";
	}
	
	@RequestMapping(value = "/removeUf.do", method=RequestMethod.GET)
	public void excluir(Integer id, HttpServletResponse response) {
		
		try {
			Uf uf = ufBO.pesquisarPorId(id);
			
			ufBO.excluir(uf);
			
			response.setStatus(200);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
