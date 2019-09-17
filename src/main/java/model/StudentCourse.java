/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author highl
 */
@Entity
@Table(name = "student_course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentCourse.findAll", query = "SELECT s FROM StudentCourse s")
    , @NamedQuery(name = "StudentCourse.findBySCId", query = "SELECT s FROM StudentCourse s WHERE s.sCId = :sCId")
    , @NamedQuery(name = "StudentCourse.findByFkStudent", query = "SELECT s FROM StudentCourse s WHERE s.fkStudent = :fkStudent")
    , @NamedQuery(name = "StudentCourse.findByFkCourse", query = "SELECT s FROM StudentCourse s WHERE s.fkCourse = :fkCourse")})
public class StudentCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "s_c_id")
    private Integer sCId;
    @Basic(optional = false)
    @Column(name = "fk_student")
    private String fkStudent;
    @Basic(optional = false)
    @Column(name = "fk_course")
    private String fkCourse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentFkId")
    private Collection<Student> studentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseFkId")
    private Collection<Course> courseCollection;

    public StudentCourse() {
    }

    public StudentCourse(Integer sCId) {
        this.sCId = sCId;
    }

    public StudentCourse(Integer sCId, String fkStudent, String fkCourse) {
        this.sCId = sCId;
        this.fkStudent = fkStudent;
        this.fkCourse = fkCourse;
    }

    public Integer getSCId() {
        return sCId;
    }

    public void setSCId(Integer sCId) {
        this.sCId = sCId;
    }

    public String getFkStudent() {
        return fkStudent;
    }

    public void setFkStudent(String fkStudent) {
        this.fkStudent = fkStudent;
    }

    public String getFkCourse() {
        return fkCourse;
    }

    public void setFkCourse(String fkCourse) {
        this.fkCourse = fkCourse;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sCId != null ? sCId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentCourse)) {
            return false;
        }
        StudentCourse other = (StudentCourse) object;
        if ((this.sCId == null && other.sCId != null) || (this.sCId != null && !this.sCId.equals(other.sCId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.StudentCourse[ sCId=" + sCId + " ]";
    }
    
}
