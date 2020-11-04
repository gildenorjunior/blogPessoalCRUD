package org.generation.blogPessoal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.generation.blogPessoal.model.PostagemModel;
import org.generation.blogPessoal.repository.PostagemRepository;

@RestController
@CrossOrigin("*")//Aqui significa que vai rodar em qulquer navegador- celular ou desktop
@RequestMapping("/postagem")
public class PostagemController implements WebMvcConfigurer
{

	
	//INJETANDO O REPOSITORY
	@Autowired
	private PostagemRepository repository;
	

	@GetMapping 
	public ResponseEntity<List<PostagemModel>> findAllPostagem() 
	{		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<PostagemModel>findByIdPostagem(@PathVariable Long id) 
	{		
		return repository.findById(id)
				.map(postagemId -> ResponseEntity.ok(postagemId))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/titulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> findAllByTitulo(@PathVariable String titulo) 
	{		
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
}