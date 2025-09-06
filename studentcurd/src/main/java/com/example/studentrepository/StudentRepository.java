package com.example.studentrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentcrud.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
