package com.yassine.accountappcqrsaxon.commons.events;

public record AccountCreditedEvent(String accountId, double amount) {
}
