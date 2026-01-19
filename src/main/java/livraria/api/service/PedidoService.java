package livraria.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import livraria.api.dto.DadosPedidoDto;
import livraria.api.form.PedidoForm;
import livraria.api.modelo.Pedido;
import livraria.api.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
    public void save(PedidoForm pedidoForm) {
		
		//LocalDateTime instante = LocalDateTime.now();
		
		Pedido autor = new Pedido(pedidoForm);
		
		pedidoRepository.save(autor);
	}
	
	public List<DadosPedidoDto> findAll() {
		
		List<DadosPedidoDto> dadosPedidoDtos = new ArrayList<DadosPedidoDto>();
		
		pedidoRepository.findAll().forEach(pedido -> dadosPedidoDtos.add(new DadosPedidoDto(pedido)));
		
		
		return dadosPedidoDtos;
	}

	public DadosPedidoDto consultar( PedidoForm pedidoForm) throws IllegalArgumentException {
		
		DadosPedidoDto dadosPedidoDto = pedidoRepository.findByCompraId(pedidoForm.getIdCompra());
		
		return dadosPedidoDto;
		
	}
	
	public DadosPedidoDto consultar(Long id) {
		
		Optional<Pedido> optional = pedidoRepository.findById(id);
		
		if(optional.isPresent()) {
			Pedido pedido = optional.get();
			return new DadosPedidoDto(pedido);
		}
		return null;
	}
}
