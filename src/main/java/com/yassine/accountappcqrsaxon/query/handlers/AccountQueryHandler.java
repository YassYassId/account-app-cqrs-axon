package com.yassine.accountappcqrsaxon.query.handlers;

import com.yassine.accountappcqrsaxon.commons.dtos.AccountStatement;
import com.yassine.accountappcqrsaxon.query.dtos.AccountEvent;
import com.yassine.accountappcqrsaxon.query.entities.Account;
import com.yassine.accountappcqrsaxon.query.entities.Operation;
import com.yassine.accountappcqrsaxon.query.queries.GetAccountStatement;
import com.yassine.accountappcqrsaxon.query.queries.GetAllAccounts;
import com.yassine.accountappcqrsaxon.query.queries.WatchEventQuery;
import com.yassine.accountappcqrsaxon.query.repositories.AccountRepository;
import com.yassine.accountappcqrsaxon.query.repositories.OperationRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountQueryHandler {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    public AccountQueryHandler(AccountRepository accountRepository, OperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }
    @QueryHandler
    public List<Account> on(GetAllAccounts query){
        return accountRepository.findAll();
    }
    @QueryHandler
    public AccountStatement on(GetAccountStatement query){
        Account account = accountRepository.findById(query.getAccountId()).get();
        List<Operation> operations = operationRepository.findByAccountId(query.getAccountId());
        return new AccountStatement(account, operations);
    }

    @QueryHandler
    public AccountEvent on(WatchEventQuery query){
        return AccountEvent.builder().build();
    }


}
