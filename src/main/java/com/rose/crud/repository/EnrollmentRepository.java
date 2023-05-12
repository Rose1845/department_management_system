package com.rose.crud.repository;

import com.rose.crud.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
    public Enrollment findByEnrollmentId(Long enrollmentId);
}
