/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giwberto.controler;

import br.com.giwberto.model.dao.HibernateDAO;
import br.com.giwberto.model.dao.InterfaceDAO;
import br.com.giwberto.model.entities.Cliente;
import br.com.giwberto.model.entities.Endereco;
import br.com.giwberto.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author giwberto
 */
@ManagedBean
@SessionScoped

public class MbCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String confereSenha;
    private Cliente cliente = new Cliente();
    private Endereco endereco = new Endereco();
    private List<Cliente> clientes;
    private List<Endereco> enderecos;

    public MbCliente() {
    }
    
    private InterfaceDAO<Cliente> clienteDAO(){
        InterfaceDAO<Cliente> clienteDAO = new HibernateDAO<Cliente>(Cliente.class, FacesContextUtil.getRequestSession());
        return clienteDAO;
    }
    
    private InterfaceDAO<Endereco> enderecoDAO(){
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class, FacesContextUtil.getRequestSession());
        return enderecoDAO;
    }
    
    public String limpCliente(){
        cliente = new Cliente();
        endereco =  new Endereco();
       return editCliente();
    }
    
    public String editCliente(){
        return "/restrict/cadastrarcliente.faces";
    }
    
    public String addCliente(){
        Date date = new Date();
        if(cliente.getIdCliente()== null || cliente.getIdCliente() ==0){
            cliente.setDataDeCadastro(date);
            insertCliente();
        }else{
            updateCliente();
        }
        
        limpCliente();
        return null;
    }

    private void insertCliente() {
    clienteDAO().save(cliente);
    endereco.setCliente(cliente);
    enderecoDAO().save(endereco);
    FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updateCliente() {
    clienteDAO().update(cliente);
    endereco.setCliente(cliente);
    enderecoDAO().update(endereco);
    FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }
    
    public String deleteCliente(){
        clienteDAO().remove(cliente);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Cliente> getClientes() {
        clientes = clienteDAO().getEntities();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Endereco> getEnderecos() {
        enderecos = enderecoDAO().getEntities();
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public String getConfereSenha() {
        return confereSenha;
    }

    public void setConfereSenha(String confereSenha) {
        this.confereSenha = confereSenha;
    }

    
    
}
