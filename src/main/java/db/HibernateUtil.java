package db;

import Model.Entity.BookEntity;
import Model.Entity.MemberEntity;
import Model.Entity.issuBookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/library_db02?createDatabaseIfNotExist=true")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .addAnnotatedClass(BookEntity.class)
                    .addAnnotatedClass(MemberEntity.class)
                    .addAnnotatedClass(issuBookEntity.class);

            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shoutdown(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }
    public static void executeInTransaction(java.util.function.Consumer<Session> action){
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            action.accept(session);
            tx.commit();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
                throw e;
            }
            throw new RuntimeException(e);
        }finally{
            session.close();
        }
    }
}
