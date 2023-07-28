import entity.Instructor;
import entity.Student;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@Slf4j
public class CreateStudentInheritancePerTableDemo {
    public static void main (String[] args) {
        SessionFactory sessionFactory = new Configuration ()
                .configure ("hibernate.cfg.xml")
                .addAnnotatedClass (Student.class)
                .addAnnotatedClass (User.class)
                .addAnnotatedClass (Instructor.class)
                .buildSessionFactory ();

        try (sessionFactory; Session session = sessionFactory.getCurrentSession ()) {
            User student1 = new Student ("John", "Doe", "John@gmail.com", "Java");
            User student2 = new Student ("Mary", "Public", "Mary@com", "Python");
            User instructor1 = new Instructor ("Mary", "Public", "Mary@com", 55.55);
            User instructor2 = new Instructor ("John", "Doe", "@com", 99.99);


            session.beginTransaction ();
            log.info ("Saving the students and images");
            session.persist (student1);
            session.persist (student2);
            session.persist (instructor1);
            session.persist (instructor2);

            session.getTransaction ().commit ();
            log.info ("Done!");

        } catch (Exception e) {
            log.error ("SQLException: " + e.getMessage ());

        }
    }
}
