package com.dev.store.db1Store.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="compra")
public class Compra {
	public Compra() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Carrinho getCarrinho() {
		return carrinho;
	}


	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}


	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@OneToOne
	private Carrinho carrinho;
	
	 
	private Double valorTotal;
	
	

}
