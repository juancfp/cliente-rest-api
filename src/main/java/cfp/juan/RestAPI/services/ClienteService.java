package cfp.juan.RestAPI.services;

import cfp.juan.RestAPI.dto.ClienteDto;
import cfp.juan.RestAPI.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    Cliente inserir(ClienteDto cliente);

    Cliente atualizar(Long id, ClienteDto cliente);

    void deletar(Long id);

}

