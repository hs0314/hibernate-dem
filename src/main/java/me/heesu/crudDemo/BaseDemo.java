package me.heesu.crudDemo;

import me.heesu.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDemo{

    public static Session getSession(){
        //create session factory
        SessionFactory f = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        //create session
        Session session = f.getCurrentSession();

        return session;
    }
}
