package com.dev.store.db1Store.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.store.db1Store.modelos.Compra;

public interface CompraRepositorio extends JpaRepository<Compra, Long> {
	

}
