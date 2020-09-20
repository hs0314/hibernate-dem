package me.heesu.crudDemo;

import me.heesu.entity.User;
import org.hibernate.Session;

public class DeleteDemo extends BaseDemo {

    public static void main(String[] args){

        try{
            // 1. hql
            Session session = getSession();
            session.beginTransaction();
            int id = 1;
            session.createQuery("delete from User where id="+id)
                    .executeUpdate();
            session.getTransaction().commit(); // commit() 이후에 자동으로 session을 close하기 때문에 새로운 sessiond을 받아와야함

            // 2. retrieve and delete
            session = getSession();
            session.beginTransaction();
            int tgtId = 2;
            User deleteTgt = session.get(User.class, tgtId);
            session.delete(deleteTgt);
            session.getTransaction().commit(); // commit() 이후에 자동으로 session을 close하기 때문에 새로운 sessiond을 받아와야함

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
