package com.example.ios_back.repository.memoryRepository;

import com.example.ios_back.domain.Classroom;
import com.example.ios_back.domain.User;
import com.example.ios_back.repository.ClassroomRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryClassroomRepository implements ClassroomRepository {

    private static Map<Long, Classroom> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Classroom createClassroom(Long teacherId) {
        Classroom classroom = new Classroom(teacherId);
        return classroom;
    }

    @Override
    public Optional<Classroom> findByTeacherId(Long teacherId) {
        return store.values().stream()
                .filter(member -> member.getTeacherId().equals(teacherId))
                .findAny();
    }


}
