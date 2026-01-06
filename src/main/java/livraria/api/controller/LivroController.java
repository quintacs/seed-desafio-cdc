package livraria.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import livraria.api.dto.DadosLivroDto;
import livraria.api.form.LivroForm;
import livraria.api.service.LivroService;

@RestController
@RequestMapping("/Livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping
	public ResponseEntity<List<DadosLivroDto>>  listar() {
		
		return ResponseEntity.ok(livroService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<DadosLivroDto> cadastrar(@RequestBody @Valid LivroForm livroForm, UriComponentsBuilder uriBuilder) {
		
		livroService.save(livroForm);
		
		DadosLivroDto dadosLivroDto = livroService.consultar(livroForm);
		URI uri = uriBuilder.path("/Livros/{id}").buildAndExpand(dadosLivroDto.getId()).toUri();
		return ResponseEntity.created(uri).body(dadosLivroDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosLivroDto> detalhar(@PathVariable Long id) {
		DadosLivroDto dadosLivroDto = livroService.consultar(id);
		
		if (dadosLivroDto != null) {
			return ResponseEntity.ok(dadosLivroDto);
		}

		return ResponseEntity.notFound().build();
	}
}
