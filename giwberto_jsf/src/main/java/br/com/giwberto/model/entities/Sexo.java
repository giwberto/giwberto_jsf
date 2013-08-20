/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giwberto.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author giwberto
 */

@Entity
@Table (name = "Sexo")
public class Sexo implements Serializable{
    private static final long seirialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue
    @Column(name="idSexo",  nullable = false)
    private Integer idSexo;
    
    @Column(name="Descricao",unique=true, nullable = false, length = 9)
    private String descricao;
    
    @OneToMany(mappedBy="Sexo",fetch = FetchType.LAZY)
    @ForeignKey(name="clientesexo")
    private List<Cliente> clientes;

    public Sexo() {
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sexo other = (Sexo) obj;
        if (this.idSexo != other.idSexo && (this.idSexo == null || !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }
    
    
    
}