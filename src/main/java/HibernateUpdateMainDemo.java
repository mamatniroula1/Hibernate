import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUpdateMainDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().
                configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session= sessionFactory.getCurrentSession();
        
        try {

            //when we perform a transaction then we have to create a session and close every instance of the session a
            //after we open each of them
            session.beginTransaction();
            
            int studentId=1;
            session.getTransaction().commit();

            session= sessionFactory.getCurrentSession();
            session.beginTransaction();

            Student myStudent=session.get(Student.class, studentId);

            myStudent.setFirstName("scooby");

            session.getTransaction().commit();


        }finally {
            sessionFactory.close();
        }
    }
}
