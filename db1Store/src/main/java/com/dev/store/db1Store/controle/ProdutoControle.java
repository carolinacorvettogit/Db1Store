package com.dev.store.db1Store.controle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


import java.io.File;

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



import com.dev.store.db1Store.modelos.Produto;
import com.dev.store.db1Store.repositorios.ProdutoRepositorio;

@Controller
public class ProdutoControle {
	
	private static String caminhoFoto = "C:\\Users\\ca_ch\\OneDrive\\Documentos\\imgsdb1store\\";
	

	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@GetMapping("/home")
	public String acessarPrincipal() {
		return "adm/home";  
	}
	
	@GetMapping("adm/produto/cadastrar")
	public ModelAndView acessarCadastrarProduto(Produto produto) {
		ModelAndView mv = new ModelAndView("adm/produto/cadastro");
		mv.addObject("produto", produto);
		return mv;  
	}
	
	@GetMapping("adm/produto/listar")
	public ModelAndView acessarListarProduto() {
		ModelAndView mv = new ModelAndView("adm/produto/lista");
		mv.addObject("listaProdutos", produtoRepositorio.findAll());
		return mv;  
	}
	
	
	@GetMapping("/editar/{id}")
	public ModelAndView acessarEditarProduto(@PathVariable("id") Long id) {
		Optional<Produto> produto = produtoRepositorio.findById(id);
		return acessarCadastrarProduto(produto.get());
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView acessarDeletarProduto(@PathVariable("id") Long id) {
		Optional<Produto> produto = produtoRepositorio.findById(id);
		produtoRepositorio.delete(produto.get());
		return acessarListarProduto();
	}
	
	@GetMapping("/mostrarFoto/{foto}")
	@ResponseBody
	public byte[] acessarFotoProduto(@PathVariable("foto") String foto) throws IOException {
		File fotoArquivo = new File(caminhoFoto+foto);
		if(foto!=null || foto.trim().length() >0) {
			return Files.readAllBytes(fotoArquivo.toPath());
		}
		return null;
	}
	
	@PostMapping("/salvar")
	public ModelAndView acessarSalvarProduto(@Valid Produto produto, BindingResult result, @RequestParam("file") MultipartFile arquivo ) {
		if(result.hasErrors()) {
			return acessarCadastrarProduto(produto);
		}
		produtoRepositorio.saveAndFlush(produto);
		
		try {
			if(!arquivo.isEmpty()) {
				byte[] bytes = arquivo.getBytes();
				Path caminho = Paths.get(caminhoFoto+String.valueOf(produto.getId())+arquivo.getOriginalFilename());
				Files.write(caminho, bytes);
				produto.setFoto(String.valueOf(produto.getId())+arquivo.getOriginalFilename());
				produtoRepositorio.saveAndFlush(produto);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return acessarCadastrarProduto(new Produto());
	}
	
}
