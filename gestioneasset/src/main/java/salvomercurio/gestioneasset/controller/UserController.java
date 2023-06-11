package salvomercurio.gestioneasset.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import salvomercurio.gestioneasset.model.User;
import salvomercurio.gestioneasset.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Page<User>> findAll(Pageable pageable) {
		Page<User> findAll = userService.findAll(pageable);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> findById(@PathVariable(required = true) Long id) {
		Optional<User> found = userService.findById(id);
		if (found.isPresent()) {
			return new ResponseEntity<>(found.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = "")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> save(@RequestBody User user) {
		User save = userService.save(user);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
		User save = userService.update(id, user);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		userService.delete(id);
		return new ResponseEntity<>("Element deleted", HttpStatus.OK);

	}
}
