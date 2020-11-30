package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import Entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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
int theStudentId = 2;
Student tempStudent = session.get(Student.class, theStudentId);

            System.out.println("\n Deleting the student:" +tempStudent);
            session.delete(tempStudent);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {


            session.close();
            factory.close();
        }
    }

}