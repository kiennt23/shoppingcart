package net.kiennt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.stereotype.Service;

/**
 * Created by KienNT25 on 11/1/2016.
 */
@Service
@PropertySource("classpath:config.properties")
public class SignatureService {
    @Value("${net.kiennt.secret}")
    private String easyPay2Secret;

    //TODO: passing Map instead of Strings for configurable sequence values
    public String generateSignature(String... args) {
        if (easyPay2Secret == null) {
            throw new IllegalArgumentException();
        }

        StringBuffer data = new StringBuffer("");
        //TODO: sequence values should be configured in config.properties with format seq1,seq2,seq3,...
        for (String arg : args) {
            data.append(arg);
        }
        data.append(easyPay2Secret);
        byte[] result = Sha512DigestUtils.sha(data.toString());
        StringBuffer signature = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            String s = Integer.toHexString(result[i]);
            int length = s.length();
            if (length >= 2) {
                signature.append(s.substring(length - 2, length));
            } else {
                signature.append("0");
                signature.append(s);
            }
        }
        return signature.toString();
    }
}
