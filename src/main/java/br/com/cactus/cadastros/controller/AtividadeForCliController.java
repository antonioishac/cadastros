package br.com.cactus.cadastros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cactus.cadastros.model.AtividadeForCli;
import br.com.cactus.cadastros.repository.AtividadeForCliRepository;

@Controller
@RequestMapping(value = "/atividadeForCli")
public class AtividadeForCliController {
	
	@Autowired
	private AtividadeForCliRepository atividadeForCliRepository;

	@RequestMapping(value = "/cadastrar.do", method=RequestMethod.POST)
	public String salvar(AtividadeForCli atividadeForCli, Model model) {
		
		atividadeForCliRepository.salvar(atividadeForCli);
		
		model.addAttribute("atividadeForCli", new AtividadeForCli());
		
		return "cadastroAtividadeForCli";		
	}
	
	@RequestMapping(value = "/listar.do", method=RequestMethod.GET)
	public String listar(Model model){
		List<AtividadeForCli> listaAtividadeForCli = atividadeForCliRepository.todos();
		
		model.addAttribute("listaAtividadeForCli", listaAtividadeForCli);
		
		return "listaAtividadeForCli";
	}
	
}
