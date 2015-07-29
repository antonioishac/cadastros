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

import br.com.cactus.cadastros.bo.MunicipioBO;
import br.com.cactus.cadastros.model.Municipio;
import br.com.cactus.cadastros.model.Uf;
import br.com.cactus.cadastros.model.vo.MunicipioVO;
import br.com.cactus.cadastros.repository.UfRepository;

@Controller
@RequestMapping(value = "/municipio")
public class MunicipioController {
	
	private MunicipioVO municipioVO;
	
	@Autowired
	private MunicipioBO municipioBO;
	
	@Autowired
	private UfRepository ufRepository;
	
	private List<Uf> listaUf;
	
	private Uf ufVO;
	
	@RequestMapping(value = "/listaMunicipio.do")
	public String telaLista(){
		
		return "municipio/listaMunicipio";
		
	}
	
	@RequestMapping(value = "/cadastroMunicipio.do")
	public String telaCadastro(Model model) {
		
		model.addAttribute("uf", new Uf());
				
		return "municipio/cadastroMunicipio";
		
	}
	
	@RequestMapping(value = "/listarMunicipio.do", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String listarMunicipio(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, IllegalAccessException {
		
		List<Municipio> listaMunicipio = new ArrayList<>();
		
		//CHAMA O METODO QUE DEFINE OS CAMPOS PARA SORT
		//this.tipoSort(request);
				
		String nome = request.getParameter("nome");
		String uf = request.getParameter("uf");
		
				
		municipioVO = new MunicipioVO();
		
		if (nome != null && !nome.equals("")) {
			
			municipioVO.setNome(nome);
			
		}
		
		if (uf != null && !uf.equals("")) {
			
			ufVO = new Uf();
			ufVO.setNome(uf);
			municipioVO.setUf(ufVO);;
			
		}
		
		String funcExcluir = request.getParameter("funcExcluir");
				
		//Para fazer uma busca paginada é necessário passar um parâmetro inteiro da posição corrente para o banco
		String posicaoString = request.getParameter("start");

		int posicao = Integer.parseInt(posicaoString);
				
		int quantidadeTotalRegistros = 0;
						
		listaMunicipio = municipioBO.listaMunicipio(posicao, 10, municipioVO, "", "");
			
		//paisBO.listaUsuarioFiltroCampos(posicao, 10, usuario, this.getSortColuna(), this.getSortAscDesc());
					
		quantidadeTotalRegistros = municipioBO.totalMunicipio(municipioVO);
								
		System.out.println("lista de retorno: " + listaMunicipio.size());
				
		if (listaMunicipio.size() == 0) {
					
			return "{\"recordsFiltered\":0,\"data\":[],\"recordsTotal\":0}";			

		}

		return geradorDadosTabela(listaMunicipio, quantidadeTotalRegistros, request.getContextPath(),funcExcluir);
		
	}
	
	@SuppressWarnings("unchecked")
	public String geradorDadosTabela(List<Municipio> listaDados, int quantidadeTotal, String contextPath, String funcExcluir) throws IllegalArgumentException, IllegalAccessException {
		
		JSONObject jsonObject = new JSONObject();
		
		if (listaDados.size() != 0) {
			
			
			jsonObject.put("recordsTotal", quantidadeTotal);
			jsonObject.put("recordsFiltered", quantidadeTotal);
			
			JSONArray dados = new JSONArray();
			
			
			for (Municipio municipio : listaDados) {
				JSONArray campos = new JSONArray();
				
				campos.add(municipio.getId());
				campos.add(municipio.getUf().getNome());
				campos.add(municipio.getNome());
								
				campos.add(municipio.getCodigoIbge());
				campos.add(municipio.getCodigoReceitaFederal());
				campos.add(municipio.getCodigoEstadual());
				
				StringBuilder sbOpcoes = new StringBuilder();
				
				//LINK PARA ALTERAR
				sbOpcoes.append("<a href=");
				sbOpcoes.append(contextPath);
				sbOpcoes.append("/municipio/mostrarMunicipio.do?id=");
				sbOpcoes.append(municipio.getId());
				sbOpcoes.append(">");
				sbOpcoes.append("<input type=\"button\" value=\"selecionar\" class=\"btn btn-success\" />");												
				sbOpcoes.append("</a>");
				
				//COLOCANDO ESPACO
				sbOpcoes.append("<span style=\"padding-left: 5px\"></span>");
								
				//LINK PARA EXCLUIR				
				sbOpcoes.append("<input type=\"button\" onclick=\"");
				sbOpcoes.append(funcExcluir);
				sbOpcoes.append("(");
				sbOpcoes.append(municipio.getId());
				sbOpcoes.append(")");
				sbOpcoes.append("\" id=\"btnExcluir\" value=\"Excluir\" class=\"btn btn-danger\" />");
				
				campos.add(sbOpcoes.toString());
				
				dados.add(campos);
			}
			
			jsonObject.put("data", dados);
		}
		
		
		return jsonObject.toString();
		
	}	
		
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listaUf.do", method = RequestMethod.GET)
	@ResponseBody
	public String carregarAutoCompleto(HttpServletRequest request,	HttpServletResponse response, ModelMap mapa) {

		String nome = request.getParameter("term");

		
		listaUf = ufRepository.listaUfParam(nome);

		System.out.println(listaUf.size());
		
		JSONArray vetor = new JSONArray();

		for (Uf u : listaUf) {

			JSONObject objeto = new JSONObject();

			objeto.put("nome", u.getNome().toString());
			objeto.put("valor", u.getId().toString());

			vetor.add(objeto);
		}

		System.out.println(vetor.toString());
		
		return vetor.toString();

	}
	
	

}
