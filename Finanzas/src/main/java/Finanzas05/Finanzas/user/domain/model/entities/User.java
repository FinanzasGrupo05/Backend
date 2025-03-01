package Finanzas05.Finanzas.user.domain.model.entities;

import Finanzas05.Finanzas.user.domain.model.commands.CreateUserCommand;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private Boolean sex;

    public User(){}
    public User(Long id, String username, String password, String name, Boolean sex){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.sex = sex;
    }
    public User(CreateUserCommand command){
        this.name = command.name();
        this.username = command.username();
        this.password = command.password();
        this.sex = command.sex();
    }
}
