package todo.bankrestapi.dto;


import lombok.Getter;
import todo.bankrestapi.model.Role;
@Getter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String email;
    private Role role;

    public JwtResponse(String token, Long id, String email, Role role) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.role = role;
    }

    // getters, setters
}