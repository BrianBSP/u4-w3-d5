package brianpelinku;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4_w3_d5");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        

        System.out.println("Hello World!");
    }
}
