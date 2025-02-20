package Finanzas05.Finanzas.user.domain.services;

import Finanzas05.Finanzas.user.domain.model.entities.User;
import Finanzas05.Finanzas.user.domain.model.queries.GetAllUsersQuery;

import java.util.List;

public interface IUserQueryService {
    List<User> handle(GetAllUsersQuery query);
}
