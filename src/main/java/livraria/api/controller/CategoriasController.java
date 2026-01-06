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
import livraria.api.dto.DadosAutorDTO;
import livraria.api.dto.DadosCategoriaDto;
import livraria.api.form.CategoriaForm;
import livraria.api.service.CategoriaService;

@RestController
@RequestMapping("/Categorias")
public class CategoriasController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<DadosCategoriaDto>>  listar() {
		
		return ResponseEntity.ok(categoriaService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<DadosCategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm, UriComponentsBuilder uriBuilder) {
		
		categoriaService.save(categoriaForm);
		
		DadosCategoriaDto categoriaDto = categoriaService.consultar(categoriaForm);
		URI uri = uriBuilder.path("/Categorias/{id}").buildAndExpand(categoriaDto.getId()).toUri();
		return ResponseEntity.created(uri).body(categoriaDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosCategoriaDto> detalhar(@PathVariable Long id) {
		DadosCategoriaDto categoriaDto = categoriaService.consultar(id);
		
		if (categoriaDto != null) {
			return ResponseEntity.ok(categoriaDto);
		}

		return ResponseEntity.notFound().build();
	}
}
