package cfp.juan.RestAPI.repository;

import cfp.juan.RestAPI.model.Cliente;
import cfp.juan.RestAPI.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// interface para pegar endereco
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}
