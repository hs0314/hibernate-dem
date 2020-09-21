package me.heesu.crudDemo;

import me.heesu.config.BaseDemo;
import me.heesu.entity.User;
import org.hibernate.Session;

public class UpdateDemo extends BaseDemo {

    public static void main(String[] args){


        try{
            // 1. 전체 업데이트
            Session session = getSession();
            session.beginTransaction();
            session.createQuery("update User set email='test@1.1' where email like 'email%'")
                    .executeUpdate();
            System.out.println(session.isOpen());
            session.getTransaction().commit(); // commit() 이후에 자동으로 session을 close하기 때문에 새로운 sessiond을 받아와야함


            // 2. 특정 객체 업데이트
            session = getSession();
            System.out.println(session.isOpen());
            session.beginTransaction();
            int tgtId = 6;
            User updateTgt = session.get(User.class, tgtId);
            if(updateTgt != null){
                updateTgt.setFirstName("updated_firstNm");
                updateTgt.setLastName("updated_lastNm");
            }
            session.getTransaction().commit();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
