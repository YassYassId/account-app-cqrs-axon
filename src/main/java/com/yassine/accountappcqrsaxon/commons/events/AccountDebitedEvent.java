package com.yassine.accountappcqrsaxon.commons.events;

public record AccountDebitedEvent(String accountId, double amount) {
}
