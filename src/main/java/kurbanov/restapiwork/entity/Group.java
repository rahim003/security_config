package kurbanov.restapiwork.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "groups")
@Getter
@Setter
public class Group {
    @SequenceGenerator(name = "group_sequence",
            sequenceName = "group_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "date_of_start")
    @CreatedDate
    @CreationTimestamp
    private LocalDate dateOfStart;
    @Column(name = "date_of_finish")
    @CreatedDate
    @CreationTimestamp
    private LocalDate dateOfFinish;

    @JsonIgnore
    @ManyToMany(cascade = {MERGE, REFRESH, PERSIST, DETACH}, fetch = FetchType.EAGER)
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "group", cascade = ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    @JsonIgnore
    public void setCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setGroup(this);
    }
}