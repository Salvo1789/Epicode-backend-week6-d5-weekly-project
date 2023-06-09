package salvomercurio.gestioneasset.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoginResponse {
	private String token;

	private final String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private Role role;
	private Date expirationTime;

}
