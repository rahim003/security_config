package kurbanov.restapiwork.repository;

import kurbanov.restapiwork.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    @Query("select case when count(c) > 0 then true else false end" +
            " from Company c where c.companyName = ?1")
    boolean existsByCompanyName(String companyName);

    Optional<Company> findByCompanyName(String companyName);

    Optional<Company> findByLocatedCountry(String locatedCountry);
}
