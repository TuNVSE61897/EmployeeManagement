/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Binh Nguyen
 */
@Entity
@Table(name = "tbl_leave", catalog = "JVWAssignment2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblLeave.findAll", query = "SELECT t FROM TblLeave t"),
    @NamedQuery(name = "TblLeave.findByLeaveID", query = "SELECT t FROM TblLeave t WHERE t.leaveID = :leaveID"),
    @NamedQuery(name = "TblLeave.findByFromDate", query = "SELECT t FROM TblLeave t WHERE t.fromDate = :fromDate"),
    @NamedQuery(name = "TblLeave.findByToDate", query = "SELECT t FROM TblLeave t WHERE t.toDate = :toDate"),
    @NamedQuery(name = "TblLeave.findByAccept", query = "SELECT t FROM TblLeave t WHERE t.accept = :accept"),
    @NamedQuery(name = "TblLeave.findByEmpID", query = "SELECT t FROM TblLeave t WHERE t.empID = :empID")})
public class TblLeave implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "leaveID", nullable = false)
    private Integer leaveID;
    @Basic(optional = false)
    @Column(name = "fromDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;
    @Basic(optional = false)
    @Column(name = "toDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
    @Column(name = "accept")
    private Boolean accept;
    @Basic(optional = false)
    @Column(name = "empID", nullable = false, length = 20)
    private String empID;

    public TblLeave() {
    }

    public TblLeave(Integer leaveID, Date fromDate, Date toDate, String empID) {
        this.leaveID = leaveID;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.empID = empID;
    }

    public Integer getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(Integer leaveID) {
        this.leaveID = leaveID;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Boolean getAccept() {
        return accept;
    }

    public void setAccept(Boolean accept) {
        this.accept = accept;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (leaveID != null ? leaveID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLeave)) {
            return false;
        }
        TblLeave other = (TblLeave) object;
        if ((this.leaveID == null && other.leaveID != null) || (this.leaveID != null && !this.leaveID.equals(other.leaveID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblLeave[ leaveID=" + leaveID + " ]";
    }
    
}
