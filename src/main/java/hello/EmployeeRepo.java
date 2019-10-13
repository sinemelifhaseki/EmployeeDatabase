package hello;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Long> {
//	List<JobTitleEntity> findByCategory(String category);

}