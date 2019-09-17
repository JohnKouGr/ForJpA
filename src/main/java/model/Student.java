/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author highl
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByAt", query = "SELECT s FROM Student s WHERE s.at = :at")
    , @NamedQuery(name = "Student.findByStudentname", query = "SELECT s FROM Student s WHERE s.studentname = :studentname")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AT")
    private Integer at;
    @Basic(optional = false)
    @Column(name = "studentname")
    private String studentname;
    @JoinColumn(name = "AT", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Course course;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student1")
    private Course course1;

    public Student() {
    }

    public Student(Integer at) {
        this.at = at;
    }

    public Student(Integer at, String studentname) {
        this.at = at;
        this.studentname = studentname;
    }

    public Integer getAt() {
        return at;
    }

    public void setAt(Integer at) {
        this.at = at;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse1() {
        return course1;
    }

    public void setCourse1(Course course1) {
        this.course1 = course1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (at != null ? at.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.at == null && other.at != null) || (this.at != null && !this.at.equals(other.at))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Student[ at=" + at + " ]";
    }
    
}
