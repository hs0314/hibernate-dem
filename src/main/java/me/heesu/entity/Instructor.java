package me.heesu.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString(exclude = {"InstructorDtl"})
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

    public Instructor(String name, String email){
        this.name = name;
        this.email = email;
    }
}
