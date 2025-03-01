package Finanzas05.Finanzas.user.interfaces.rest.resources;

public record UserResource(
        Long id,
        String name,
        String username,
        String password,
        Boolean sex
) {
}
