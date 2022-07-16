package cfp.juan.RestAPI.repository;

import cfp.juan.RestAPI.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
