package com.dev.store.db1Store.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.store.db1Store.modelos.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
	

}
