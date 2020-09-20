package me.heesu.crudDemo;

import me.heesu.entity.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ReadDemo extends BaseDemo {


    public static void main(String[] args) {
        Session session = getSession();

        try {
            session.beginTransaction();


            List<User> userList = new ArrayList<>();

            // 1
            userList = session.createQuery("from User", User.class).list();
            printUser(userList);

            // 2. where
            userList = session.createQuery("from User s where s.lastName='heesu'", User.class).list();
            printUser(userList);

            // 3. where, and, or
            userList = session.createQuery("from User s "
                    +" where s.lastName='heesu'"
                    +" or s.firstName='A'", User.class).list();
            printUser(userList);

            // 4. like
            userList = session.createQuery("from User s "
                    +" where email like 'email%'", User.class).list();
            printUser(userList);

            session.getTransaction().commit();

        } catch (Exception e) {

        }
    }

    private static void printUser(List<User> userList) {
        System.out.println("######################################################");
        for(User u : userList){
            System.out.println(u);
        }
        System.out.println("######################################################");
    }
}
