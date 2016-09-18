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
 * @author Binh Nguyen
 */
@Entity
@Table(name = "tbl_status", catalog = "JVWAssignment2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblStatus.findAll", query = "SELECT t FROM TblStatus t"),
    @NamedQuery(name = "TblStatus.findByStatusID", query = "SELECT t FROM TblStatus t WHERE t.statusID = :statusID"),
    @NamedQuery(name = "TblStatus.findByName", query = "SELECT t FROM TblStatus t WHERE t.name = :name")})
public class TblStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "statusID", nullable = false)
    private Integer statusID;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    public TblStatus() {
    }

    public TblStatus(Integer statusID) {
        this.statusID = statusID;
    }

    public TblStatus(Integer statusID, String name) {
        this.statusID = statusID;
        this.name = name;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
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
        hash += (statusID != null ? statusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblStatus)) {
            return false;
        }
        TblStatus other = (TblStatus) object;
        if ((this.statusID == null && other.statusID != null) || (this.statusID != null && !this.statusID.equals(other.statusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblStatus[ statusID=" + statusID + " ]";
    }
    
}
