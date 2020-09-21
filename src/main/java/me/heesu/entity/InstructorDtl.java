package me.heesu.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString(exclude = {"instructor"})
@NoArgsConstructor
@Entity
@Table(name="instructor_dtl")
public class InstructorDtl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="chnl")
    private String chnl;

    @Column(name="hobby")
    private String hobby;

    // 해당 mappedBy를 통해서 연관된 Instructor 객체를 참조할 수 있다. (Instructor객체의 InstructorDtl 필드와 매핑)
    @OneToOne(mappedBy = "instructorDtl", cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    Instructor instructor;

    public InstructorDtl(String chnl, String hobby){
        this.chnl = chnl;
        this.hobby = hobby;
    }
}
