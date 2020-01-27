



    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.cfg.Configuration;



        public class HibernateMainDemo {

            public static void main(String[] args) {

                SessionFactory factory= new Configuration().
                        configure().
                        addAnnotatedClass(Student.class).
                        buildSessionFactory();

                Session session= factory.getCurrentSession();

                try {

                    System.out.println("creating new student object: ");
                    Student customer= new Student("nikita", "poudel", "nikitapoudeleden@gmail.com");

                    session.beginTransaction();
                    System.out.println("saving the object");
                    session.save(customer);


                    session.getTransaction().commit();


                    session= factory.getCurrentSession();

                    session.beginTransaction();
                    Student customer2= new Student("sunil", "niroula", "nikitapoudeleden@gmail.com");

                    session.save(customer2);
                    session.getTransaction().commit();
                    System.out.println("Done");


                }
                finally {
                    factory.close();
                }






            }

        }


