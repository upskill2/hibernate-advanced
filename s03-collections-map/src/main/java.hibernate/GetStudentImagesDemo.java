import entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class GetStudentImagesDemo {

    public static void main (String[] args) {

        SessionFactory sessionFactory = new Configuration ()
                .configure ("hibernate.cfg_update.xml")
                .addAnnotatedClass (Student.class)
                .buildSessionFactory ();

        Session session = sessionFactory.getCurrentSession ();

        try {
            session.beginTransaction ();
            log.info ("Saving the students and images");

            Student student = session.get (Student.class, 1);
            log.info ("Student: " + student);
            log.info ("Images: " + student.getImagesSorted ());

            session.getTransaction ().commit ();
            log.info ("Done!");

        } catch (Exception e) {
            throw new RuntimeException (e);
        } finally {
            session.close ();
            sessionFactory.close ();
        }

    }
}
