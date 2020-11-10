package org.generation.blogPessoal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.generation.blogPessoal.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	//chamada para titulo
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	
	@Query(value = "select * from tb_postagem where ano > 2012", nativeQuery= true)
	List<Postagem> findAllMaior();
	
	@Query(value = "select * from tb_postagem ORDER BY ano DESC", nativeQuery= true)
	List<Postagem> anoDesc();
	
	@Query(value = "select * from tb_postagem ORDER BY ano ASC ", nativeQuery= true)
	List<Postagem> anoAsc();
	
	@Query(value = "select * from tb_postagem where ano >= 2011 and ano <= 2013", nativeQuery= true)
	List<Postagem> anoIntervalo();
	
	
//	esse é pra pegar o ano, mês ou dia, da coluna data de postagem
//	ao invés de criar uma coluna ano
//	Select day(data) from teste;
//	Select month(data) from teste;
//	Select year(data) from teste where year(data) < 2010;
//	Select day(data) from teste;


}