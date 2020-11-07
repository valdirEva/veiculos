package com.veiculos.demo.service;

import java.util.List;

import com.veiculos.demo.dto.VeiculoDTO;
import com.veiculos.demo.model.Veiculo;

//interface 
public interface VeiculoService {
	
	public List<Veiculo> Listar();
	
	public Veiculo buscaId(Long veiculoId);
	
	public Veiculo salvarVeiculo(VeiculoDTO veiciulo);
	
	public Veiculo atualizaVeiculo(Long veiculoId, VeiculoDTO veiculo);
	
	public void excluir(Long veiculoId);

}
