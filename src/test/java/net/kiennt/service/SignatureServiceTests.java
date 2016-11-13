package net.kiennt.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * Created by KienNT25 on 11/1/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SignatureServiceTests {

    @Autowired
    private SignatureService signatureService;

    @Test
    public void test_secret_configuration_loaded() {
        String signature = signatureService.generateSignature("test", "test", "test", "test", "test");
        System.out.println("####### " + signature);
        Assert.notNull(signature);
    }
}
