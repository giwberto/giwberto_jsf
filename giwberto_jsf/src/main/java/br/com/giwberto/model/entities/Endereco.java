/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giwberto.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    
    
    
    
}
