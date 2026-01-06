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
import livraria.api.dto.DadosPaisesDto;
import livraria.api.form.PaisesForm;
import livraria.api.service.PaisesService;

@RestController
@RequestMapping("/Paises")
public class PaisesController {

	@Autowired
	private PaisesService paisesService;
	
	@GetMapping
	public ResponseEntity<List<DadosPaisesDto>>  listar() {
		
		return ResponseEntity.ok(paisesService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<DadosPaisesDto> cadastrar(@RequestBody @Valid PaisesForm paisesForm, UriComponentsBuilder uriBuilder) {
		
		paisesService.save(paisesForm);
		
		DadosPaisesDto categoriaDto = paisesService.consultar(paisesForm);
		URI uri = uriBuilder.path("/Paises/{id}").buildAndExpand(categoriaDto.getId()).toUri();
		return ResponseEntity.created(uri).body(categoriaDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosPaisesDto> detalhar(@PathVariable Long id) {
		DadosPaisesDto categoriaDto = paisesService.consultar(id);
		
		if (categoriaDto != null) {
			return ResponseEntity.ok(categoriaDto);
		}

		return ResponseEntity.notFound().build();
	}
}
