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
@Table(name = "tbl_employee", catalog = "JVWAssignment2", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEmployee.findAll", query = "SELECT t FROM TblEmployee t"),
    @NamedQuery(name = "TblEmployee.findByEmployeeID", query = "SELECT t FROM TblEmployee t WHERE t.employeeID = :employeeID"),
    @NamedQuery(name = "TblEmployee.findByName", query = "SELECT t FROM TblEmployee t WHERE t.name = :name"),
    @NamedQuery(name = "TblEmployee.findByAddress", query = "SELECT t FROM TblEmployee t WHERE t.address = :address"),
    @NamedQuery(name = "TblEmployee.findByEmail", query = "SELECT t FROM TblEmployee t WHERE t.email = :email"),
    @NamedQuery(name = "TblEmployee.findByPhone", query = "SELECT t FROM TblEmployee t WHERE t.phone = :phone"),
    @NamedQuery(name = "TblEmployee.findByManager", query = "SELECT t FROM TblEmployee t WHERE t.manager = :manager"),
    @NamedQuery(name = "TblEmployee.findByDepID", query = "SELECT t FROM TblEmployee t WHERE t.depID = :depID"),
    @NamedQuery(name = "TblEmployee.findByStatus", query = "SELECT t FROM TblEmployee t WHERE t.status = :status"),
    @NamedQuery(name = "TblEmployee.findBySalary", query = "SELECT t FROM TblEmployee t WHERE t.salary = :salary"),
    @NamedQuery(name = "TblEmployee.findByFamily", query = "SELECT t FROM TblEmployee t WHERE t.family = :family")})
public class TblEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "employeeID", nullable = false, length = 20)
    private String employeeID;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Basic(optional = false)
    @Column(name = "address", nullable = false, length = 20)
    private String address;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 30)
    private String email;
    @Basic(optional = false)
    @Column(name = "phone", nullable = false, length = 11)
    private String phone;
    @Basic(optional = false)
    @Column(name = "manager", nullable = false)
    private boolean manager;
    @Basic(optional = false)
    @Column(name = "depID", nullable = false, length = 20)
    private String depID;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private int status;
    @Basic(optional = false)
    @Column(name = "salary", nullable = false)
    private double salary;
    @Basic(optional = false)
    @Column(name = "family", nullable = false, length = 20)
    private String family;

    public TblEmployee() {
    }

    public TblEmployee(String employeeID) {
        this.employeeID = employeeID;
    }

    public TblEmployee(String employeeID, String name, String address, String email, String phone, boolean manager, String depID, int status, double salary, String family) {
        this.employeeID = employeeID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.manager = manager;
        this.depID = depID;
        this.status = status;
        this.salary = salary;
        this.family = family;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEmployee)) {
            return false;
        }
        TblEmployee other = (TblEmployee) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblEmployee[ employeeID=" + employeeID + " ]";
    }
    
}
