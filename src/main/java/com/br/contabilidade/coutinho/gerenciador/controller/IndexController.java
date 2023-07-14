package com.br.contabilidade.coutinho.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.contabilidade.coutinho.gerenciador.cliente.ClienteDto;
import com.br.contabilidade.coutinho.gerenciador.cliente.ClienteService;
import com.br.contabilidade.coutinho.gerenciador.cliente.Situacao;


@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public String getHtml(Model model) {
		
		List<ClienteDto> clientes = service.getAll();
		Situacao ok = Situacao.OK;
		Situacao atrasada = Situacao.Atrasada;
		
		int quantidadeAtrasada = 0;
		
		for (ClienteDto cliente : clientes) {
			if(cliente.situacao() == Situacao.Atrasada) {
				quantidadeAtrasada++;
			}
		}
		
		model.addAttribute("clientes", clientes);
		model.addAttribute("ok", ok);
		model.addAttribute("atrasada", atrasada);
		model.addAttribute("quantidadeAtrasada", quantidadeAtrasada);
		
		return "index.html";
	}
	
	@PostMapping("/descartar")
	public String refresh(Model model) {
		return getHtml(model);
	}
	
	@PostMapping("/excluir")
	public String excluir(@RequestParam("id") String idParam) {
		
		Long id = Long.parseLong(idParam);
		service.deleteById(id);
		
		return "redirect:/index";
	}
	
	 @PostMapping("/salvar")
	    public String salvar(@RequestParam("mesInput") String mesParam, 
	    		@RequestParam("id") String idParam) {

		 service.updateById(idParam ,mesParam);
		 
		 return "redirect:/index";
    
	 }
	 
	 @GetMapping("/cadastrar")
	 public String cadastrarCliente() {
		 return "cadastrar.html";
	 }
		
	
}
