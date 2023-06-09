package salvomercurio.gestioneasset.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import salvomercurio.gestioneasset.model.Asset;

@Repository
public interface AssetRepository extends PagingAndSortingRepository<Asset, Long> {

	Optional<Asset> findById(long id);

	Page<Asset> findByName(String name, Pageable pageable);

	Page<Asset> findByType(String type, Pageable pageable);

	Asset save(Asset asset);

	void deleteById(long id);

	int count();

}
