package kurbanov.restapiwork.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "course")
@Getter
@Setter
public class Course {
    @SequenceGenerator(name = "course_seq",
            sequenceName = "course_seq",
            allocationSize = 1)
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_seq")
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private String duration;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @ManyToMany(cascade = ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "course_groups",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "groups_id"))
    @ToString.Exclude
    private List<Group> groups = new ArrayList<>();

    @OneToOne(cascade = ALL, mappedBy = "course", orphanRemoval = true)
    private Teacher teacher;


    public void setGroup(Group group) {
        if (groups == null) {
            groups = new ArrayList<>();
        }
        groups.add(group);


    }

}