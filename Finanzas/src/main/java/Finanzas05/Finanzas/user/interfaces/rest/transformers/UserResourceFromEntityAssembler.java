package Finanzas05.Finanzas.user.interfaces.rest.transformers;

import Finanzas05.Finanzas.user.domain.model.entities.User;
import Finanzas05.Finanzas.user.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity){
        return new UserResource(entity.getId(), entity.getName(), entity.getPassword());
    }
}
