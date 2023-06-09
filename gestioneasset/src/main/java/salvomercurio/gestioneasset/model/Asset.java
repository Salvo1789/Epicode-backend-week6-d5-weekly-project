package salvomercurio.gestioneasset.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String serialNum;
	@Enumerated(EnumType.STRING)
	private AssetType type;

	@ManyToOne
	private User user;

	public void setAssetType(AssetType smartphone) {
		// TODO Auto-generated method stub

	}
}
