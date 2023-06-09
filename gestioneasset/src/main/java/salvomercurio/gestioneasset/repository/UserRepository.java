package salvomercurio.gestioneasset.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import salvomercurio.gestioneasset.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	Page<User> findByName(String name, Pageable pageable);

	Optional<User> findById(Long id);

	Optional<User> findByUsername(String username);

	User save(User user);

	void deleteById(Long id);

}
