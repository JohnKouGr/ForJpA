package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Course;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-18T15:19:21")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, Integer> studentId;
    public static volatile SingularAttribute<Student, String> studentname;
    public static volatile SingularAttribute<Student, Course> course;

}