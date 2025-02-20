package Finanzas05.Finanzas.user.domain.model.entities;

import Finanzas05.Finanzas.user.domain.model.commands.CreateUserCommand;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;

    public User(){}
    public User(Long id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(CreateUserCommand command){
        this.name = command.name();
        this.password = command.password();
    }

}
