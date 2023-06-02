package mvc.repository;

import mvc.entity.OrderDetailsEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity, Integer> {
}
