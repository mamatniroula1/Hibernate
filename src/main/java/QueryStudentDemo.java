import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {


        public static void main(String[] args) {

            SessionFactory factory= new Configuration().
                    configure().
                    addAnnotatedClass(Student.class).
                    buildSessionFactory();

            Session session= factory.getCurrentSession();

            try {

               session.beginTransaction();

               //query the table to give all the objects

                List<Student> theStudents= session.createQuery(" from Student").getResultList();

                //display the students

                displayTheStudents(theStudents);


                //display the code




                theStudents=session.createQuery("from Student s where s.lastName='poudel'").getResultList();
                displayTheStudents(theStudents);

                session.getTransaction().commit();


            }
            finally {
                factory.close();
            }






        }

    private static void displayTheStudents(List<Student> theStudents) {
        for(Student student: theStudents){
            System.out.println(student);
        }
    }

}




