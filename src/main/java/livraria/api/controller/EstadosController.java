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
import livraria.api.dto.DadosEstadosDto;
import livraria.api.form.EstadosForm;
import livraria.api.service.EstadosService;

@RestController
@RequestMapping("/Estados")
public class EstadosController {
	
	@Autowired
	private EstadosService estadosService;
	
	@GetMapping
	public ResponseEntity<List<DadosEstadosDto>>  listar() {
		
		return ResponseEntity.ok(estadosService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<DadosEstadosDto> cadastrar(@RequestBody @Valid EstadosForm estadosForm, UriComponentsBuilder uriBuilder) {
		
		estadosService.save(estadosForm);
		
		DadosEstadosDto dadosEstadosDto = estadosService.consultar(estadosForm);
		URI uri = uriBuilder.path("/Estados/{id}").buildAndExpand(dadosEstadosDto.getId()).toUri();
		return ResponseEntity.created(uri).body(dadosEstadosDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosEstadosDto> detalhar(@PathVariable Long id) {
		DadosEstadosDto dadosEstadosDto = estadosService.consultar(id);
		
		if (dadosEstadosDto != null) {
			return ResponseEntity.ok(dadosEstadosDto);
		}

		return ResponseEntity.notFound().build();
	}
}
