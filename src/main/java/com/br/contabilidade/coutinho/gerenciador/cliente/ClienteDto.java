package com.br.contabilidade.coutinho.gerenciador.cliente;

import java.time.LocalDate;

public record ClienteDto(
		Long id,
		String razaoSocial,
		String cnpj,
		LocalDate ultimoMesFeito,
		Situacao situacao){

	public static ClienteDto toDto(Cliente cliente) {
		return new ClienteDto(cliente.getId(),
				cliente.getRazaoSocial(),
				cliente.getCnpj(),
				cliente.getUltimoMesFeito(),
				cliente.getSituacao());
	}
	
}
