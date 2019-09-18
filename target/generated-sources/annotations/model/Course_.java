package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Student;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-18T15:19:21")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> coursename;
    public static volatile SingularAttribute<Course, Student> student;
    public static volatile SingularAttribute<Course, Integer> courseId;

}