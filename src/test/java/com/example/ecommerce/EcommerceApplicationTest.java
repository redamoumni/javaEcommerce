package com.example.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // Utilisez ce profil si vous avez des configurations spécifiques pour les tests
public class EcommerceApplicationTest {

    @Test
    void contextLoads() {
        // Ce test vérifie simplement que le contexte de l'application Spring Boot se
        // charge sans erreurs.
        // Aucune assertion n'est nécessaire, car si le contexte ne se charge pas
        // correctement,
        // le test échouera automatiquement.
    }
}
