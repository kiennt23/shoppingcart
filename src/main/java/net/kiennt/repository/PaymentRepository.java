package net.kiennt.repository;

import net.kiennt.dto.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by KienNT25 on 11/1/2016.
 */
public interface PaymentRepository extends CrudRepository<Payment, String> {
}
