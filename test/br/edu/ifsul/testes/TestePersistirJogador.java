/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carta;
import br.edu.ifsul.modelo.Jogador;
import br.edu.ifsul.modelo.Permissao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author eric_
 */
public class TestePersistirJogador {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirJogador() {
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
    public void teste() {
        boolean exception = false;
        try {
            em.getTransaction().begin();
            Jogador obj = new Jogador();
            obj.setNick("admin");
            obj.setPassword("admin");
            obj.setEmail("admin@hotmail.com");
            obj.setCpf("66110240001");
            Permissao p1 = em.find(Permissao.class, "STAFF");
            Permissao p2 = em.find(Permissao.class, "PLAYER");
            obj.getPermissoes().add(p1);
            obj.getPermissoes().add(p2);
            Carta c= em.find(Carta.class, 1);
            obj.getDeck().add(c);
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
