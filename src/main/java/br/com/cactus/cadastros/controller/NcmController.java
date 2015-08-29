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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cactus.cadastros.model.Ncm;
import br.com.cactus.cadastros.model.vo.NcmVO;
import br.com.cactus.cadastros.repository.NcmRepository;

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

}
