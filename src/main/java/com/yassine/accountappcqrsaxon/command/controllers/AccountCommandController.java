package com.yassine.accountappcqrsaxon.command.controllers;

import com.yassine.accountappcqrsaxon.command.commands.CreateAccountCommand;
import com.yassine.accountappcqrsaxon.commons.dtos.CreateAccountDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/accounts")
@CrossOrigin("*")
public class AccountCommandController {
    private CommandGateway commandGateway;

    public AccountCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccountDTO request){
        CompletableFuture<String> result = this.commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                request.initialBalance(),
                request.currency()
        ));
        return result;
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception  exception){
        return exception.getMessage();
    }
}
