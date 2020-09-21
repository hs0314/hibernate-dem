package me.heesu.crudDemo;

import me.heesu.config.BaseDemo;
import me.heesu.entity.User;
import org.hibernate.Session;

public class PrimaryKeyDemo extends BaseDemo {

    public static void main(String[] args){
        Session session = getSession();

        try{
            User u1 = new User("A", "AA", "email@a.a");
            User u2 = new User("B", "BB",  "email@a.a");
            User u3 = new User("C", "CC", "email@a.a");

            session.beginTransaction();

            //Mysql autoincrement 를 통해서 uniq한 primary key값 생성
            session.save(u1);
            session.save(u2);
            session.save(u3);
            session.getTransaction().commit();

        }catch(Exception e){

        }
    }
}
