package Finanzas05.Finanzas.user.application.internal.commandServices;

import Finanzas05.Finanzas.user.domain.model.commands.CreateUserCommand;
import Finanzas05.Finanzas.user.domain.model.entities.User;
import Finanzas05.Finanzas.user.domain.services.IUserCommandService;
import Finanzas05.Finanzas.user.infrastructure.repositories.jpa.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserCommandService implements IUserCommandService {
    private final IUserRepository userRepository;

    public UserCommandService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(CreateUserCommand command) {
        User user = new User(command);
        try {
            var response = userRepository.save(user);

            return Optional.of(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
