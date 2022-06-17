package kurbanov.restapiwork.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq",
            sequenceName = "student_sequence",
            allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Enumerated(STRING)
    private StudyFormat studyFormat;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonIgnore
    private Group group;


}