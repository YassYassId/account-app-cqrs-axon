package com.yassine.accountappcqrsaxon.commons.dtos;

import com.yassine.accountappcqrsaxon.query.entities.Account;
import com.yassine.accountappcqrsaxon.query.entities.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class AccountStatement {
    private Account account;
    private List<Operation> operations;
}
