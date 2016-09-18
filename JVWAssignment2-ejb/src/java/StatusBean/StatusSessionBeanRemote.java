/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatusBean;

import javax.ejb.Remote;

/**
 *
 * @author Binh Nguyen
 */
@Remote
public interface StatusSessionBeanRemote {

    String getStatusName(String statusID);
    
}
