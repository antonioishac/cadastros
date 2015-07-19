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
import br.com.cactus.cadastros.model.Pais;
import br.com.cactus.cadastros.model.vo.PaisVO;
import br.com.cactus.cadastros.util.Mensagem;
import br.com.cactus.cadastros.util.Mensagem.TipoMensagem;

@Controller
@RequestMapping(value = "/pais")
public class PaisController {
	
	private PaisVO paisVO;
	
	@Autowired
	private PaisBO paisBO;
	
	@RequestMapping(value = "/listaPais.do")
	public String telaLista(Model model) {
		
		//model.addAttribute("pais", new Pais());
		
		return "pais/listaPais";
		
	}
	
	@RequestMapping(value = "/cadastroPais.do")
	public String telaCadastro(Model model){
		
		model.addAttribute("pais", new Pais());
		
		return "pais/cadastroPais";
	}
	
	@RequestMapping(value = "/listarPais.do", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String listarPais(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, IllegalAccessException {
		
		List<Pais> listaPais = new ArrayList<>();
		
		//CHAMA O METODO QUE DEFINE OS CAMPOS PARA SORT
		//this.tipoSort(request);
				
		String codigo = request.getParameter("codigo");
		String nomePtBr = request.getParameter("nome");
		
				
		paisVO = new PaisVO();
		
		if (codigo != null && !codigo.equals("")) {
			
			paisVO.setCodigo(Integer.parseInt(codigo));
			
		}
		
		paisVO.setNome(nomePtBr);
				
		String funcExcluir = request.getParameter("funcExcluir");
				
		//Para fazer uma busca paginada é necessário passar um parâmetro inteiro da posição corrente para o banco
		String posicaoString = request.getParameter("start");

		int posicao = Integer.parseInt(posicaoString);
				
		int quantidadeTotalRegistros = 0;
						
		listaPais = paisBO.listaPais(posicao, 10, paisVO, "", "");
			
		//paisBO.listaUsuarioFiltroCampos(posicao, 10, usuario, this.getSortColuna(), this.getSortAscDesc());
					
		quantidadeTotalRegistros = paisBO.totalPais(paisVO);
								
		System.out.println("lista de retorno: " + listaPais.size());
				
		if (listaPais.size() == 0) {
					
			return "{\"recordsFiltered\":0,\"data\":[],\"recordsTotal\":0}";			

		}

		return geradorDadosTabela(listaPais, quantidadeTotalRegistros, request.getContextPath(),funcExcluir);
		
	}
	
	@SuppressWarnings("unchecked")
	public String geradorDadosTabela(List<Pais> listaDados, int quantidadeTotal, String contextPath, String funcExcluir) throws IllegalArgumentException, IllegalAccessException {
		
		JSONObject jsonObject = new JSONObject();
		
		if (listaDados.size() != 0) {
			
			
			jsonObject.put("recordsTotal", quantidadeTotal);
			jsonObject.put("recordsFiltered", quantidadeTotal);
			
			JSONArray dados = new JSONArray();
			
			
			for (Pais pais : listaDados) {
				JSONArray campos = new JSONArray();
				
				campos.add(pais.getId());
				campos.add(pais.getCodigo());
				campos.add(pais.getNomeEn());
				campos.add(pais.getNomePtBr());
				campos.add(pais.getSigla2());
				campos.add(pais.getSigla3());
				
				StringBuilder sbOpcoes = new StringBuilder();
				
				//LINK PARA ALTERAR
				sbOpcoes.append("<a href=");
				sbOpcoes.append(contextPath);
				sbOpcoes.append("/pais/mostrarPais.do?id=");
				sbOpcoes.append(pais.getId());
				sbOpcoes.append(">");
				sbOpcoes.append("<input type=\"button\" value=\"selecionar\" class=\"btn btn-success\" />");												
				sbOpcoes.append("</a>");
				
				//COLOCANDO ESPACO
				sbOpcoes.append("<span style=\"padding-left: 5px\"></span>");
								
				//LINK PARA EXCLUIR				
				sbOpcoes.append("<input type=\"button\" onclick=\"");
				sbOpcoes.append(funcExcluir);
				sbOpcoes.append("(");
				sbOpcoes.append(pais.getId());
				sbOpcoes.append(")");
				sbOpcoes.append("\" id=\"btnExcluir\" value=\"Excluir\" class=\"btn btn-danger\" />");
				
				campos.add(sbOpcoes.toString());
				
				dados.add(campos);
			}
			
			jsonObject.put("data", dados);
		}
		
		
		return jsonObject.toString();
		
	}
	
	@RequestMapping(value = "/salvarPais.do", method = RequestMethod.POST)
	public ModelAndView gravar(Pais pais, HttpServletRequest request, ModelMap map){
		
		try {
			if(pais.getId() == null) {
				
				paisBO.salvar(pais);
				map.put("mensagem", new Mensagem("País salvo com sucesso", TipoMensagem.SUCESSO));
				map.put("pais", new Pais());
				
			}else {
				
				paisBO.atualizar(pais);
				map.put("mensagem", new Mensagem("País atualizado com sucesso", TipoMensagem.AVISO));
				map.put("pais", new Pais());
				
			}
		} catch (Exception e) {
			map.addAttribute("mensagem", new Mensagem("Erro na transação", TipoMensagem.ERRO));
		}
		
		return new ModelAndView("/mensagem", map);
		
	}
	
	@RequestMapping(value = "/mostrarPais.do")
	public String mostrar(Integer id, Model model){
		
		Pais pais = new Pais();
		
		pais = paisBO.pesquisarPorId(id);
		
		model.addAttribute("pais", pais);
		
		return "pais/cadastroPais";
	}
	
	@RequestMapping(value = "/removePais.do", method=RequestMethod.GET)
	public void excluir(Integer id, HttpServletResponse response) {
		
		try {
			Pais pais = paisBO.pesquisarPorId(id);
			
			paisBO.excluir(pais);
			
			response.setStatus(200);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
