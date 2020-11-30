package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import Entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();


        try {

            session.beginTransaction();

int CourseId = 10;
Course tempCourse = session.get(Course.class, CourseId);

            System.out.println("Deleting a Course --->"+tempCourse);
            session.delete(tempCourse);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {


            session.close();
            factory.close();
        }
    }

}