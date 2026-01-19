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
import livraria.api.dto.DadosPedidoDto;
import livraria.api.form.PedidoForm;
import livraria.api.service.PedidoService;

@RestController
@RequestMapping("/Pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<DadosPedidoDto>>  listar() {
		
		return ResponseEntity.ok(pedidoService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<DadosPedidoDto> cadastrar(@RequestBody @Valid PedidoForm pedidoForm, UriComponentsBuilder uriBuilder) {
		
		pedidoService.save(pedidoForm);
		
		DadosPedidoDto dadosPedidoDto = pedidoService.consultar(pedidoForm);
		URI uri = uriBuilder.path("/Pedidos/{id}").buildAndExpand(dadosPedidoDto.getId()).toUri();
		return ResponseEntity.created(uri).body(dadosPedidoDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosPedidoDto> detalhar(@PathVariable Long id) {
		DadosPedidoDto dadosPedidoDto = pedidoService.consultar(id);
		
		if (dadosPedidoDto != null) {
			return ResponseEntity.ok(dadosPedidoDto);
		}

		return ResponseEntity.notFound().build();
	}
}
