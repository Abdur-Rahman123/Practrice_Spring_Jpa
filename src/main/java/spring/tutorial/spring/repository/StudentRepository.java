package spring.tutorial.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.tutorial.spring.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long>{
    List<Student>findByFirstName(String name);
    List<Student>findByFirstNameContaining(String name);
    List<Student>findByLastNameNotNull();
    List<Student>findByGuardianName(String name);
    //JPQL
    @Query("select s from Student s where s.emailId=?1")
    Student findStudentByEmailAddress(String email);

    @Query("select s.lastName from Student s where s.emailId = ?1")
    String findStudentFirstNameByEmailAddress(String email);
}
