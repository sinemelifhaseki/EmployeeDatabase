package hello;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JobTitleRepo extends CrudRepository<JobTitleEntity, Long> {
//	List<JobTitleEntity> findByCategory(String category);

}