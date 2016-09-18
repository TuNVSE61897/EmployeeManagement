/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leave;

import java.io.Serializable;

/**
 *
 * @author Binh Nguyen
 */
public class LeaveError implements Serializable {
    
    private String dateInvalidError;
    private String currentDateError;
    private String pendingError;

    /**
     * @return the dateInvalidError
     */
    public String getDateInvalidError() {
        return dateInvalidError;
    }

    /**
     * @param dateInvalidError the dateInvalidError to set
     */
    public void setDateInvalidError(String dateInvalidError) {
        this.dateInvalidError = dateInvalidError;
    }

    /**
     * @return the currentDateError
     */
    public String getCurrentDateError() {
        return currentDateError;
    }

    /**
     * @param currentDateError the currentDateError to set
     */
    public void setCurrentDateError(String currentDateError) {
        this.currentDateError = currentDateError;
    }

    /**
     * @return the pendingError
     */
    public String getPendingError() {
        return pendingError;
    }

    /**
     * @param pendingError the pendingError to set
     */
    public void setPendingError(String pendingError) {
        this.pendingError = pendingError;
    }
    
    
}
