package cfp.juan.RestAPI.services;

import cfp.juan.RestAPI.dto.ClienteDto;
import cfp.juan.RestAPI.model.Cliente;
import cfp.juan.RestAPI.model.Endereco;
import cfp.juan.RestAPI.repository.ClienteRepository;
import cfp.juan.RestAPI.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    // operações CRUD
    @Override
    public Iterable<Cliente> buscarTodos(){
        return clienteRepository.findAll(); // retorna Iterable de Cliente
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).get(); // retorna um Optional de Cliente (caso não encontre)
    }

    @Override
    public Cliente inserir(ClienteDto cliente) {

        // já existe esse cep no bd?
        String cep = cliente.getCep();
        Endereco endereco = verificaEnderecoNoDB(cep);
        Cliente clt = new Cliente();
        clt.setId(cliente.getId());
        clt.setNome(cliente.getNome());
        clt.setEndereco(endereco);

        clienteRepository.save(clt);
        return clt;
    }

    private Endereco verificaEnderecoNoDB(String cep) {

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novo = viaCepService.consultarCep(cep);
            enderecoRepository.save(novo);
            return novo;
        });
        return endereco;

    }

    @Override
    public Cliente atualizar(Long id, ClienteDto novoCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        cliente.ifPresent(clt -> {
            clt.setNome(novoCliente.getNome());
            Endereco endereco = verificaEnderecoNoDB(novoCliente.getCep());
            clt.setEndereco(endereco);
        });
        Cliente clt = cliente.get();
        clienteRepository.save(clt);
        return clt;
    }

    @Override
    public void deletar(Long id) {
        Cliente clt = clienteRepository.findById(id).get();
        clienteRepository.delete(clt);
    }


}
