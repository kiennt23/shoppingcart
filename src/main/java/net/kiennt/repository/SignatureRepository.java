package net.kiennt.repository;

import net.kiennt.dto.Signature;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by KienNT25 on 11/2/2016.
 */
public interface SignatureRepository extends CrudRepository<Signature, String> {
    Signature findBySignature(String signature);
}
