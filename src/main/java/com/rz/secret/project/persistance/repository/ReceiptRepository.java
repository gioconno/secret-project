package com.rz.secret.project.persistance.repository;

import com.rz.secret.project.persistance.model.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends CrudRepository<Receipt, Long> {
}
