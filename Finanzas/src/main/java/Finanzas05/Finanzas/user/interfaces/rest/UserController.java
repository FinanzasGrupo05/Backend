package Finanzas05.Finanzas.user.interfaces.rest;

import Finanzas05.Finanzas.user.application.internal.commandServices.UserCommandService;
import Finanzas05.Finanzas.user.application.internal.queryServices.UserQueryService;
import Finanzas05.Finanzas.user.domain.model.commands.CreateUserCommand;
import Finanzas05.Finanzas.user.domain.model.commands.DeleteUserByIdCommand;
import Finanzas05.Finanzas.user.domain.model.commands.LoginCommand;
import Finanzas05.Finanzas.user.domain.model.entities.User;
import Finanzas05.Finanzas.user.domain.model.queries.GetAllUsersQuery;
import Finanzas05.Finanzas.user.domain.model.queries.GetUsersByUsernameAndPasswordQuery;
import Finanzas05.Finanzas.user.interfaces.rest.resources.UserResource;
import Finanzas05.Finanzas.user.interfaces.rest.transformers.UserResourceFromEntityAssembler;
import Finanzas05.Finanzas.user.interfaces.rest.resources.CreateUserResource;
import Finanzas05.Finanzas.user.interfaces.rest.transformers.CreateUserCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "https://finanzas-fchpamj0x-daniels-projects-63dd5b20.vercel.app")
public class UserController {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UserController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody LoginCommand loginCommand) {
        var getUserQuery = new GetUsersByUsernameAndPasswordQuery(loginCommand.username(), loginCommand.password());
        var user = userQueryService.handle(getUserQuery);
        if (user == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<UserResource>> getAllUsers() {
        var getAllUsersQuery = new GetAllUsersQuery();
        var users = userQueryService.handle(getAllUsersQuery);
        var usersResources = users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();

        return ResponseEntity.ok(usersResources);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserResource createUserResource) {
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(createUserResource);
        var user = userCommandService.handle(createUserCommand);
        return user.map(u -> new ResponseEntity<>(u, HttpStatus.CREATED)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        var deleteUserByIdCommand = new DeleteUserByIdCommand(id);
        userCommandService.handle(deleteUserByIdCommand);
        return ResponseEntity.ok().build();
    }
}
