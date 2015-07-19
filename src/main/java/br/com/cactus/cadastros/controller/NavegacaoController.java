package br.com.cactus.cadastros.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cactus.cadastros.model.AtividadeForCli;

@Controller
public class NavegacaoController {
	
	@RequestMapping(value = "/preparaCadastroAtividadeForCli.do")
	public String redirecionaCadastroAtividadeForCli(Map<String, Object> map) {
		
		map.put("atividadeForCli", new AtividadeForCli());

		return "cadastroAtividadeForCli";
	}	
}