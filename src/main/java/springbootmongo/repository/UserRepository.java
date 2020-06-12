package springbootmongo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import springbootmongo.model.User;

public interface UserRepository extends ElasticsearchRepository<User, String>{

}
