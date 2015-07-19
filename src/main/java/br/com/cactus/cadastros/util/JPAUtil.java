/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cactus.cadastros.util;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable {

    private static final long serialVersionUID = 1L;
    private static JPAUtil me;
    private EntityManagerFactory emf;

    private JPAUtil(){
        emf = Persistence.createEntityManagerFactory("cadastrosPU");
    }

    public static JPAUtil getInstance() {
        if (me == null) {
            me = new JPAUtil();
        }
        return me;
    }

    public EntityManager getEntityManager() {
        EntityManager toReturn = emf.createEntityManager();
        toReturn.getTransaction().begin();
        return toReturn;
    }

}
