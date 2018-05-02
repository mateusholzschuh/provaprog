/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mateus
 */
public class Conexao {

    /**
     * @UNIDADE_DE_PERSISTENCIA - Nome da unidade de persistência
     */
    private static final String UNIDADE_DE_PERSISTENCIA = "ProvaPU";

    private static EntityManagerFactory emf;

    private Conexao() {
    }

    public static EntityManagerFactory getConexao() throws Exception {
        if ((emf == null) || (!emf.isOpen())) {
            emf = Persistence.createEntityManagerFactory(UNIDADE_DE_PERSISTENCIA);
        }
        return emf;
    }

    public static void closeConexao() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
