/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giwberto.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author giwberto
 */
@Entity
@Table(name="endereco")
public class Endereco implements Serializable{
    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue
    @Column(name="idEndereco",nullable=false)
    private Integer idEndereco;
    
    @Column(name="bairro",length = 80)
    private String bairro;
    
    @Column(name="rua",length = 80)
    private String rua;
    
    @Column(name="cep",length = 9)
    private String cep;
    
    @Column(name="numero")
    private Integer numero;
    
    @Column(name="complemento",length = 100)
    private String complemento;
    
   @OneToOne(optional = true, fetch = FetchType.LAZY)
   @ForeignKey(name = "enderecocliente")
   @JoinColumn(name="idCliente", referencedColumnName = "idCliente")
   private Cliente cliente;
   
   @ManyToOne(optional = false, fetch = FetchType.LAZY)
   @ForeignKey(name="enderecoestado")
   @JoinColumn(name="idEstado", referencedColumnName = "idEstado")
   private Estado estado;
   
   @ManyToOne(optional = false, fetch = FetchType.LAZY)
   @ForeignKey(name="enderecocidade")
   @JoinColumn(name="idCidade", referencedColumnName = "idCidade")
   private Cidade cidade;
   
   

    public Endereco() {
        this.cidade = new Cidade();
        this.estado = new Estado();
        
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.idEndereco != null ? this.idEndereco.hashCode() : 0);
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
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco && (this.idEndereco == null || !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }
    
    

}