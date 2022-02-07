package com.example.ios_back.repository;

import com.example.ios_back.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
