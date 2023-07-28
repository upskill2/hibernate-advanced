import entity.Status;
import entity.Student;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@Slf4j
public class CreateStudentEnumeratedDemo {
    public static void main (String[] args)  {
        SessionFactory sessionFactory =  new Configuration ()
                .configure ("hibernate.cfg.xml")
                .addAnnotatedClass (Student.class)
                .addAnnotatedClass (Status.class)
                .buildSessionFactory ();

        try (sessionFactory; Session session = sessionFactory.getCurrentSession ()) {
            Student student1 = new Student ("John", "Doe", "John@gmail.com", Status.ACTIVE);
            Student student2 = new Student ("Mary", "Public", "Mary@com", Status.DELETED);
            Student student3 = new Student ("Bonita", "Applebum", "Bonita@com", Status.INACTIVE);
            Student student4 = new Student ("James", "Bond", "James@com", Status.DELETED);

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
