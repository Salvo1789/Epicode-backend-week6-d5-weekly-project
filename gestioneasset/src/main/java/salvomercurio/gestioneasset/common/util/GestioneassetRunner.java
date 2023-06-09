package salvomercurio.gestioneasset.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import salvomercurio.gestioneasset.model.Asset;
import salvomercurio.gestioneasset.model.AssetType;
import salvomercurio.gestioneasset.model.Role;
import salvomercurio.gestioneasset.model.RoleType;
import salvomercurio.gestioneasset.model.User;
import salvomercurio.gestioneasset.repository.AssetRepository;
import salvomercurio.gestioneasset.repository.RoleRepository;
import salvomercurio.gestioneasset.repository.UserRepository;

@Component
@Slf4j
public class GestioneassetRunner implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AssetRepository assetRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {

		if (assetRepository.count() == 0) {

			List<Role> role = initRole();
			User user = initUser(role);
			List<Asset> assetList = initAsset(user);

		}

	}

	private List<Asset> initAsset(User initUser) {
		List<Asset> lista = new ArrayList<Asset>();

		Asset asset = new Asset();
		asset.setName("Motorola G40");
		asset.setSerialNum("4H8U9906I2");
		asset.setAssetType(AssetType.SMARTPHONE);
		asset.setUser(initUser);
		assetRepository.save(asset);
		lista.add(asset);
		log.info("Saved Asset: {}", asset.getName());

		asset = new Asset();
		asset.setName("HP Pavilion 15");
		asset.setSerialNum("UH841L61905I");
		asset.setAssetType(AssetType.NOTEBOOK);
		asset.setUser(initUser);
		assetRepository.save(asset);
		lista.add(asset);
		log.info("Saved Asset: {}", asset.getName());

		return lista;

	}

	private List<Role> initRole() {
		List<Role> result = new ArrayList<Role>();
		Role role = new Role();
		role.setRoleType(RoleType.ROLE_ADMIN);
		roleRepository.save(role);
		result.add(role);
		log.info("Saved Role: {}", role.getRoleType());

		role = new Role();
		role.setRoleType(RoleType.ROLE_USER);
		roleRepository.save(role);
		result.add(role);

		log.info("Saved Role: {}", role.getRoleType());

		return result;
	}

	private User initUser(List<Role> roles) {
		User user = new User();
		user.setEmail("maurilio@gmail.com");
		user.setName("Maurilio Bianchi");
		user.setUsername("m.bianchi");
		user.setPassword("prova");
		user.setRoles(new HashSet<Role>(roles));
		userRepository.save(user);

		log.info("Saved User: {}", user.getName());

		return user;
	}
}
