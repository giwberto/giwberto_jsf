/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giwberto.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author giwberto
 */
public interface InterfaceDAO<T> {
    
    void save(T entity);
    void update(T entity);
    void remove(T entity);
    void merge(T entity);
    T getEntity(Serializable Id);
    T getEntityByDetachedCriteria(DetachedCriteria criteria);
    T getEntityByHQLQuery(String stringQuery);
    List<T> getEntity();
    List<T> getListByDetachedCriteria(DetachedCriteria criteria);
    
    
    
}
