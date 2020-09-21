package me.heesu.mappingDemo.oneToOne;

import me.heesu.config.BaseDemo;
import me.heesu.entity.InstructorDtl;
import org.hibernate.Session;

public class GetInstructorDtlDemo extends BaseDemo {

    public static void main(String[] args) {
        Session s = getSession();

        try {

            s.beginTransaction();
            int tgtDtlId = 1; // db에 들어가있는 값 확인

            InstructorDtl instDtl = s.get(InstructorDtl.class, tgtDtlId);

            //mappedBy 설정으로 instructorDtl 조회 시, 연관된 instructor객체도 가져오는지 확인
            System.out.println("################### INSTRUCTOR OBJ : " + instDtl.getInstructor());


            s.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
    }
}
