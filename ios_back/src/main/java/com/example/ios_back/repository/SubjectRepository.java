package com.example.ios_back.repository;

import com.example.ios_back.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    /*
     * 과목 저장*/
    @Override
    <S extends Subject> S save(S entity);

    /*
     * 과목 조회*/
    @Override
    Optional<Subject> findById(Long aLong);
}
