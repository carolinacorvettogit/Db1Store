package com.dev.store.db1Store.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="carrinho")
public class Carrinho {
	public Carrinho() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Double getQuantidadeItem() {
		return quantidadeItem;
	}


	public void setQuantidadeItem(Double quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Produto produto;
	
	 
	private Double quantidadeItem=0.;
	
}
