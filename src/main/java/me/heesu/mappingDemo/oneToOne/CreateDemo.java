package me.heesu.mappingDemo.oneToOne;

import me.heesu.config.BaseDemo;
import me.heesu.entity.Instructor;
import me.heesu.entity.InstructorDtl;
import org.hibernate.Session;

public class CreateDemo extends BaseDemo {

    public static void main(String[] args){
        Session s = getSession();

        try{
            Instructor inst = new Instructor("tedlee", "aaaba@1.1");
            InstructorDtl instDtl = new InstructorDtl("chnl url here", "hobby here");

            //relation mapping
            //이 시점에는 메모리상에서 연관관계를 맺게 된다.
            inst.setInstructorDtl(instDtl);

            s.beginTransaction();

            // 이 시점에 cascade 유형때문에 instDtl도 같이 저장
            s.save(inst);
            s.getTransaction().commit();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            s.close();
        }
    }
}
