package br.com.cactus.cadastros.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import br.com.cactus.cadastros.model.vo.LinkGridVO;

public class UtilFuncoes {
	
	public static final String SUCESSO = "SUCESSO";
	public static final String FALHA = "FALHA";
	
	/**
	 * Formatador padrão para apresentação
	 */
	private static final SimpleDateFormat formatadorApresentacaoDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	/**
	 * Gera um conjunto de dados que serão apresentados na grid ao usuário
	 * @param listaDados
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String geradorDadosTabela(List<?> listaDados, long quantidadeTotal) throws IllegalArgumentException, IllegalAccessException{
		
		JSONObject jsonObjeto = new JSONObject();
		
		if(listaDados.size() != 0){
			
			jsonObjeto.put("recordsTotal", quantidadeTotal);
			jsonObjeto.put("recordsFiltered", quantidadeTotal);
			//jsonObjeto.put("data", value)
			JSONArray dados = new JSONArray();
			
			
			for (Object object : listaDados) {
				JSONArray vetorCampos = new JSONArray();
				
				Class classe = object.getClass();
				
				Field[] campos = classe.getDeclaredFields();
				
				for (Field campo : campos) {
					
					
					campo.setAccessible(true);
					Object valorAtributo = campo.get(object);
					
					//Caso o objeto não seja nulo
					if(valorAtributo != null){
						
						//Casos de data
						if(valorAtributo instanceof Date){
							
							valorAtributo = formatadorApresentacaoDateTime.format(((Date)valorAtributo));
						}
						
						//Casos de link na grid
						if(valorAtributo instanceof LinkGridVO){
							
							valorAtributo = "<a href=\"" + ((LinkGridVO)valorAtributo).getUrl() + "&id=" + ((LinkGridVO)valorAtributo).getParametro() + "\">" + ((LinkGridVO)valorAtributo).getLinkGrid() + "</a>";
						}
						
						vetorCampos.add(valorAtributo);
					}
					else{
						vetorCampos.add("");
					}
					
				}
				
				dados.add(vetorCampos);
			}
			 
			jsonObjeto.put("data", dados);
			
		}
				
		System.out.println(jsonObjeto.toJSONString());
		
		return jsonObjeto.toString();
	}
	
	/**
	 * Método responsável pela criação do objeto de messages para todo o projeto
	 * @return
	 */
	public static Map<String,Object> recuperaLocaleAplicacao(){
		
		
		ResourceBundle resource = ResourceBundle.getBundle("br/com/cactus/messages/messages");
		
		Map<String,Object> msgs = new HashMap<String,Object>();
		
		
		Iterator<String> iterador = resource.keySet().iterator();
		
		while(iterador.hasNext()){
			
			String chave = iterador.next();
			
			msgs.put(chave, resource.getString(chave));
		}
		
		return msgs;
	}
	
	
	/**
	 * Altera o Locale da aplicação de acordo com um Locale recebido como parâmetro
	 * @return
	 */
	public static Map<String,Object> alterarLocaleAplicacao(Locale locale){
		
		
		ResourceBundle resource = ResourceBundle.getBundle("br/com/cactus/messages/messages",locale);
		
		Map<String,Object> msgs = new HashMap<String,Object>();
		
		
		Iterator<String> iterador = resource.keySet().iterator();
		
		while(iterador.hasNext()){
			
			String chave = iterador.next();
			
			msgs.put(chave, resource.getString(chave));
		}
		
		return msgs;
	}

}
