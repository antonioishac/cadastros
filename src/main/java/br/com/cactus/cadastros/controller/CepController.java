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

import br.com.cactus.cadastros.model.Cep;
import br.com.cactus.cadastros.model.vo.CepVO;
import br.com.cactus.cadastros.repository.CepRepository;
import br.com.cactus.cadastros.repository.UfRepository;
import br.com.cactus.cadastros.util.Mensagem;
import br.com.cactus.cadastros.util.Mensagem.TipoMensagem;

@Controller
@RequestMapping(value = "/cep")
public class CepController {
	
	private CepVO cepVO;
	
	private Cep cep;
	
	@Autowired
	private CepRepository cepRepository;
	
	@Autowired
	private UfRepository ufRepository;
			
	@RequestMapping(value = "/listaCep.do")
	public String telaLista(Model model){
		
		model.addAttribute("listaUf", ufRepository.todos());
		return "cep/listaCep";		
		
	}
	
	@RequestMapping(value = "/cadastroCep.do")
	public String telaCadastro(Model model) {
		
		model.addAttribute("cep", new Cep());
		model.addAttribute("listaUf", ufRepository.todos());
		
		return "cep/cadastroCep";
		
	}
	
	@RequestMapping(value = "/listarCep.do", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String listarCep(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, IllegalAccessException {
		
		List<Cep> listaCep = new ArrayList<>();
		
		//CHAMA O METODO QUE DEFINE OS CAMPOS PARA SORT
		//this.tipoSort(request);
				
		String logradouro = request.getParameter("logradouro");
		
				
		cepVO = new CepVO();
		
//		if (logradouro != null && !logradouro.equals("")) {
//			
//			cepVO.setLogradouro(logradouro);
//			
//		}
		
		cepVO.setLogradouro(logradouro);
				
		String funcExcluir = request.getParameter("funcExcluir");
				
		//Para fazer uma busca paginada é necessário passar um parâmetro inteiro da posição corrente para o banco
		String posicaoString = request.getParameter("start");

		int posicao = Integer.parseInt(posicaoString);
				
		int quantidadeTotalRegistros = 0;
						
		listaCep = cepRepository.listaCep(posicao, 10, cepVO, "", "");
			
		//paisBO.listaUsuarioFiltroCampos(posicao, 10, usuario, this.getSortColuna(), this.getSortAscDesc());
					
		quantidadeTotalRegistros = cepRepository.totalCep(cepVO);
								
		System.out.println("lista de retorno: " + listaCep.size());
				
		if (listaCep.size() == 0) {
					
			return "{\"recordsFiltered\":0,\"data\":[],\"recordsTotal\":0}";			

		}

		return geradorDadosTabela(listaCep, quantidadeTotalRegistros, request.getContextPath(),funcExcluir);
		
	}
	
	@SuppressWarnings("unchecked")
	public String geradorDadosTabela(List<Cep> listaDados, int quantidadeTotal, String contextPath, String funcExcluir) throws IllegalArgumentException, IllegalAccessException {
		
		JSONObject jsonObject = new JSONObject();
		
		if (listaDados.size() != 0) {
			
			
			jsonObject.put("recordsTotal", quantidadeTotal);
			jsonObject.put("recordsFiltered", quantidadeTotal);
			
			JSONArray dados = new JSONArray();
			
			
			for (Cep cep : listaDados) {
				JSONArray campos = new JSONArray();
				
				campos.add(cep.getId());
				campos.add(cep.getLogradouro());
				campos.add(cep.getCep());
				campos.add(cep.getMunicipio());
				campos.add(cep.getUf());
								
				StringBuilder sbOpcoes = new StringBuilder();
				
				//LINK PARA ALTERAR
				sbOpcoes.append("<a href=");
				sbOpcoes.append(contextPath);
				sbOpcoes.append("/cep/mostrarCep.do?id=");
				sbOpcoes.append(cep.getId());
				sbOpcoes.append(">");
				sbOpcoes.append("<input type=\"button\" value=\"selecionar\" class=\"btn btn-success\" />");												
				sbOpcoes.append("</a>");
				
				//COLOCANDO ESPACO
				sbOpcoes.append("<span style=\"padding-left: 5px\"></span>");
								
				//LINK PARA EXCLUIR				
				sbOpcoes.append("<input type=\"button\" onclick=\"");
				sbOpcoes.append(funcExcluir);
				sbOpcoes.append("(");
				sbOpcoes.append(cep.getId());
				sbOpcoes.append(")");
				sbOpcoes.append("\" id=\"btnExcluir\" value=\"Excluir\" class=\"btn btn-danger\" />");
				
				campos.add(sbOpcoes.toString());
				
				dados.add(campos);
			}
			
			jsonObject.put("data", dados);
		}
		
		
		return jsonObject.toString();
		
	}
	
	@RequestMapping(value = "/salvarCep.do", method = RequestMethod.POST)
	public ModelAndView gravar(Cep cep, HttpServletRequest request, ModelMap map){
		
		try {
			
			if (cep.getCep() != null) {
				cep.setCep(cep.getCep().replace("-", ""));
			}
			
			if(cep.getId() == null) {
								
				cepRepository.salvar(cep);
				map.put("mensagem", new Mensagem("Cep salvo com sucesso", TipoMensagem.SUCESSO));
				map.put("cep", new Cep());
				
			}else {
				
				cepRepository.atualizar(cep);
				map.put("mensagem", new Mensagem("Cep atualizado com sucesso", TipoMensagem.AVISO));
				map.put("cep", new Cep());
				
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			map.addAttribute("mensagem", new Mensagem("Erro na transação", TipoMensagem.ERRO));
		}
		
		return new ModelAndView("/mensagem", map);
		
	}
	
	@RequestMapping(value = "/mostrarCep.do")
	public String mostrar(Integer id, Model model){
		
		//cep = new Cep();
		
		cep = cepRepository.pesquisarPorId(id);
		
		model.addAttribute("cep", cep);
		model.addAttribute("listaUf", ufRepository.todos());
		
		return "cep/cadastroCep";
	}
	
	@RequestMapping(value = "/removeCep.do", method=RequestMethod.GET)
	public void excluir(Integer id, HttpServletResponse response) {
		
		try {
			cep = cepRepository.pesquisarPorId(id);
			
			cepRepository.excluir(cep);
			
			response.setStatus(200);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
