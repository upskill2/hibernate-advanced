import entity.Student;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@Slf4j
public class CreateStudentEmbeddableDemo {
    public static void main (String[] args)  {
        SessionFactory sessionFactory =  new Configuration ()
                .configure ("hibernate.cfg.xml")
                .addAnnotatedClass (Student.class)
                .buildSessionFactory ();

        try (sessionFactory; Session session = sessionFactory.getCurrentSession ()) {
            Student student1 = new Student ("John", "Doe", "John@gmail.com");
            student1.getAddress ().setStreet ("123 Main St");
            student1.getAddress ().setCity ("New York");
            student1.getAddress ().setZipcode (12345);

            Student student2 = new Student ("Mary", "Public", "Mary@com");
            Student student3 = new Student ("Bonita", "Applebum", "Bonita@com");
            Student student4 = new Student ("James", "Bond", "James@com");

            session.beginTransaction ();
            log.info ("Saving the students and images");
            session.persist (student1);
            session.persist (student2);
            session.persist (student3);
            session.persist (student4);

            session.getTransaction ().commit ();
            log.info ("Done!");

        } catch (Exception e) {
            log.error ("SQLException: " + e.getMessage ());

        }
    }
}
