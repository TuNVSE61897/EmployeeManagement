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
@Table(name = "tbl_roles", catalog = "JVWAssignment2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRoles.findAll", query = "SELECT t FROM TblRoles t"),
    @NamedQuery(name = "TblRoles.findByRole", query = "SELECT t FROM TblRoles t WHERE t.role = :role"),
    @NamedQuery(name = "TblRoles.findByDescription", query = "SELECT t FROM TblRoles t WHERE t.description = :description")})
public class TblRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "role", nullable = false)
    private Integer role;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 50)
    private String description;

    public TblRoles() {
    }

    public TblRoles(Integer role) {
        this.role = role;
    }

    public TblRoles(Integer role, String description) {
        this.role = role;
        this.description = description;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (role != null ? role.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRoles)) {
            return false;
        }
        TblRoles other = (TblRoles) object;
        if ((this.role == null && other.role != null) || (this.role != null && !this.role.equals(other.role))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblRoles[ role=" + role + " ]";
    }
    
}
