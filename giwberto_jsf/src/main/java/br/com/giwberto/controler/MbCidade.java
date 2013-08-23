/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giwberto.controler;

import br.com.giwberto.model.dao.HibernateDAO;
import br.com.giwberto.model.dao.InterfaceDAO;
import br.com.giwberto.model.entities.Cidade;
import br.com.giwberto.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author giwberto
 */
@ManagedBean (name = "mbCidade")
@RequestScoped
public class MbCidade implements Serializable {

    private static final long serialVersionUID = 1L;
    private Cidade cidade = new Cidade();
    private List<Cidade> cidades;

    public MbCidade() {
    }

    private InterfaceDAO<Cidade> cidadeDAO() {
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO;
    }
    
    public String limpCidade() {
        cidade = new Cidade();
        return "/restrict/cadastrarcidade.faces";
        
    }

    public String editCidade() {
        return "/restrict/cadastrarcidade.faces";
    }

    public String addCidade() {
        if (cidade.getIdCidade() == null || cidade.getIdCidade() == 0) {
            insertCidade();
        } else {
            updateCidade();
        }
        limpCidade();
        return null;
    }

    private void insertCidade() {
        cidadeDAO().save(cidade);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updateCidade() {
        cidadeDAO().update(cidade);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualisação efetuada com sucesso", ""));
    }
    
    
    public void deleteCidde(){
        cidadeDAO().remove(cidade);
    }

    public List<Cidade> getCidades() {
        cidades = cidadeDAO().getEntity();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

       
}
