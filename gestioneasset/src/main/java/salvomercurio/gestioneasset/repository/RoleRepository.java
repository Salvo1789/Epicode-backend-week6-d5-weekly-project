package salvomercurio.gestioneasset.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import salvomercurio.gestioneasset.model.Role;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

	void save(Role role);

}