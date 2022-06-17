package kurbanov.restapiwork.repository;

import kurbanov.restapiwork.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Override
    @Modifying
    @Query("delete from Group g where g.id=:id and g.id=:id ")
    void deleteById(Long id);
}