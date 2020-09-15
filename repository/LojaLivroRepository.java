package com.lojalivro.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojalivro.apirest.models.Livro;

@Repository
public interface LojaLivroRepository extends JpaRepository<Livro, Long>{

	Livro findById(long id);
		
}
