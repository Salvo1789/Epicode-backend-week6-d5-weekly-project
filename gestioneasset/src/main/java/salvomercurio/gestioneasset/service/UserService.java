package salvomercurio.gestioneasset.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import salvomercurio.gestioneasset.common.exception.UserException;
import salvomercurio.gestioneasset.model.User;
import salvomercurio.gestioneasset.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public Page<User> findByNome(String nome, Pageable pageable) {
		return userRepository.findByName(nome, pageable);
	}

	public Optional<User> findByUsername(String nome) {
		return userRepository.findByUsername(nome);
	}

	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User update(Long id, User user) {
		Optional<User> userResult = userRepository.findById(id);

		if (userResult.isPresent()) {
			User userUpdate = userResult.get();
			userUpdate.setName(user.getName());
			userRepository.save(userUpdate);
			return userUpdate;
		} else {
			throw new UserException("Utente non aggiornato");
		}

	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
