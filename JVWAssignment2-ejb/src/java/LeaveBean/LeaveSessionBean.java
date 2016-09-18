/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeaveBean;

import Entity.TblEmployee;
import Entity.TblLeave;
import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tu Nguyen
 */
@Stateless
public class LeaveSessionBean implements LeaveSessionBeanLocal, LeaveSessionBeanRemote {

    @PersistenceContext(unitName = "JVWAssignment2-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void propose(String eID, Date from, Date to) {

        TblLeave leave = new TblLeave();
        leave.setFromDate(from);
        leave.setToDate(to);
        leave.setAccept(Boolean.FALSE);
        leave.setEmpID(eID);

        em.persist(leave);

        TblEmployee emp = em.find(TblEmployee.class, eID);
        emp.setStatus(1);

        return;
    }

    @Override
    public boolean accept(String button, String empID) {

        Query query = em.createNamedQuery("TblLeave.findByEmpID");
        query.setParameter("empID", empID);

        List result = query.getResultList();

        if (result != null) {
            TblLeave leave = (TblLeave) result.get(result.size() - 1);
            TblEmployee emp = em.find(TblEmployee.class, empID);

            if (button.equals("Accept")) {
                leave.setAccept(Boolean.TRUE);
                emp.setStatus(2);
                
                em.merge(leave);
                em.merge(emp);
                
                return true;
            } else {
                leave.setAccept(Boolean.FALSE);
                emp.setStatus(0);
                
                em.merge(leave);
                em.merge(emp);
                
                return true;
            }
        }
        return false;
    }

}
