package salvomercurio.gestioneasset.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import salvomercurio.gestioneasset.common.exception.AssetException;
import salvomercurio.gestioneasset.model.Asset;
import salvomercurio.gestioneasset.repository.AssetRepository;

@Service
public class AssetService {

	@Autowired
	AssetRepository assetRepository;

	public Optional<Asset> findById(Long id) {
		return assetRepository.findById(id);
	}

	public Page<Asset> findByName(String name, Pageable pageable) {
		return assetRepository.findByName(name, pageable);
	}

	public Page<Asset> findByType(String type, Pageable pageable) {
		return assetRepository.findByType(type, pageable);
	}

	public Page<Asset> findAll(Pageable pageable) {
		return assetRepository.findAll(pageable);
	}

	public Asset save(Asset asset) {
		return assetRepository.save(asset);
	}

	public Asset update(Long id, Asset asset) {
		Optional<Asset> assetResult = assetRepository.findById(id);

		if (assetResult.isPresent()) {
			Asset assetUpdate = assetResult.get();
			assetUpdate.setName(asset.getName());
			assetRepository.save(assetUpdate);
			return assetUpdate;
		} else {
			throw new AssetException("Elemento non aggiornato");
		}

	}

	public void delete(Long id) {
		assetRepository.deleteById(id);
	}

}
