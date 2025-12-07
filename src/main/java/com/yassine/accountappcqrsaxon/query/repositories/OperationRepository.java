package com.yassine.accountappcqrsaxon.query.repositories;

import com.yassine.accountappcqrsaxon.query.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByAccountId(String accountId);
}
