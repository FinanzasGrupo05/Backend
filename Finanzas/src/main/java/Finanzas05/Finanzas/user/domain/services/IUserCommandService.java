package Finanzas05.Finanzas.user.domain.services;

import Finanzas05.Finanzas.user.domain.model.commands.CreateUserCommand;
import Finanzas05.Finanzas.user.domain.model.entities.User;

import java.util.Optional;

public interface IUserCommandService {

    Optional<User> handle(CreateUserCommand command);
}
