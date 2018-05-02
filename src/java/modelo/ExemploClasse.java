/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * - Classe Modelo padrão -
 * 
 * / Utilizar sempre NomeDaClase /
 * 
 * Para adaptar após o CTRL+C, CTRL+V :
 * Pressione CTRL+H e substitua "ExemploClasse" pelo nome da sua classe.
 * 
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mateus
 */
@Entity
public class ExemploClasse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /* Outros atributos aqui */
    
    
    /* ********************* */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExemploClasse)) {
            return false;
        }
        ExemploClasse other = (ExemploClasse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExemploClasse[ id=" + id + " ]";
    }
    
}
