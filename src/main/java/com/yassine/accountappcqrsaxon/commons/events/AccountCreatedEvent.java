package com.yassine.accountappcqrsaxon.commons.events;

import com.yassine.accountappcqrsaxon.commons.enums.AccountStatus;

public record AccountCreatedEvent(String accountId, double initialBalance, String currency, AccountStatus accountStatus) {
}
