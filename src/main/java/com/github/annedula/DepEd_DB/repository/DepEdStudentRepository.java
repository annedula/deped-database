package com.github.annedula.DepEd_DB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.annedula.DepEd_DB.entity.DepEdStudent;

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