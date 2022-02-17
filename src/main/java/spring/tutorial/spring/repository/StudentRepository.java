package spring.tutorial.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.tutorial.spring.entity.Student;

import javax.transaction.Transactional;
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

    //NATIVE QUERY
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address=?1 ",
    nativeQuery = true)
    Student findStudentByEmailAddressNative(String email);

    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address=:email",
            nativeQuery = true)
    Student findStudentByEmailAddressNativeName(@Param("email") String email);

    ///update native query
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name=?1 where email_address=?2",
    nativeQuery = true)
    int updateStudentNameByEmailAddress(String firstName,String emailId);
}
