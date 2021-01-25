package com.licio.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.licio.cursomc.domain.Categoria;
import com.licio.cursomc.domain.Produto;
import com.licio.cursomc.repositories.CategoriaRepository;
import com.licio.cursomc.repositories.ProdutoRepository;
import com.licio.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pagerequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction) , orderBy);
		List<Categoria> categorias =  categoriaRepository.findAllById(ids);
//		return produtoRepository.search(nome, categorias, pagerequest);
		return produtoRepository.findDinstinctByNomeContainingAndCategoriasIn(nome, categorias, pagerequest);
	}
}
