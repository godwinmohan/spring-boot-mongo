package springbootmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import springbootmongo.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer>{

}
