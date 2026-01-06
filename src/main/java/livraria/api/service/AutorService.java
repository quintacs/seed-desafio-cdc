package livraria.api.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import livraria.api.dto.DadosAutorDto;
import livraria.api.form.AutorForm;
import livraria.api.modelo.Autor;
import livraria.api.repository.AutorRepository;
import livraria.api.util.DateUtil;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	public void save(AutorForm autorForm) {
		
		LocalDateTime instante = LocalDateTime.now();
		
		autorForm.setDataCadastro(DateUtil.formatDateTimeDMYHHMMSS(instante));
		
		Autor autor = new Autor(autorForm);
		
		autorRepository.save(autor);
	}
	
	public List<DadosAutorDto> findAll() {
		
		List<DadosAutorDto> listDadosAutor = new ArrayList<DadosAutorDto>();
		
		autorRepository.findAll().forEach(autor -> listDadosAutor.add(new DadosAutorDto(autor)));
		
		
		return listDadosAutor;
	}
	
	public Autor findByEmail(String email) {
		
	    Optional<Autor> optAutor = autorRepository.findByEmail(email);
	    
	    if(optAutor.isPresent()) {
	    	return optAutor.get();
	    }
	    return null;
	}

	public DadosAutorDto consultar(AutorForm autorForm) throws IllegalArgumentException {
		
		DadosAutorDto dadosAutorDto = autorRepository.findByEmailAndNome(autorForm.getEmail(),autorForm.getNome());
		
		return dadosAutorDto;
	}

	public DadosAutorDto consultar(Long id) {
	
		Optional<Autor> optionalAutor = autorRepository.findById(id);
		
		if(optionalAutor.isPresent()) {
			Autor autor = optionalAutor.get();
			return new DadosAutorDto(autor);
		}
		return null;
	}
}
