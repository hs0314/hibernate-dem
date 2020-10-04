package me.heesu.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"instructorDtl", "courses"})
@NoArgsConstructor
@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    // relation mapping
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_dtl_id")
    private InstructorDtl instructorDtl;

    // Instructor - Course 에 cascade delete가 적용되지 않도록 한다.
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy = "instructor",  // Course class 의 instructor property와 매핑
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Course> courses;

    public Instructor(String name, String email){
        this.name = name;
        this.email = email;
    }

    public void add(Course c){
        if(courses == null){
            courses = new ArrayList<>();
        }

        courses.add(c);
        c.setInstructor(this);
    }
}
