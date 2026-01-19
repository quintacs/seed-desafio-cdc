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
import livraria.api.dto.DadosItenPedidoDto;
import livraria.api.form.ItenPedidoForm;
import livraria.api.service.ItenPedidoService;

@RestController
@RequestMapping("/ItenPedidos")
public class ItenPedidoController {

	@Autowired
	private ItenPedidoService itenPedidoService;
	
	@GetMapping
	public ResponseEntity<List<DadosItenPedidoDto>>  listar() {
		
		return ResponseEntity.ok(itenPedidoService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<DadosItenPedidoDto> cadastrar(@RequestBody @Valid ItenPedidoForm itenPedidoForm, UriComponentsBuilder uriBuilder) {
		
		itenPedidoService.save(itenPedidoForm);
		
		DadosItenPedidoDto dadosItenPedidoDto = itenPedidoService.consultar(itenPedidoForm);
		URI uri = uriBuilder.path("/ItenPedidos/{id}").buildAndExpand(dadosItenPedidoDto.getId()).toUri();
		return ResponseEntity.created(uri).body(dadosItenPedidoDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosItenPedidoDto> detalhar(@PathVariable Long id) {
		DadosItenPedidoDto dadosItenPedidoDto = itenPedidoService.consultar(id);
		
		if (dadosItenPedidoDto != null) {
			return ResponseEntity.ok(dadosItenPedidoDto);
		}

		return ResponseEntity.notFound().build();
	}
}
