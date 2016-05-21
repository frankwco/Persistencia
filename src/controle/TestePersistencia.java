/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Estado;

/**
 *
 * @author Aluno
 */
public class TestePersistencia {

    public static void main(String[] args) {
        
        
        //É necessário estabelecer a conexão com o banco
        EntityManagerFactory fa=Persistence.createEntityManagerFactory("IntroducaoHibernatePU");
        EntityManager em=fa.createEntityManager();
        em.getTransaction().begin();
        
        //Busca um determinado estado por ID
        Estado estadoBanco=em.find(Estado.class, 1L);
        //Remove o estado
        em.remove(estadoBanco);
        
        //Busca uma lista de estados
        List<Estado> listaEstados=em.createQuery("from Estado").getResultList();
        System.out.println("Tamanho da lista: "+listaEstados.size());
        
//        Estado est = new Estado();
//        est.setNome("Santa Catarina");
//        est.setSigla("SC");
//        em.persist(est);
//        
//        est = new Estado();
//        est.setNome("São Paulo");
//        est.setSigla("SP");
//        em.persist(est);
        
        em.getTransaction().commit();
        em.close();
        fa.close();
    }
}
