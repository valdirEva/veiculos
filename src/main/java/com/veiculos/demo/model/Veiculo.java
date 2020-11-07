package com.veiculos.demo.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity // Mapeamento da entidade
@Table(name = "veiculo") //Mapeamento do nome da tabela
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idVeiculo")
	private Long idVeiculo;
	
	
	@Column(name = "veiculo ", unique = true, length = 30, nullable = false)
	private String veiculo;
	
	@Column(name = "marca ", unique = true, length = 30, nullable = false)
	private String marca;
	
	@Column(name = "ano",nullable = false)
	private Long ano;
	
	@Column(name = "descricao",  length = 30, nullable = false)
	private String descricao;
	
	
	@Column(name = "vendido", nullable = false)
	private  boolean vendido;
	
	
	@Column(name = "created", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonProperty(access = Access.READ_ONLY)
	private  OffsetDateTime created;
	
	@Column(name = "updated")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonProperty(access = Access.READ_ONLY)
	private  OffsetDateTime updated;
	
	

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
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

	public OffsetDateTime getCreated() {
		return created;
	}

	public void setCreated(OffsetDateTime created) {
		this.created = created;
	}

	public OffsetDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(OffsetDateTime updated) {
		this.updated = updated;
	}
	
	
	
}

