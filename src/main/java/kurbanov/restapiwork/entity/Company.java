package kurbanov.restapiwork.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company {
    @SequenceGenerator(name = "company_sequence",
            sequenceName = "company_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "company_seq")
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "located_country")
    private String locatedCountry;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses = new ArrayList<>();

}
