package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	@ApiOperation(value="Retorna Uma Lista de Produtos")
	@GetMapping(value="/produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}
	@ApiOperation(value="Retorna Produto Unico")
	@GetMapping(value="/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
		
	}
	@ApiOperation(value="Salva Um novo produto  ")
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto ) {
		
		return produtoRepository.save(produto);
		
		
	}
	@ApiOperation(value="Deleta um  Produto")
	@DeleteMapping("/produto")
	void deletaProduto(@RequestBody Produto produto ) {
		
		produtoRepository.delete(produto);
	}	
	@ApiOperation(value="Atualiza Indormacoes de um Produto")
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody Produto produto ) {
		
		return produtoRepository.save(produto);
	}	
}
