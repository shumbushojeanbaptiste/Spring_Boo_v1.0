package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // JPQL (object-based query)
    @Query("SELECT s FROM Student s WHERE s.age > :age")
    List<Student> findStudentsOlderThan(@Param("age") int age);

    // Native SQL query
    @Query(value = "SELECT * FROM student WHERE name LIKE %:name%", nativeQuery = true)
    List<Student> findByNameContains(@Param("name") String name);
}
