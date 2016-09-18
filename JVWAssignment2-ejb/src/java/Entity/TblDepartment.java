/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tu Nguyen
 */
@Entity
@Table(name = "tbl_department", catalog = "JVWAssignment2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDepartment.findAll", query = "SELECT t FROM TblDepartment t"),
    @NamedQuery(name = "TblDepartment.findByDepID", query = "SELECT t FROM TblDepartment t WHERE t.depID = :depID"),
    @NamedQuery(name = "TblDepartment.findByName", query = "SELECT t FROM TblDepartment t WHERE t.name = :name")})
public class TblDepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "depID", nullable = false, length = 20)
    private String depID;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    public TblDepartment() {
    }

    public TblDepartment(String depID) {
        this.depID = depID;
    }

    public TblDepartment(String depID, String name) {
        this.depID = depID;
        this.name = name;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depID != null ? depID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDepartment)) {
            return false;
        }
        TblDepartment other = (TblDepartment) object;
        if ((this.depID == null && other.depID != null) || (this.depID != null && !this.depID.equals(other.depID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblDepartment[ depID=" + depID + " ]";
    }
    
}
