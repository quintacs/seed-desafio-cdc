package livraria.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import livraria.api.dto.DadosAutorDTO;
import livraria.api.form.AutorForm;
import livraria.api.service.AutorService;
import livraria.api.validator.DadosAutorValidator;

@RestController
@RequestMapping("/Autores")
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@Autowired
	private DadosAutorValidator dadosAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(dadosAutorValidator);
	}
	
	@GetMapping
	public ResponseEntity<List<DadosAutorDTO>>  listar() {
		
		return ResponseEntity.ok(autorService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<DadosAutorDTO> cadastrar(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder) {
		
		autorService.save(autorForm);
		DadosAutorDTO autor = autorService.consultar(autorForm);
		URI uri = uriBuilder.path("/Autores/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(autor);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosAutorDTO> detalhar(@PathVariable Long id) {
		DadosAutorDTO dadosAutorDTO = autorService.consultar(id);
		
		if (dadosAutorDTO != null) {
			return ResponseEntity.ok(dadosAutorDTO);
		}

		return ResponseEntity.notFound().build();
	}
	
}
