package Finanzas05.Finanzas.user.interfaces.rest.transformers;

import Finanzas05.Finanzas.user.domain.model.commands.CreateUserCommand;
import Finanzas05.Finanzas.user.domain.model.entities.User;
import Finanzas05.Finanzas.user.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource){
        return new CreateUserCommand(resource.name(), resource.password());
    }

}
