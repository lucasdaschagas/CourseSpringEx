package entities;

import DTO.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Table(name = "user")
@Entity(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;

    private String email;
    private String phone;
    private String password;



    public User (UserDTO dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.phone = dados.phone();
        this.password = dados.password();

    }

}
