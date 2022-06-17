package kurbanov.restapiwork.repository;

import kurbanov.restapiwork.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

   // boolean existsByEmail(String email);
}