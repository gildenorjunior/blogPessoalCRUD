package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TemaRepository extends JpaRepository<Tema, Long>{

	//de acordo com o que o cliente digitar ele vai pegar tudo que contem naquela palavra 
	//ignorando maiusculo ou minusculo pegando como parametro a descricao
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
