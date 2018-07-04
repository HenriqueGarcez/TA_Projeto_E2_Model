package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carta;
import br.edu.ifsul.modelo.Permissao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eric_
 */
public class TestePersistirCarta {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirCarta() {

    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA_Projeto_E2_ModelPU");
        em = emf.createEntityManager();
    }
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testePersistirPais() {
        boolean exception = false;
        try {
            Carta obj= new Carta();
            obj.setNome("Mago Negro");
            obj.setDescricao("O mago definitivo em termos de ataque e defesa.");
            obj.setJogo("Yu-Gi-Oh");
            obj.setRaridade("Ultra Raro");
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
