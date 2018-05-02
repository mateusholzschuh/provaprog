/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * - Classe DAO padrão -
 * 
 * / Utilizar sempre NomeDaClaseDAO /
 * 
 * Para adaptar após o CTRL+C, CTRL+V :
 * Pressione CTRL+H e substitua "ExemploClasse" pelo nome da sua classe.
 * 
 */
package dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.ExemploClasse;

/**
 *
 * @author Mateus
 */
public class ExemploClasseDAO {

    protected EntityManager em;

    public ExemploClasseDAO() {
        EntityManagerFactory emf;
        try {
            emf = Conexao.getConexao();
            em = emf.createEntityManager();
        } catch (Exception ex) {
            Logger.getLogger(ExemploClasseDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger("Não foi possível realizar a conexão com a unidade de persistência. Verifique a conexão");
        }

    }

    public Boolean incluir(ExemploClasse obj) {
        Boolean retorno;
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            retorno = true;
        } catch (RuntimeException e) {
            Logger.getLogger(ExemploClasse.class.getName()).log(Level.SEVERE, null, e);
            Logger.getLogger("Erro ao incluir, veja o código acima");

            em.getTransaction().rollback();

            retorno = false;
            throw e;
        } finally {
            //em.close();
        }
        return retorno;
    }

    public Boolean alterar(ExemploClasse obj) {
        Boolean retorno;
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            retorno = true;
        } catch (RuntimeException e) {
            Logger.getLogger(ExemploClasseDAO.class.getName()).log(Level.SEVERE, null, e);
            Logger.getLogger("Erro ao alterar, veja o código acima");
            em.getTransaction().rollback();
            retorno = false;
            throw e;
        } finally {
            // em.close();
        }
        return retorno;
    }

    public Boolean excluir(ExemploClasse obj) {
        Boolean retorno;
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            retorno = true;
        } catch (RuntimeException e) {
            Logger.getLogger(ExemploClasseDAO.class.getName()).log(Level.SEVERE, null, e);
            Logger.getLogger("Erro ao excluir, veja o código acima");

            em.getTransaction().rollback();
            retorno = false;
        } finally {
            //em.close();
        }
        return retorno;
    }

    public List<ExemploClasse> listar() {
        return em.createQuery("Select t from ExemploClasse t").getResultList();
    }

    /**
     * @deprecated
     * @param filtro
     * @return
     * @throws Exception 
     */
    public List<ExemploClasse> listar(String filtro) throws Exception {
        return em.createNamedQuery("Categoria.findFilter").setParameter("filtro", "%" + filtro.toUpperCase() + "%").getResultList();
    }

    public ExemploClasse buscarPorChavePrimaria(Long chaveprimaria) {
        return em.find(ExemploClasse.class, chaveprimaria);
    }

    public void fecharConexao() {
        Conexao.closeConexao();
    }
}
