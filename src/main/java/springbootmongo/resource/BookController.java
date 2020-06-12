package springbootmongo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springbootmongo.model.Book;
import springbootmongo.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@PostMapping("/addBook")
	@CrossOrigin(origins = "http://localhost:4200")
	public String saveBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Book Added" + book.getId();
	}

	@GetMapping("/findAllBooks")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getById(@PathVariable int id) {
		return bookRepository.findById(id);
	}

	@DeleteMapping("/findAllBooks/{id}")
	public void deleteBooks(@PathVariable int id) {
		bookRepository.deleteById(id);
	}
}
