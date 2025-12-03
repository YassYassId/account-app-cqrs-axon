package com.yassine.accountappcqrsaxon.command.aggregates;


import com.yassine.accountappcqrsaxon.command.commands.CreateAccountCommand;
import com.yassine.accountappcqrsaxon.commons.enums.AccountStatus;
import com.yassine.accountappcqrsaxon.commons.events.AccountCreatedEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
//@Entity
@Slf4j @Getter @Setter
public class AccountAggregate {
    @AggregateIdentifier
    //@Id
    private String accountId ;
    private double currentBalance;
    private String currency;
    private AccountStatus status;


    public AccountAggregate() {
        log.info("Account Aggregate Created");
    }


    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        log.info("CreateAccount Command Received");
        if (command.getInitialBalance()<0) throw  new IllegalArgumentException("Balance negative exception");
        AggregateLifecycle.apply(new AccountCreatedEvent(
                command.getId(),
                command.getInitialBalance(),
                command.getCurrency(),
                AccountStatus.CREATED
        ));
    }

    @EventSourcingHandler
    //@EventHandler
    public void on(AccountCreatedEvent event){
        log.info("AccountCreatedEvent occured");
        this.accountId =event.accountId();
        this.currentBalance = event.initialBalance();
        this.currency = event.currency();
        this.status = event.accountStatus();
    }
}
