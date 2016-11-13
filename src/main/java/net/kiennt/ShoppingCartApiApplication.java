package net.kiennt;

import net.kiennt.dto.Signature;
import net.kiennt.repository.SignatureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ShoppingCartApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartApiApplication.class, args);
    }

    //TODO: Just for test. Please remove
    @Bean
    public CommandLineRunner mockSignatures(SignatureRepository signatureRepository) {
        return args -> {
            signatureRepository.save(new Signature("1", "TESTSignature1", "internal"));
            signatureRepository.save(new Signature("2", "TESTSignature2", "external"));
        };
    }
}
