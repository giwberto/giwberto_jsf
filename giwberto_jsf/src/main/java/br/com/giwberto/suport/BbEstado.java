/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giwberto.suport;

import br.com.giwberto.model.dao.HibernateDAO;
import br.com.giwberto.model.dao.InterfaceDAO;
import br.com.giwberto.model.entities.Estado;
import br.com.giwberto.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author giwberto
 */
@ManagedBean(name="bbEstado")
@RequestScoped
public class BbEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Estado> getEstados(){
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        return estadoDAO.getEntities();
    }
    
}
