package me.heesu.mappingDemo.oneToOne;

import me.heesu.config.BaseDemo;
import me.heesu.entity.InstructorDtl;
import org.hibernate.Session;

public class DeleteInstructorDtlDemo extends BaseDemo {

    public static void main(String[] args) {
        Session s = getSession();

        try {
            int deleteTgtId = 3;
            s.beginTransaction();

            InstructorDtl instDtl = s.get(InstructorDtl.class, deleteTgtId);

            //chk1. Instructor 까지 같이 삭제되는지 확인 (cascade유형에 DELETE가 포함되어있는 경우)

            //chk2. dtl만 삭제하고 싶을 경우는, bi-directional link를 삭제해야한다.
            instDtl.getInstructor().setInstructorDtl(null); // **********

            s.delete(instDtl);

            s.getTransaction().commit();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            s.close();
        }
    }
}
