package com.dev.store.db1Store.controle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.dev.store.db1Store.modelos.ItensCompra;
import com.dev.store.db1Store.modelos.Produto;
import com.dev.store.db1Store.repositorios.ProdutoRepositorio;

@Controller
public class CarrinhoControle {
	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	private List<ItensCompra> itensCompra = new ArrayList<ItensCompra>();
	
	@GetMapping("/carrinho")
	public ModelAndView chamarCarrinho() {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		return mv;
	}
	
	
	@PostMapping("/adicionarItem")
	public ModelAndView adicionarItem(@RequestParam("id") Long id) {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		Optional<Produto> produto = produtoRepositorio.findById(id);
		Produto prod = produto.get();
		ItensCompra item = new ItensCompra();
		item.setProduto(prod);
		item.setValorUnit(prod.getPreco());
		item.setQuantidade(item.getQuantidade()+1);
		item.setValorTotal(item.getQuantidade() + item.getValorUnit());

		itensCompra.add(item);
		
		mv.addObject("listaItens", itensCompra);
		
		return mv;
	}
	
	
	
}	