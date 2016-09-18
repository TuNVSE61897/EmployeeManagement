/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatusBean;

import Entity.TblStatus;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tu Nguyen
 */
@Stateless
public class StatusSessionBean 
        implements StatusSessionBeanLocal, StatusSessionBeanRemote {

    @PersistenceContext(unitName = "JVWAssignment2-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String getStatusName(String statusID) {
        TblStatus stt = em.find(TblStatus.class, statusID);
        if (stt!=null) {
            String statusName = stt.getName();
            return statusName;
        }
        return null;
    }
    
    
}
