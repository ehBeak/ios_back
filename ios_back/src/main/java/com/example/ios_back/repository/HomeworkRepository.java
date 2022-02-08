package com.example.ios_back.repository;

import com.example.ios_back.domain.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {

    @Override
    <S extends Homework> S save(S entity);
}
