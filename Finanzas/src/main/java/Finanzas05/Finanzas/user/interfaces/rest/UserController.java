package Finanzas05.Finanzas.user.interfaces.rest;

import Finanzas05.Finanzas.user.application.internal.commandServices.UserCommandService;
import Finanzas05.Finanzas.user.application.internal.queryServices.UserQueryService;
import Finanzas05.Finanzas.user.domain.model.entities.User;
import Finanzas05.Finanzas.user.domain.model.queries.GetAllUsersQuery;
import Finanzas05.Finanzas.user.interfaces.rest.resources.CreateUserResource;
import Finanzas05.Finanzas.user.interfaces.rest.transformers.CreateUserCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UserController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        var getAllUsersQuery = new GetAllUsersQuery();
        var users = userQueryService.handle(getAllUsersQuery);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserResource createUserResource) {
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(createUserResource);

        var user = userCommandService.handle(createUserCommand);

        return user.map(u -> new ResponseEntity<>(u, HttpStatus.CREATED)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
