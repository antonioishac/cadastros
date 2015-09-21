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
import br.com.cactus.cadastros.model.Ncm;
import br.com.cactus.cadastros.model.vo.NcmVO;
import br.com.cactus.cadastros.repository.NcmRepository;
import br.com.cactus.cadastros.util.Mensagem;
import br.com.cactus.cadastros.util.Mensagem.TipoMensagem;

@Controller
@RequestMapping(value = "/ncm")
public class NcmController {
	
	@Autowired
	private NcmRepository ncmRepository;
		
	private NcmVO ncmVO;
	
	@RequestMapping(value = "/listaNcm.do")
	public String telaLista(){
		
		return "ncm/listaNcm";
		
	}
	
	@RequestMapping(value = "/cadastroNcm.do")
	public String telaCadastro(Model model) {
		
		model.addAttribute("ncm", new Ncm());
		
		return "ncm/cadastroNcm";
		
	}
	
	@RequestMapping(value = "/listarNcm.do", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String listarNcm(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, IllegalAccessException {
		
		List<Ncm> listaNcm = new ArrayList<>();
		
		//CHAMA O METODO QUE DEFINE OS CAMPOS PARA SORT
		//this.tipoSort(request);
				
		String codigo = request.getParameter("codigo");
		String descricao = request.getParameter("descricao");
		
				
		ncmVO = new NcmVO();
		
		ncmVO.setCodigo(codigo);
		
		ncmVO.setDescricao(descricao);
				
		String funcExcluir = request.getParameter("funcExcluir");
				
		//Para fazer uma busca paginada é necessário passar um parâmetro inteiro da posição corrente para o banco
		String posicaoString = request.getParameter("start");

		int posicao = Integer.parseInt(posicaoString);
				
		int quantidadeTotalRegistros = 0;
						
		listaNcm = ncmRepository.listaNcm(posicao, 10, ncmVO, "", "");
			
		//paisBO.listaUsuarioFiltroCampos(posicao, 10, usuario, this.getSortColuna(), this.getSortAscDesc());
					
		quantidadeTotalRegistros = ncmRepository.totalNcm(ncmVO);
								
		System.out.println("lista de retorno: " + listaNcm.size());
				
		if (listaNcm.size() == 0) {
					
			return "{\"recordsFiltered\":0,\"data\":[],\"recordsTotal\":0}";			

		}

		return geradorDadosTabela(listaNcm, quantidadeTotalRegistros, request.getContextPath(),funcExcluir);
		
	}
	
	@SuppressWarnings("unchecked")
	public String geradorDadosTabela(List<Ncm> listaDados, int quantidadeTotal, String contextPath, String funcExcluir) throws IllegalArgumentException, IllegalAccessException {
		
		JSONObject jsonObject = new JSONObject();
		
		if (listaDados.size() != 0) {
			
			
			jsonObject.put("recordsTotal", quantidadeTotal);
			jsonObject.put("recordsFiltered", quantidadeTotal);
			
			JSONArray dados = new JSONArray();
			
			
			for (Ncm ncm : listaDados) {
				JSONArray campos = new JSONArray();
				
				campos.add(ncm.getId());
				campos.add(ncm.getCodigo());
				campos.add(ncm.getDescricao());
								
				StringBuilder sbOpcoes = new StringBuilder();
				
				//LINK PARA ALTERAR
				sbOpcoes.append("<a href=");
				sbOpcoes.append(contextPath);
				sbOpcoes.append("/ncm/mostrarNcm.do?id=");
				sbOpcoes.append(ncm.getId());
				sbOpcoes.append(">");
				//sbOpcoes.append("<input type=\"button\" value=\"selecionar\" class=\"btn btn-success\" />");
				sbOpcoes.append("<span class=\"glyphicon glyphicon-pencil\"></span>");
				sbOpcoes.append("</a>");
				
				//COLOCANDO ESPACO
				sbOpcoes.append("<span style=\"padding-left: 10px\"></span>");
				sbOpcoes.append("|");
				sbOpcoes.append("<span style=\"padding-left: 10px\"></span>");
								
				//LINK PARA EXCLUIR				
				sbOpcoes.append("<a href=#\" onclick=\"");
				sbOpcoes.append(funcExcluir);
				sbOpcoes.append("(");
				sbOpcoes.append(ncm.getId());
				sbOpcoes.append(")");
				sbOpcoes.append("\" id=\"btnExcluir\" <span class=\"glyphicon glyphicon-remove\"></span>");
				
				campos.add(sbOpcoes.toString());
				
				dados.add(campos);
			}
			
			jsonObject.put("data", dados);
		}
		
		
		return jsonObject.toString();
		
	}
	
	@RequestMapping(value = "/salvarNcm.do", method = RequestMethod.POST)
	public ModelAndView salvarNcm(Ncm ncm, HttpServletRequest request, ModelMap map){
		
		try {			
			
			if (ncm.getId() == null) {				
				if (buscaNcmAntesCadastro(ncm.getCodigo()) == false) {
					map.put("mensagem", new Mensagem("Este NCM já existe em nossa base de dados !", TipoMensagem.AVISO));
				}
				else {				
					ncmRepository.salvar(ncm);
					map.put("mensagem", new Mensagem("NCM salvo com sucesso!", TipoMensagem.SUCESSO));
					map.put("ncm", new Ncm());
				}				
			} else {
				ncmRepository.atualizar(ncm);
				map.put("mensagem", new Mensagem("NCM atualizado com sucesso!", TipoMensagem.AVISO));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mensagem", new Mensagem("Erro na transação", TipoMensagem.ERRO));
		}
		
		return new ModelAndView("/mensagem", map);
		
	}
	
	private boolean buscaNcmAntesCadastro(String codigo) {
		
		List<Ncm> listaNcm = ncmRepository.buscaNcmAntesCadastro(codigo);
		
		if (listaNcm.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	@RequestMapping(value = "/mostrarNcm.do")
	public String mostrar(Integer id, Model model){
		
		Ncm ncm = new Ncm();
		
		ncm = ncmRepository.pesquisarPorId(id);
		
		model.addAttribute("ncm", ncm);
		
		return "ncm/cadastroNcm";
	}
	
	@RequestMapping(value = "/removeNcm.do", method = RequestMethod.GET)
	public ModelAndView excluir(Integer id, ModelMap map) {
		
		Ncm ncm = ncmRepository.pesquisarPorId(id);
		
		try {
			
			ncmRepository.excluir(ncm);
			
			map.put("mensagem", new Mensagem("Exclusão realizada com sucesso", TipoMensagem.SUCESSO));
			
			return new ModelAndView("/mensagem", map);
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mensagem", new Mensagem("Esse registro não pode ser excluido", TipoMensagem.ERRO));			
			return new ModelAndView("/mensagem", map);
		}
		
	}
	
	

}
