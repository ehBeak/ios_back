package com.example.ios_back.repository.memoryRepository;

import com.example.ios_back.domain.Subject;
import com.example.ios_back.repository.SubjectRepository;

import java.util.HashMap;
import java.util.Map;

public class MemorySubjectRepository implements SubjectRepository {

    private static Map<Long, Subject> store = new HashMap<>();
    private static long sequence = 0L;

    /* 과목 저장 */
    @Override
    public void save(Subject subject) {
        store.put(++sequence, subject);
    }

    /* 과목 조회 */
    @Override
    public Subject findById(Long subjectId) {
        return store.get(subjectId);
    }
}
