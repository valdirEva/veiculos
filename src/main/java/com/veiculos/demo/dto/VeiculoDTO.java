package com.veiculos.demo.dto;

public class VeiculoDTO {
	private String veiculo;
	private String marca;
	private Long ano;
	private String descricao;
	private  boolean vendido;
	
	
	
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Long getAno() {
		return ano;
	}
	public void setAno(Long ano) {
		this.ano = ano;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isVendido() {
		return vendido;
	}
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	
	

}
