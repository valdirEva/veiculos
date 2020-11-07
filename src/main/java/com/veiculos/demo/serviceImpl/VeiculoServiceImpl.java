package com.veiculos.demo.serviceImpl;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.veiculos.demo.dto.VeiculoDTO;
import com.veiculos.demo.exceptionhandler.NegocioException;
import com.veiculos.demo.model.Veiculo;
import com.veiculos.demo.repository.VeiculoRepository;
import com.veiculos.demo.service.VeiculoService;

@Service ("VeiculoService")// componente do spring para colocar nossos serviços.
public class VeiculoServiceImpl implements VeiculoService{
	
	@Autowired // injeta a interface moradorRepository.
	private VeiculoRepository veiculoRepository;
	
	
	//retorna todos veiculos
	@Override
	public List<Veiculo> Listar() {
		return veiculoRepository.findAll();
	}
	

	
	//retorna veiculo pelo id passado como parametro
	@Override
	public Veiculo buscaId(Long veiculoId) {
if (veiculoRepository.findById(veiculoId).get()== null) {
			
			throw new NegocioException("Veículo não encontrado.");
		}
		return veiculoRepository.findById(veiculoId).get();
	}
	
	//salva um novo veiculo
	@Override
	@Transactional
	public Veiculo salvarVeiculo(VeiculoDTO veiculo){
		Veiculo veiculo2 = new Veiculo();
	
		veiculo2.setVeiculo(veiculo.getVeiculo());
		veiculo2.setMarca(veiculo.getMarca());
		veiculo2.setAno(veiculo.getAno());
		veiculo2.setDescricao(veiculo.getDescricao());
		veiculo2.setVendido(veiculo.isVendido());
		veiculo2.setCreated(OffsetDateTime.now());
		veiculoRepository.save(veiculo2);
		return veiculo2;
	}
	
	//Atualiza uma veiculo, total ou parcialmente.
	@Override
	@Transactional
	public Veiculo atualizaVeiculo(Long veiculoId, VeiculoDTO veiculo) {
		if (veiculoRepository.findById(veiculoId)== null) {
			
			throw new NegocioException("Veículo não encontrado para atualização.");
		}
		
		Veiculo veiculo2 =  veiculoRepository.findById(veiculoId).get();
		veiculo2.setIdVeiculo(veiculoId);
		
		if(veiculo.getVeiculo() != null) {
		veiculo2.setVeiculo(veiculo.getVeiculo());
		}
		
		if(veiculo.getMarca() != null) {
		veiculo2.setMarca(veiculo.getMarca());
		}
		
		if(veiculo.getAno() != null) {
		veiculo2.setAno(veiculo.getAno());
		}
		
		if(veiculo.getDescricao() != null) {
		veiculo2.setDescricao(veiculo.getDescricao());
		}
		
		if(veiculo.isVendido() == true || veiculo.isVendido() == false) {
		veiculo2.setVendido(veiculo.isVendido());
		}
		
		veiculo2.setUpdated(OffsetDateTime.now());
		veiculoRepository.save(veiculo2);
		return veiculo2;
		
	}

	
	//deleta um veiculo
	@Override
	@Transactional
	public void excluir(Long veiculoId) {
		if (veiculoRepository.findById(veiculoId) == null ) {
			throw new NegocioException("Veiculo  não enconotrado.");
		}
		veiculoRepository.deleteById(veiculoId);
		
	}
	
}

