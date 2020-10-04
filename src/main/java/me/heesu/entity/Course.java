package me.heesu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"instructor","reviews", "users"})
@NoArgsConstructor
@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    // Instructor - Course 에 cascade delete가 적용되지 않도록 한다.
    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id") //course 테이블의 조인컬럼
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="course_id")
    private List<Review> reviews;

    // User - Course에 cascade delete 적용안함
    @ManyToMany(fetch = FetchType.LAZY,
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="course_user",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    private List<User> users;

    public Course(String title){
        this.title = title;
    }

    public void addReview(Review r){
        if(reviews == null){
            reviews = new ArrayList<>();
        }
        reviews.add(r);
    }

    public void addUser(User u){
        if(users == null){
            users = new ArrayList<>();
        }
        users.add(u);
    }
}
