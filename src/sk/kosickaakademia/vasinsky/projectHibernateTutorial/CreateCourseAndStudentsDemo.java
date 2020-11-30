package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import Entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

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


            Course tempCourse = new Course("Bikeracing - How to ride a bike");


            tempCourse.addReview(new Review("I love it!"));
            tempCourse.addReview(new Review("Cool!"));
            tempCourse.addReview(new Review("Boo Sucks!"));


            System.out.println("Saving the course...");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);
            System.out.println("Course "+tempCourse +" saved!");
Student student1 = new Student("Janko","Hrasko","hrasino@gmail.com");
Student student2 = new Student("Marienka","Hraskova","marienka@gmail.com");

tempCourse.addStudent(student1);
tempCourse.addStudent(student2);
            System.out.println("Saving the students...");
            session.save(student1);
            session.save(student2);
            System.out.println("Students "+student1 + ", "+student2+" Saved!");

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {


            session.close();
            factory.close();
        }
    }

}