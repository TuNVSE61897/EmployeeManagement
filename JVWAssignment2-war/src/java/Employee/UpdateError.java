/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.io.Serializable;

/**
 *
 * @author Tu Nguyen
 */
public class UpdateError implements Serializable {
    
    private String addressLengthError;
    private String emailLengthError;
    private String phoneLengthError;
    private String familyLengthErrror;

    /**
     * @return the addressLengthError
     */
    public String getAddressLengthError() {
        return addressLengthError;
    }

    /**
     * @param addressLengthError the addressLengthError to set
     */
    public void setAddressLengthError(String addressLengthError) {
        this.addressLengthError = addressLengthError;
    }

    /**
     * @return the emailLengthError
     */
    public String getEmailLengthError() {
        return emailLengthError;
    }

    /**
     * @param emailLengthError the emailLengthError to set
     */
    public void setEmailLengthError(String emailLengthError) {
        this.emailLengthError = emailLengthError;
    }

    /**
     * @return the phoneLengthError
     */
    public String getPhoneLengthError() {
        return phoneLengthError;
    }

    /**
     * @param phoneLengthError the phoneLengthError to set
     */
    public void setPhoneLengthError(String phoneLengthError) {
        this.phoneLengthError = phoneLengthError;
    }

    /**
     * @return the familyLengthErrror
     */
    public String getFamilyLengthErrror() {
        return familyLengthErrror;
    }

    /**
     * @param familyLengthErrror the familyLengthErrror to set
     */
    public void setFamilyLengthErrror(String familyLengthErrror) {
        this.familyLengthErrror = familyLengthErrror;
    }
    
    
    
    
}
