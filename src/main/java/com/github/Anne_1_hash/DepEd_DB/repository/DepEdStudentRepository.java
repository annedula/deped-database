package com.github.Anne_1_hash.DepEd_DB.repository;

import com.github.Anne_1_hash.DepEd_DB.entity.DepEdStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DepEdStudentRepository extends JpaRepository<DepEdStudent, Long> {

    Optional<DepEdStudent> findByLrnAndFirstNameAndLastNameAndDateOfBirth(
            Long lrn,
            String firstName,
            String lastName,
            LocalDate dateOfBirth
    );
}