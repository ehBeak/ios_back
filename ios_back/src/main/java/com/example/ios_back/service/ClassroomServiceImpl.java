package com.example.ios_back.service;

import com.example.ios_back.domain.Authority;
import com.example.ios_back.domain.Classroom;
import com.example.ios_back.domain.User;
import com.example.ios_back.repository.ClassroomRepository;
import com.example.ios_back.repository.UserRepository;
import com.example.ios_back.repository.memoryRepository.MemoryClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService{

    private final UserRepository userRepository;
    private final ClassroomRepository classroomRepository;
    private final AuthorityPolicy authorityPolicy;

    public ClassroomServiceImpl(UserRepository userRepository, ClassroomRepository classroomRepository, AuthorityPolicy authorityPolicy) {
        this.userRepository = userRepository;
        this.classroomRepository = classroomRepository;
        this.authorityPolicy = authorityPolicy;
    }

    /* 클래스룸 생성 */
    @Override
    public Classroom createClassroom(String username) {
        // 사용자 조회
        User findUser = userRepository.findUserByUsername(username).get();

        // 선생님 권한 확인
        Authority authority = authorityPolicy.getAuthorityByUserId(findUser);
        if(authority == Authority.TEACHER) {
            // 선생님 id로 클래스룸 생성
            return classroomRepository.createClassroom(findUser.getId());
        }

        return null;
    }

    /* 사용자 클래스룸에 넣기*/
    @Override
    public User addUserToClassroom(User user) {
        return null;
    }

    /* 사용자 클래스룸에서 삭제*/
    @Override
    public void deleteUserInClassroom(User user) {

    }
}
