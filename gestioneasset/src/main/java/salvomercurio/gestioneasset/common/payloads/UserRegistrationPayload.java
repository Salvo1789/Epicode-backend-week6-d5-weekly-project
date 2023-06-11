package salvomercurio.gestioneasset.common.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRegistrationPayload {
	@NotNull(message = "Username obbligatorio")
	String username;
	@NotNull(message = "Nome obbligatorio")
	@Size(min = 3, max = 30, message = "Lunghezza min 3 caratteri, max 30")
	String name;
	@Email(message = "Indirizzo email non valido")
	String email;
	@NotNull(message = "Password obbligatoria")
	String password;

	public UserRegistrationPayload(@NotNull(message = "Username obbligatorio") String username,
			@NotNull(message = "Nome obbligatorio") @Size(min = 3, max = 30, message = "Lunghezza min 3 caratteri, max 30") String name,
			@Email(message = "Indirizzo email non valido") String email,
			@NotNull(message = "Password obbligatoria") String password) {
		super();
		this.username = username;
		this.name = name;
		this.email = email;
		this.password = password;
	}

}
