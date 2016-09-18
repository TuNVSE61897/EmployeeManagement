/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DepartmentBean;

import javax.ejb.Local;
import java.util.List;


/**
 *
 * @author Tu Nguyen
 */
@Local
public interface DepartmentSessionBeanLocal {

    String getDepName(String depID);

    List loadListDep();

    String getDepID(String depName);
    
}
