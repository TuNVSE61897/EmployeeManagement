/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountBean;

import javax.ejb.Local;

/**
 *
 * @author Binh Nguyen
 */
@Local
public interface AccountSessionBeanLocal {

    boolean checkLogin(String username, String password);

    boolean isManager(String accountID);

    
}