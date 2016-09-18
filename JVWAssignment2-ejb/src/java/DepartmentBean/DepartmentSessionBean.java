/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DepartmentBean;

import Entity.TblDepartment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Binh Nguyen
 */
@Stateless
public class DepartmentSessionBean implements DepartmentSessionBeanLocal, DepartmentSessionBeanRemote {

    @PersistenceContext(unitName = "JVWAssignment2-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String getDepName(String depID) {
        TblDepartment dep = em.find(TblDepartment.class, depID);
        if (dep!=null) {
            String depName = dep.getName();
            return depName;
        }
        return null;
    }

    @Override
    public List loadListDep() {
        
        Query query = em.createNamedQuery("TblDepartment.findAll");
        List result = query.getResultList();
           
        return result;
    }

    @Override
    public String getDepID(String depName) {
        String jpql = "SELECT t.depID FROM TblDepartment t WHERE t.name = :name";
        Query query = em.createQuery(jpql);
        query.setParameter("name", depName);
        String depID = (String) query.getSingleResult();
        if (depID!=null) {
            return depID;
        }
        return null;
    }
    
    
    
}
