package spring.tutorial.spring.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.tutorial.spring.entity.Guardian;
import spring.tutorial.spring.entity.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
   private StudentRepository studentRepository ;

//public void saveStudent(){
//    Student student= Student.builder()
//            .emailId("rahman@gmail.com")
//            .firstName("abdur")
//            .lastName("rahman")
////            .guardianEmail("babul@gmail.com")
////            .guardianMobile("01712192256")
////            .guardianName("babul")
//            .build();
//    studentRepository.save(student);
//}
@Test
public void printStudent(){
    List<Student> studentList=studentRepository.findAll();
    System.out.println("StudentList"+studentList);
}
@Test
public void saveStudent(){
    Guardian guardian=Guardian.builder()
            .mobile("0177288")
            .email("rahman@gmail.com")
            .name("babul")
            .build();

    Student student=Student.builder()
                    .firstName("abdur")
                            .lastName("Rahman")
                                    .emailId("babul@gmail.com")
                                            .guardian(guardian)
            .build();

    studentRepository.save(student);
}
@Test
public void getDataByFirstName(){
   List<Student> studentList= studentRepository.findByFirstName("abdur");
    System.out.println("student list"+studentList);
}

    @Test
    public void getDataByFirstNameByChar(){
        List<Student> studentList= studentRepository.findByFirstNameContaining("ab");
        System.out.println("student list"+studentList);
    }

    @Test
    public void getDataOfObject(){
        List<Student> studentList= studentRepository.findByGuardianName("babul");
        System.out.println("GuardianName"+studentList);
    }

}