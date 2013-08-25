/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giwberto.suport;

import br.com.giwberto.model.dao.HibernateDAO;
import br.com.giwberto.model.dao.InterfaceDAO;
import br.com.giwberto.model.entities.Cidade;
import br.com.giwberto.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author giwberto
 */
@ManagedBean(name="bbCidade")
public class BbCidade implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Cidade> getCidade(){
            InterfaceDAO<Cidade> daoCidade =new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
            return daoCidade.getEntities();
}
    
}
