package com.licio.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.licio.cursomc.domain.Categoria;
import com.licio.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
//	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat where obj.nome LIKE %:nome% AND cat IN :categorias")
//	Page<Produto> search(@Param("nome") String nome,@Param("categorias") List<Categoria > categorias, Pageable pagerequest);

	@Transactional(readOnly = true)
	Page<Produto> findDinstinctByNomeContainingAndCategoriasIn(String nome, List<Categoria > categorias, Pageable pagerequest);
}
