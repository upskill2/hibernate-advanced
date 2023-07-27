import entity.Student;


import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Set;

@Slf4j
public class CreateStudentImagesSetDemo {
    public static void main (String[] args)  {
        SessionFactory sessionFactory =  new Configuration ()
                .configure ("hibernate.cfg.xml")
                .addAnnotatedClass (Student.class)
                .buildSessionFactory ();

        Session session = sessionFactory.getCurrentSession ();

        try {
            Student student1 = new Student ("John", "Doe", "John@gmail.com");

            Set<String> theImages = student1.getImages ();
            theImages.add ("photo1.jpg");
            theImages.add ("photo2.jpg");
            theImages.add ("photo3.jpg");
            theImages.add ("photo4.jpg");
            theImages.add ("photo4.jpg");

            List<String> listImages1 = student1.getImagesList ();
            listImages1.add ("photoA.jpg");
            listImages1.add ("photoB.jpg");
            listImages1.add ("photoC.jpg");
            listImages1.add ("photoC.jpg");


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
            log.error ("SQLException: " + e.getMessage());

        } finally {
            session.close ();
            sessionFactory.close ();
        }
    }
}
