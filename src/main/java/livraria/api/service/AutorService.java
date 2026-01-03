package livraria.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.stereotype.Service;

import livraria.api.modelo.Autor;
import livraria.api.record.DadosAutor;
import livraria.api.repository.AutorRepository;

@Service
public class AutorService {

	
	@Autowired
	private AutorRepository autorRepository;

	
	
	public void save(DadosAutor dadosAutor) {
		
		LocalDateTime dataCadastro = LocalDateTime.now();
		Autor autor = new Autor( dadosAutor.nome(),dadosAutor.email(), dadosAutor.descricao(), dataCadastro);
		autorRepository.save(autor);
		
	}
	
}
