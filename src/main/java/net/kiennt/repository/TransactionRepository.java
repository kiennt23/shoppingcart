package net.kiennt.repository;

import net.kiennt.dto.Transaction;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by KienNT25 on 11/1/2016.
 */
public interface TransactionRepository extends CrudRepository<Transaction, String> {
}
