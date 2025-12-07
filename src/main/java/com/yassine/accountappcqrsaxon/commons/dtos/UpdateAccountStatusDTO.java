package com.yassine.accountappcqrsaxon.commons.dtos;

import com.yassine.accountappcqrsaxon.commons.enums.AccountStatus;

public record UpdateAccountStatusDTO(String accountId, AccountStatus accountStatus) {
}