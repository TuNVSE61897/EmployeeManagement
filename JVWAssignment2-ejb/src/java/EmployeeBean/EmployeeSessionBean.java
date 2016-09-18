/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeBean;

import Entity.TblEmployee;
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
public class EmployeeSessionBean
        implements EmployeeSessionBeanLocal, EmployeeSessionBeanRemote {

    @PersistenceContext(unitName = "JVWAssignment2-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List getAEmployee(String username) {
        String jpql = "SELECT t FROM TblEmployee t WHERE t.employeeID = :employeeID";
        try {
            Query query = em.createQuery(jpql);
            query.setParameter("employeeID", username);
            List result = query.getResultList();
            return result;
        } catch (NumberFormatException e) {
            System.out.print(e.getMessage());
            return null;
        }
    }

    @Override
    public int countEmp(String depID) {
        String jpql = "SELECT t FROM TblEmployee t WHERE t.depID = :depID";

        Query query = em.createQuery(jpql);
        query.setParameter("depID", depID);
        List result = query.getResultList();
        if (result != null) {
            int rowCounts = result.size();
            return rowCounts;
        }
        return 0;
    }

    @Override
    public TblEmployee getOneEmployee(String employeeID) {

        TblEmployee emp = em.find(TblEmployee.class, employeeID);

        if (emp != null) {
            return emp;
        }

        return null;
    }

    @Override
    public boolean updateEmployee(String eID, String address, String email, String phone, String family) {

        TblEmployee emp = em.find(TblEmployee.class, eID);

        if (emp != null) {
            emp.setAddress(address);
            emp.setEmail(email);
            emp.setPhone(phone);
            emp.setFamily(family);

            em.merge(emp);

            return true;
        }

        return false;
    }

    @Override
    public List searchEmployee(String searchValue, String depID, String empID) {

        String jpql = "SELECT t FROM TblEmployee t WHERE t.depID = :depID AND "
                + "t.employeeID != :employeeID AND (t.employeeID LIKE :searchValue OR t.name LIKE :searchValue)";

        Query query = em.createQuery(jpql);
        query.setParameter("depID", depID);
        query.setParameter("employeeID", empID);
        query.setParameter("searchValue", "%" + searchValue + "%");

        List result = query.getResultList();
        return result;
    }

    @Override
    public boolean changeDep(String empID, String depID, float salary) {

        TblEmployee emp = em.find(TblEmployee.class, empID);

        if (emp != null) {
            emp.setDepID(depID);
            emp.setSalary(salary);

            em.merge(emp);

            return true;
        }

        return false;
    }

}
