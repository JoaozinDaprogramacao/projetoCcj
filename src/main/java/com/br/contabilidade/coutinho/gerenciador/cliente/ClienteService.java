package com.br.contabilidade.coutinho.gerenciador.cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<ClienteDto>getAll() {
		
		List<Cliente> findAll = repository.findAll();
		List<ClienteDto> clientes = new ArrayList<ClienteDto>();
		findAll.forEach(cliente -> clientes.add(
				ClienteDto.toDto(cliente)));
		
		return clientes;
	}
	
	public Cliente getById(Long id) {
		if(repository.existsById(id)) {
			return repository.getReferenceById(id);
		}
		return null;
	}

	@Transactional
	public void updateById(String idParam, String mesParam) {

		if(idParam != null && !mesParam.isEmpty()) {
			 Long id = Long.parseLong(idParam);
			 LocalDate date = LocalDate.parse(mesParam);

			 Cliente cliente = getById(id);
			 
			 if(!(cliente.getUltimoMesFeito() == date)) {
				 cliente.setUltimoMesFeito(date);
				 if(date.getMonthValue() >= (LocalDate.now().getMonthValue() - 1)) {
					 cliente.setSituacao(Situacao.OK);
				 } else {
					 cliente.setSituacao(Situacao.Atrasada);
				 }
				 
				 System.out.println(cliente.getSituacao()	);
				 
			 }
			 
		 }
		
	}

	public void save(String razaoSocialParam, String cnpjParam, String mesFeitoParam) {

		LocalDate mesFeito = null;
		Situacao situacao = null;

		
		if(razaoSocialParam.isBlank() || cnpjParam.isBlank()) {
			return;
		}
		
		if(!mesFeitoParam.isBlank()) {
			mesFeito = LocalDate.parse(mesFeitoParam);
			
			 if(mesFeito.getMonthValue() >= (LocalDate.now().getMonthValue() - 1)) {
				 situacao = Situacao.OK;
			 } else {
				 situacao = Situacao.Atrasada;
			 }
			
		}
		
		Cliente cliente = new Cliente(razaoSocialParam, cnpjParam, mesFeito, situacao);
		repository.save(cliente);
		
	}
	
	public void deleteById(Long id) {
		
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}
		
	}
}
