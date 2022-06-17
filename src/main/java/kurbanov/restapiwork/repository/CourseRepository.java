package kurbanov.restapiwork.repository;

import kurbanov.restapiwork.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
