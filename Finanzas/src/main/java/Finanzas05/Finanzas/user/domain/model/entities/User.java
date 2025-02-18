package Finanzas05.Finanzas.user.domain.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;

    public User(Long id, String name, String password){
        this.id= id;
        this.name = name;
        this.password = password;
    }

}
