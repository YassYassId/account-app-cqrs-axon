package com.yassine.accountappcqrsaxon.query.repositories;

import com.yassine.accountappcqrsaxon.query.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
