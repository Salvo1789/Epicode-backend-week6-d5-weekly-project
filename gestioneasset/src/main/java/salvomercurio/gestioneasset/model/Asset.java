package salvomercurio.gestioneasset.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
public class Asset {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String serialNum;
	@Enumerated(EnumType.STRING)
	private AssetType type;

	@ManyToOne
	@JsonIgnore
	private User user;

	public void setAssetType(AssetType smartphone) {
		// TODO Auto-generated method stub

	}

	public Asset(String name, String serialNum, AssetType type) {
		this.name = name;
		this.serialNum = serialNum;
		this.type = type;
		this.user = null;
	}
}
