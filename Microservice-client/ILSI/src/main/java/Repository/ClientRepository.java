package Repository;

import org.springframework.data.repository.CrudRepository;
import models.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{

}
