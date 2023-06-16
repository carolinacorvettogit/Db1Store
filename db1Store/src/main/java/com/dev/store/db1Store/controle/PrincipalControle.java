package com.dev.store.db1Store.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalControle {
	
	@GetMapping("/admin")
	public String acessarPrincipal() {
		return "adm/home";  
	}
	
}
