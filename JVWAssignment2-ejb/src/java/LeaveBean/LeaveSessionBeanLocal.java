/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeaveBean;

import java.sql.Date;
import javax.ejb.Local;

/**
 *
 * @author Tu Nguyen
 */
@Local
public interface LeaveSessionBeanLocal {

    void propose(String eID, Date from, Date to);

    boolean accept(String button, String empID);

}
