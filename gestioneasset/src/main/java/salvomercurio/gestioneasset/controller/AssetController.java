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

import salvomercurio.gestioneasset.model.Asset;
import salvomercurio.gestioneasset.service.AssetService;

@RestController
@RequestMapping("/asset")
public class AssetController {

	@Autowired
	AssetService assetService;

	@GetMapping(path = "")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Page<Asset>> findAll(Pageable pageable) {
		Page<Asset> findAll = assetService.findAll(pageable);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Asset> findById(@PathVariable(required = true) Long id) {
		Optional<Asset> found = assetService.findById(id);
		if (found.isPresent()) {
			return new ResponseEntity<>(found.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{type}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Page<Asset>> findByType(@PathVariable(required = true) String type, Pageable pageable) {
		Page<Asset> findAllType = assetService.findByType(type, pageable);
		if (findAllType.hasContent()) {
			return new ResponseEntity<>(findAllType, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = "")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Asset> save(@RequestBody Asset asset) {
		Asset save = assetService.save(asset);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Asset> update(@PathVariable Long id, @RequestBody Asset asset) {
		Asset save = assetService.update(id, asset);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		assetService.delete(id);
		return new ResponseEntity<>("Asset deleted", HttpStatus.OK);

	}
}
