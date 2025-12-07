package com.yassine.accountappcqrsaxon.commons.events;

import com.yassine.accountappcqrsaxon.commons.enums.AccountStatus;

public record AccountStatusUpdatedEvent(String accountId, AccountStatus fromStatus, AccountStatus toStatus) {
}