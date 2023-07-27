
import entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

@Slf4j
public class CreateStudentImagesMapDemo {
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

            Map<String, String> mapImages = student1.getImagesMap ();
            mapImages.put ("photo1.jpg", "Photo 1");
            mapImages.put ("photo2.jpg", "Description 2");

            Set<String> sortedImages = student1.getImagesSorted ();
            sortedImages.add ("photo4.jpg");
            sortedImages.add ("photo1.jpg");
            sortedImages.add ("photo3.jpg");
            sortedImages.add ("photo2.jpg");

            SortedMap<String, String> sortedMapImages = student1.getSortedImagesMap ();
            sortedMapImages.put ("photo4.jpg", "Photo 4");
            sortedMapImages.put ("photo1.jpg", "Photo 1");
            sortedMapImages.put ("photo3.jpg", "Photo 3");
            sortedMapImages.put ("photo2.jpg", "Photo 2");

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
        } finally {
            session.close ();
            sessionFactory.close ();
        }
    }
}
