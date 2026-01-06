package livraria.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import livraria.api.dto.DadosEstadosDto;
import livraria.api.form.EstadosForm;
import livraria.api.modelo.Estados;
import livraria.api.repository.EstadosRepository;

@Service
public class EstadosService {

	@Autowired
	private EstadosRepository estadosRepository;

public void save(EstadosForm estadosForm) {
		
		//LocalDateTime instante = LocalDateTime.now();
		
		Estados autor = new Estados(estadosForm);
		
		estadosRepository.save(autor);
	}
	
	public List<DadosEstadosDto> findAll() {
		
		List<DadosEstadosDto> dadosEstadosDtos = new ArrayList<DadosEstadosDto>();
		
		estadosRepository.findAll().forEach(estados -> dadosEstadosDtos.add(new DadosEstadosDto(estados)));
		
		
		return dadosEstadosDtos;
	}

	public DadosEstadosDto consultar( EstadosForm estadosForm) throws IllegalArgumentException {
		
		DadosEstadosDto dadosEstadosDto = estadosRepository.findByNome(estadosForm.getNome());
		
		return dadosEstadosDto;
		
	}
	
	public DadosEstadosDto consultar(Long id) {
		
		Optional<Estados> optional = estadosRepository.findById(id);
		
		if(optional.isPresent()) {
			Estados estados = optional.get();
			return new DadosEstadosDto(estados);
		}
		return null;
	}

	public boolean contain(Long idPais) {
		return estadosRepository.contain(idPais);
	}
	
}
