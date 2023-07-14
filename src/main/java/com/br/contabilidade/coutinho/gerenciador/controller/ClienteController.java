package com.br.contabilidade.coutinho.gerenciador.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.contabilidade.coutinho.gerenciador.cliente.ClienteService;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@PostMapping("/cadastrar")
	public String saveCliente(
			@RequestParam("razaoSocial") String razaoSocialParam,
			@RequestParam("cnpj") String cnpjParam,
			@RequestParam("mesFeito") String mesFeitoParam) {
		
		service.save(razaoSocialParam, cnpjParam, mesFeitoParam);
		
		
		return "redirect:/index";
	}
	
}
