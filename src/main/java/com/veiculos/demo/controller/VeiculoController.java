package com.veiculos.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.veiculos.demo.dto.VeiculoDTO;
import com.veiculos.demo.model.Veiculo;
import com.veiculos.demo.service.VeiculoService;

@RestController // anotacao para indicar ao spring que a classe é controller.
@CrossOrigin
@RequestMapping("/veiculos") // indica onde estao todas requisições.
public class VeiculoController {

	//Injeção da classe veiculo
	@Autowired
	private VeiculoService veiculoService;
	
	//Mapeamento para buscar todos veiculos
	@ResponseStatus(HttpStatus.OK)
	@GetMapping (value = "/")
	public List<Veiculo> Listar() {
		return veiculoService.Listar();
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping (value = "/{id}")
	public Veiculo buscaId(@PathVariable Long id) {
		return veiculoService.buscaId(id);
	}
	
	//Mapeamento para criar um veiculo
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/")
	public Veiculo adicionar(@RequestBody  VeiculoDTO veiculo) {
		return veiculoService.salvarVeiculo(veiculo);
	}
	


	//Mapeamento para atualizar um veiculo
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Veiculo atualizaVeiculo(@PathVariable Long id, @RequestBody  VeiculoDTO veiculo) {
		return veiculoService.atualizaVeiculo(id, veiculo); 
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Veiculo atualizaVeiculoParcial(@PathVariable Long id, @RequestBody  VeiculoDTO veiculo) {
		return veiculoService.atualizaVeiculo(id, veiculo); 
	}

	//Mapeamento para deletar uma veiculo pela palca.
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@PathVariable Long id) {
		
		veiculoService.excluir(id);
		
	}
}
