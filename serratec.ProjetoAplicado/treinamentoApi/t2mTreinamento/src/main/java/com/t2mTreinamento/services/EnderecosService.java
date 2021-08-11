package com.t2mTreinamento.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.dtos.EnderecosDTO;
import com.t2mTreinamento.entities.Enderecos;
import com.t2mTreinamento.repositories.EnderecosRepository;

@Service
public class EnderecosService {

	@Autowired
	public EnderecosRepository enderecosRepository;

	public void converteEndrParaDTO(Enderecos endr, EnderecosDTO endrDTO) {

		endrDTO.setIdEnderecos(endr.getIdEnderecos());
		endrDTO.setBairro(endr.getBairro());
		endrDTO.setCep(endr.getCep());
		endrDTO.setCidade(endr.getCidade());
		endrDTO.setComplemento(endr.getComplemento());
		endrDTO.setEstado(endr.getEstado());
		endrDTO.setNumero(endr.getNumero());
		endrDTO.setPais(endr.getPais());
		endrDTO.setRua(endr.getRua());
	}

	public Enderecos findById(Long id) {
		return enderecosRepository.findById(id).get();
	}

	public Enderecos findByIsAtivoAndIdEnderecos(Long idEnderecos) {
		return enderecosRepository.findByIsAtivoAndIdEnderecos(1, idEnderecos);
	}

	public EnderecosDTO findByIsAtivoAndIdEnderecosDTO(Long idEnderecos) {
		Enderecos endr = enderecosRepository.findByIsAtivoAndIdEnderecos(1, idEnderecos);
		EnderecosDTO endrDTO = new EnderecosDTO();

		converteEndrParaDTO(endr, endrDTO);
		return endrDTO;
	}

	public List<Enderecos> findAll() {
		return enderecosRepository.findAll();
	}

	public List<Enderecos> findByIsAtivo() {
		return enderecosRepository.findByIsAtivo(1);
	}

	public List<EnderecosDTO> findAllDTO() {
		List<EnderecosDTO> listEndrs = new ArrayList<>();
		for (Enderecos endr : enderecosRepository.findByIsAtivo(1)) {
			EnderecosDTO endrDTO = new EnderecosDTO();
			converteEndrParaDTO(endr, endrDTO);
			listEndrs.add(endrDTO);
		}
		return listEndrs;
	}

	public Long Count() {
		return enderecosRepository.count();
	}

	public Enderecos save(Enderecos endereco) {
		endereco.setIsAtivo(1);
		Enderecos novoEndereco = enderecosRepository.save(endereco);
		// SERVIÇO DE ENTIDADE DE LIGAÇÃO (?)
		if (novoEndereco != null) {
			return novoEndereco;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		// DELETAR DA LISTA DE REGISTROS ATIVOS
		if (id != null && enderecosRepository.findById(id).get().getIsAtivo() == 1) {
			Enderecos endereco = enderecosRepository.findByIsAtivoAndIdEnderecos(1, id);
			endereco.setIsAtivo(0);
			enderecosRepository.save(endereco);
			return true;
		} else {
			return false;
		}
	}

	public Enderecos update(Enderecos endereco, Long id) {
		endereco.setIdEnderecos(id);
		endereco.setIsAtivo(1);
		return enderecosRepository.save(endereco);
	}
}
