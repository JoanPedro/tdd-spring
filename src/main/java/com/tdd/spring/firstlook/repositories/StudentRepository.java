package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query("FROM Student")
  List<Student> findAllStudents();

  @Query("FROM Student")
  List<Student> findAllStudents(Pageable pageable);

  @Query("SELECT student.firstName, student.lastName FROM Student as student")
  List<Object[]> findAllStudentsPartialData();

  @Query("SELECT students FROM Student as students " +
      "WHERE students.firstName = :FirstName ")
  List<Student> findAllStudentsByFirstName(@Param("FirstName") String firstName);


  @Query("SELECT students FROM Student as students " +
      "WHERE students.score = :Score")
  List<Student> findAllStudentsByScore(@Param("Score") Integer score);

  @Query("SELECT students FROM Student as students " +
      "WHERE students.score > :Min AND students.score < :Max")
  List<Student> findAllStudentsByScoreRange(@Param("Min") Integer min, @Param("Max") Integer max);

  @Modifying
  @Query("DELETE FROM Student WHERE firstName = :FirstName")
  void deleteStudentsByFirstName(@Param("FirstName") String firstName);
}
