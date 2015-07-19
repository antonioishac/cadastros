package br.com.cactus.cadastros.repository.impl;

import org.springframework.stereotype.Repository;

import br.com.cactus.cadastros.model.AtividadeForCli;
import br.com.cactus.cadastros.repository.AtividadeForCliRepository;

@Repository("atividadeForCliRepository")
public class AtividadeForCliRepositoryImpl 
	extends GenericRepositoryImpl<AtividadeForCli> implements AtividadeForCliRepository {

}
