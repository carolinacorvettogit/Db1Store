package com.dev.store.db1Store.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.store.db1Store.repositorios.ProdutoRepositorio;

@Controller
public class IndexControle {
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@GetMapping("/")
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("listaProdutos", produtoRepositorio.findAll());
		return mv;  
	}
	
}

