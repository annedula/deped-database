package com.github.annedula.DepEd_DB.controller;

import org.springframework.web.bind.annotation.*;

import com.github.annedula.DepEd_DB.repository.DepEdStudentRepository;

import java.time.LocalDate;


@RestController
@RequestMapping("/deped/api/v1")
public abstract class DepEdStudentController {

    private final DepEdStudentRepository depedStudentRepository;

    public DepEdStudentController(DepEdStudentRepository depedStudentRepository) {
        this.depedStudentRepository = depedStudentRepository;
    }

    // ✅ API Health Check
    @GetMapping("/")
    public String healthCheck() {
        return "API is working";
    }

    // ✅ Check LRN Endpoint
    @GetMapping("/check-lrn")
    public String checkLrn(
            @RequestParam Long lrn,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String date_of_birth
    ) {

        LocalDate dob = LocalDate.parse(date_of_birth);

        return depedStudentRepository
                .findByLrnAndFirstNameAndLastNameAndDateOfBirth(
                        lrn,
                        firstname,
                        lastname,
                        dob
                )
                .isPresent()
                ? "Exist"
                : "Student not exist";
    }
}