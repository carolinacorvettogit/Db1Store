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

import com.dev.store.db1Store.modelos.Compra;
import com.dev.store.db1Store.modelos.ItensCompra;
import com.dev.store.db1Store.modelos.Produto;
import com.dev.store.db1Store.repositorios.CompraRepositorio;
import com.dev.store.db1Store.repositorios.ItensCompraRepositorio;
import com.dev.store.db1Store.repositorios.ProdutoRepositorio;

@Controller
public class CarrinhoControle {
	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	private List<ItensCompra> itensCompra = new ArrayList<ItensCompra>();
	private Compra compra = new Compra();
	@Autowired
	private CompraRepositorio repositorioCompra;

	@Autowired
	private ItensCompraRepositorio repositorioItensCompra;

	private void calcTotal() {
		compra.setValorTotal(0.);
		for (ItensCompra it : itensCompra) {
			compra.setValorTotal(compra.getValorTotal() + it.getValorTotal());

		}
	}

	@GetMapping("/carrinho")
	public ModelAndView chamarCarrinho() {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		calcTotal();

		mv.addObject("compra", compra);
		mv.addObject("listaItens", itensCompra);
		return mv;
	}

	@GetMapping("/finalizar")
	public ModelAndView finalizarCarrinho() {
		ModelAndView mv = new ModelAndView("cliente/finalizar");
		calcTotal();

		mv.addObject("compra", compra);
		mv.addObject("listaItens", itensCompra);
		return mv;
	}

	@GetMapping("/confirmar")
	public ModelAndView confirmarCarrinho() {
		ModelAndView mv = new ModelAndView("cliente/mensagem");
		repositorioCompra.saveAndFlush(compra);

		for (ItensCompra comp : itensCompra) {
			comp.setCompra(compra);
			repositorioItensCompra.saveAndFlush(comp);
		}

		itensCompra = new ArrayList<>();
		compra = new Compra();

		return mv;
	}

	@PostMapping("/alterarQuantidade")
	public String alterar2Quantidade(@RequestParam("id") Long id, @RequestParam("acao") Integer acao) {

		for (ItensCompra it : itensCompra) {
			if (it.getProduto().getId().equals(id)) {
				if (acao.equals(1)) {
					if (it.getProduto().getQuantidade().equals(0)) {
						it.setQuantidade(0);
						it.setValorTotal(0.);
					} else if (it.getProduto().getQuantidade() >= it.getQuantidade() + 1) {
						it.setQuantidade(it.getQuantidade() + 1);
						it.setValorTotal(it.getQuantidade() * it.getValorUnit());
					} else {
						it.setQuantidade(it.getQuantidade());
						it.setValorTotal(it.getQuantidade() * it.getValorUnit());
					}
				} else if (acao.equals(0)) {
					if (it.getQuantidade().equals(0)) {
						it.setQuantidade(0);
						it.setValorTotal(0.);
					} else {
						it.setQuantidade(it.getQuantidade() - 1);
						it.setValorTotal(it.getQuantidade() * it.getValorUnit());
					}
				}

				break;
			}
		}
		return "redirect:/carrinho";
	}

	@PostMapping("/remover")
	public String removerProdutoCompra(@RequestParam("id") Long id) {

		for (ItensCompra it : itensCompra) {
			if (it.getProduto().getId().equals(id)) {
				itensCompra.remove(it);
				break;
			}
		}

		return "redirect:/carrinho";
	}

	@PostMapping("/adicionarItem")
	public String adicionarItem(@RequestParam("id") Long id) {
		Optional<Produto> produto = produtoRepositorio.findById(id);

		Produto prod = produto.get();

		int control = 0;
		for (ItensCompra it : itensCompra) {
			if (it.getProduto().getId().equals(prod.getId())) {
				it.setValorTotal(0.);

				if (prod.getQuantidade().equals(0)) {
					it.setQuantidade(0);
					it.setValorTotal(0.);
				} else if (prod.getQuantidade() >= it.getQuantidade() + 1) {
					it.setQuantidade(it.getQuantidade() + 1);
					it.setValorTotal(it.getQuantidade() * it.getValorUnit());
				} else {
					it.setQuantidade(it.getQuantidade());
					it.setValorTotal(it.getQuantidade() * it.getValorUnit());
				}

				control = 1;
			}
		}
		if (control == 0) {
			ItensCompra item = new ItensCompra();
			item.setProduto(prod);
			item.setValorUnit(prod.getPreco());

			if (prod.getQuantidade().equals(0)) {
				item.setQuantidade(0);
				item.setValorTotal(0.);
			} else if (prod.getQuantidade() >= item.getQuantidade() + 1) {
				item.setQuantidade(item.getQuantidade() + 1);
				item.setValorTotal(item.getQuantidade() * item.getValorUnit());
			} else {
				item.setQuantidade(item.getQuantidade());
				item.setValorTotal(item.getQuantidade() * item.getValorUnit());
			}

			itensCompra.add(item);
		}

		return "redirect:/carrinho";
	}

}