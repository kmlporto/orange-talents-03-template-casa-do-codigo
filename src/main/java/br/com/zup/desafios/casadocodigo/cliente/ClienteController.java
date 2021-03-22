package br.com.zup.desafios.casadocodigo.cliente;

import br.com.zup.desafios.casadocodigo.localizacao.estado.Estado;
import br.com.zup.desafios.casadocodigo.localizacao.estado.EstadoRepository;
import br.com.zup.desafios.casadocodigo.localizacao.pais.Pais;
import br.com.zup.desafios.casadocodigo.localizacao.pais.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final PaisRepository paisRepository;
    private final EstadoRepository estadoRepository;

    public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClientePersist clientePersist){
        Pais pais = paisRepository.getOne(clientePersist.getPais_id());
        Estado estado = estadoRepository.getOne(clientePersist.getEstado_id());
        Cliente cliente = clienteRepository.save(clientePersist.convert(estado, pais));

        return new ResponseEntity<>(ClienteResponse.convert(cliente), HttpStatus.OK);
    }
}
