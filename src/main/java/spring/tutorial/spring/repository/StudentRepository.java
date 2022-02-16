package spring.tutorial.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.tutorial.spring.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long>{
}
