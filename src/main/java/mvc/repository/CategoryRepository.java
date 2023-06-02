package mvc.repository;


import mvc.entity.CategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
    @Query(value = "SELECT * FROM spring_jpa_1.category", nativeQuery = true)
    List<CategoryEntity> list();
}
