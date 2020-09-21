package me.heesu.config;

import me.heesu.entity.Instructor;
import me.heesu.entity.InstructorDtl;
import me.heesu.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.domain.EntityScanner;

public class BaseDemo{

    public static Session getSession(){

        //TODO: entity를 더 간단하게 스캔할 수 있는 방법?
        //create session factory
        SessionFactory f = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDtl.class)
                .buildSessionFactory();

        //create session
        Session session = f.getCurrentSession();

        return session;
    }
}
