package springbootmongo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springbootmongo.model.User;
import springbootmongo.repository.UserRepository;

@RestController
public class UserCotroller {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User user) {
		userRepository.save(user);
		return "User Saved" + user.getId();

	}

}
