package com.dev.store.db1Store.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.store.db1Store.modelos.Carrinho;

public interface CarrinhoRepositorio extends JpaRepository<Carrinho, Long> {
	

}
