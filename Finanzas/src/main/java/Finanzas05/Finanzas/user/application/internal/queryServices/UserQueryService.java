package Finanzas05.Finanzas.user.application.internal.queryServices;

import Finanzas05.Finanzas.user.domain.model.entities.User;
import Finanzas05.Finanzas.user.domain.model.queries.GetAllUsersQuery;
import Finanzas05.Finanzas.user.domain.services.IUserQueryService;
import Finanzas05.Finanzas.user.infrastructure.repositories.jpa.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryService implements IUserQueryService {

    private final IUserRepository userRepository;

    public UserQueryService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }
}
