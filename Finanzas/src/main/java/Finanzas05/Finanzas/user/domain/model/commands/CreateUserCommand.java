package Finanzas05.Finanzas.user.domain.model.commands;

public record CreateUserCommand (String name, String username, String password, Boolean sex) {}
