package com.lojalivro.apirest.resources;

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

import com.lojalivro.apirest.models.Livro;
import com.lojalivro.apirest.repository.LojaLivroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Loja de Livros")
@CrossOrigin(origins="*")
public class LivroResource {
	
	@Autowired
	LojaLivroRepository lojaLivroRepository;
	
	@GetMapping("/livros")
	@ApiOperation(value="Retorna a lista de livros da loja")
	public List<Livro> listaLivros(){
		return lojaLivroRepository.findAll();
	}
	
	@GetMapping("/livro/{id}")
	@ApiOperation(value="Retorna um livro através de um ID")
	public Livro listaLivroUnico(@PathVariable(value="id") long id){
		return lojaLivroRepository.findById(id);
	}
	
	@PostMapping("/livro")
	@ApiOperation(value="Adiciona um novo livro na loja")
	public Livro salvalivro(@RequestBody Livro livro) {
		return lojaLivroRepository.save(livro);
	}

	@DeleteMapping("/livro")
	@ApiOperation(value="Deleta um livro do banco de dados da loja")
	public void deletalivro(@RequestBody Livro livro) {
		lojaLivroRepository.delete(livro);
	}
	
	@PutMapping("/livro")
	@ApiOperation(value="Atualiza um livro no banco de dados da loja")
	public Livro atualizalivro(@RequestBody Livro livro) {
		return lojaLivroRepository.save(livro);
	}
	
}
