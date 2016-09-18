/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountBean;

import Entity.TblAccount;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Binh Nguyen
 */
@Stateless
public class AccountSessionBean 
        implements AccountSessionBeanLocal, AccountSessionBeanRemote {

    @PersistenceContext(unitName = "JVWAssignment2-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public boolean checkLogin(String username, String password) {
        
        String sql = "SELECT t FROM TblAccount t WHERE t.accountID = :accountID "
                + "AND t.password = :password";

        Query query = em.createQuery(sql);
        query.setParameter("accountID", username);
        query.setParameter("password", password);

        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isManager(String accountID) {
        TblAccount acc = em.find(TblAccount.class, accountID);

        if (acc != null) {
            int role = acc.getRole();
            if (role == 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    
    
    
}
