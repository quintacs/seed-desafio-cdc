package livraria.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import livraria.api.dto.DadosPaisesDto;
import livraria.api.form.PaisesForm;
import livraria.api.modelo.Paises;
import livraria.api.repository.PaisesRepository;

@Service
public class PaisesService {

	@Autowired
	private PaisesRepository paisesRepository;
	
	public void save(@Valid PaisesForm paisesForm) {
		
		paisesRepository.save(new Paises(paisesForm));
	}
	
	public List<DadosPaisesDto> findAll() {
		
		List<DadosPaisesDto> listDadosPaises = new ArrayList<DadosPaisesDto>();
		
		paisesRepository.findAll().forEach(paises -> listDadosPaises.add(new DadosPaisesDto(paises)));
		
		return listDadosPaises;
	}

	public DadosPaisesDto consultar(PaisesForm paisesForm) throws IllegalArgumentException {
		
		DadosPaisesDto paisesDto = paisesRepository.findByNome(paisesForm.getNome());
		
		return paisesDto;
	}
	
	public DadosPaisesDto consultar(Long id) {
		
		Optional<Paises> optional = paisesRepository.findById(id);
		
		if(optional.isPresent()) {
			Paises paises = optional.get();
			return new DadosPaisesDto(paises);
		}
		return null;
	}

}
