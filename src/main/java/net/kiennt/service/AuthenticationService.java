package net.kiennt.service;

import net.kiennt.dto.Signature;
import net.kiennt.repository.SignatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KienNT25 on 11/2/2016.
 */
@Service
public class AuthenticationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    SignatureRepository signatureRepository;

    public boolean authenticate(String signature) {
        Signature returnSignature = signatureRepository.findBySignature(signature);
        if (returnSignature != null && returnSignature.getSignature() != null) {
            LOGGER.info("Found signature: " + returnSignature.getSignature());
            return true;
        }
        LOGGER.info("Not found signature: " + signature);
        return false;
    }
}
