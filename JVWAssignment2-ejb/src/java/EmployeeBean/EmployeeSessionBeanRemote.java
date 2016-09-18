/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeBean;

import Entity.TblEmployee;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Tu Nguyen
 */
@Remote
public interface EmployeeSessionBeanRemote {

    List getAEmployee(String username);

    int countEmp(String depID);

    TblEmployee getOneEmployee(String employeeID);

    boolean updateEmployee(String eID, String address, String email, String phone, String family);

    List searchEmployee(String searchValue, String depID, String empID);

    boolean changeDep(String empID, String depID, float salary);
    
}
