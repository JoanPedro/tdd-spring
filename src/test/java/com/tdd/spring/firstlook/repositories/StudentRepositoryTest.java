package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class StudentRepositoryTest {

  @Autowired
  StudentRepository studentRepository;

  @BeforeEach
  void setup() {
    List<Student> students = studentRepository.findAllStudents();
    if (students.isEmpty()) {
      Student s1 = new Student(null, "Joan Pedro", "Oliveira de Souza", 90);
      Student s2 = new Student(null, "Bill", "Gates", 75);
      Student s3 = new Student(null, "John", "Len", 80);

      studentRepository.saveAll(Arrays.asList(s1, s2, s3));
    }
  }

  @Test
  void testStudentJPQL1() {
    List<Student> students = studentRepository.findAllStudents();
    assertEquals(3, students.size());
  }

  @Test
  void testStudentJPQL2() {
    List<Object[]> students = studentRepository.findAllStudentsPartialData();

    students.forEach(obj -> {
      System.out.println("1: " + obj[0] + " 2: " + obj[1]);
    });

    assertEquals(3, students.size());
  }

  @Test
  void testStudentJPQL3() {
    List<Student> students = studentRepository.findAllStudentsByFirstName("Joan Pedro");

    assertEquals(1, students.size());
  }

  @Test
  void testStudentJPQL4() {
    List<Student> students = studentRepository.findAllStudentsByScore(75);

    assertEquals(1, students.size());
  }

  @Test
  void testStudentJPQL5() {
    List<Student> students = studentRepository.findAllStudentsByScoreRange(70, 80);

    assertEquals(1, students.size());
  }

  @Test
  @Transactional
  void testStudentJPQL6() {
    studentRepository.deleteStudentsByFirstName("Joan Pedro");
    List<Student> students = studentRepository.findAll();

    assertEquals(2, students.size());
  }
}
