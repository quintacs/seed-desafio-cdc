package livraria.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import livraria.api.dto.DadosCompraDto;
import livraria.api.form.CompraForm;
import livraria.api.modelo.Compra;
import livraria.api.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private CompraRepository compraRepository;

	public void save(CompraForm compraForm) {
		
		//LocalDateTime instante = LocalDateTime.now();
		
		Compra compra = new Compra(compraForm);
		
		compraRepository.save(compra);
	}
	
	public List<DadosCompraDto> findAll() {
		
		List<DadosCompraDto> dadosCompraDtos = new ArrayList<DadosCompraDto>();
		
		compraRepository.findAll().forEach(compra -> dadosCompraDtos.add(new DadosCompraDto(compra)));
		
		
		return dadosCompraDtos;
	}

	public DadosCompraDto consultar( CompraForm compraForm) throws IllegalArgumentException {
		
		DadosCompraDto dadosCompraDto = compraRepository.findByNome(compraForm.getNome());
		
		return dadosCompraDto;
		
	}
	
	public DadosCompraDto consultar(Long id) {
		
		Optional<Compra> optional = compraRepository.findById(id);
		
		if(optional.isPresent()) {
			Compra compra = optional.get();
			return new DadosCompraDto(compra);
		}
		return null;
	}
}
