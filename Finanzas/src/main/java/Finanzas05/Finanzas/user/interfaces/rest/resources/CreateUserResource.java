package Finanzas05.Finanzas.user.interfaces.rest.resources;

public record CreateUserResource(
        String name,
        String username,
        String password,
        Boolean sex
) {}
