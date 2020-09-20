package me.heesu.crudDemo;

import me.heesu.entity.User;
import org.hibernate.Session;

public class CreateDemo extends BaseDemo{

    public static void main(String[] args){
        Session session = getSession();

        try{
            User s = new User();
            s.setFirstName("22222lee");
            s.setLastName("heesu fof read");
            s.setEmail("aa@a.a");

            session.beginTransaction();

            session.save(s);
            session.getTransaction().commit();

            // 저장한 User read

            session = getSession();
            session.beginTransaction();

            User user = session.get(User.class, s.getId());

            System.out.println("Get Complete : " + user);
            session.getTransaction().commit();


        }catch(Exception e){

        }
    }
}
