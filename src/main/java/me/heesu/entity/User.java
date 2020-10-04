package me.heesu.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"courses"})
@NoArgsConstructor
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="first_name")
    String firstName;

    @Column(name="last_name")
    String lastName;

    @Column(name="email")
    String email;

    // User - Course에 cascade delete 적용안함
    @ManyToMany(fetch = FetchType.LAZY,
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="course_user",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="course_id"))
    private List<Course> courses;

    public User(String firstNm, String lastNm, String email){
        this.firstName = firstNm;
        this.lastName = lastNm;
        this.email = email;
    }

    public void addCourse(Course c){
        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(c);
    }
}
