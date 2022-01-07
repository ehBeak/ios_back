package com.example.ios_back.service;

import com.example.ios_back.domain.Authority;
import com.example.ios_back.domain.Classroom;
import com.example.ios_back.domain.Subject;
import com.example.ios_back.domain.User;
import com.example.ios_back.repository.ClassroomRepository;
import com.example.ios_back.repository.SubjectRepository;
import com.example.ios_back.repository.UserRepository;

public class ClassroomServiceImpl implements ClassroomService{

    private final UserRepository userRepository;
    private final ClassroomRepository classroomRepository;
    private final AuthorityPolicy authorityPolicy;
    private final SubjectRepository subjectRepository;

    public ClassroomServiceImpl(UserRepository userRepository, ClassroomRepository classroomRepository, AuthorityPolicy authorityPolicy, SubjectRepository subjectRepository) {
        this.userRepository = userRepository;
        this.classroomRepository = classroomRepository;
        this.authorityPolicy = authorityPolicy;
        this.subjectRepository = subjectRepository;
    }

    /* 클래스룸 생성 */
    @Override
    public Classroom createClassroom(String username) {
        // 사용자 조회
        User findUser = userRepository.findUserByUsername(username).get();

        // 선생님 권한 확인
        Authority authority = authorityPolicy.getAuthorityByUser(findUser);
        if(authority == Authority.TEACHER) {
            // 선생님 id로 클래스룸 생성
            Classroom newClassroom = new Classroom(findUser.getId());
            classroomRepository.save(newClassroom);
            return newClassroom;
        }
        return null;
    }

    /* 클래스 룸에 과목 추가 */
    @Override
    public Subject addSubject(Classroom classroom, User user, String subjectName) {

        // 사용자 권한 조회(선생님)
        Authority authority = authorityPolicy.getAuthorityByUser(user);
        System.out.println("ClassroomServiceImpl.addSubject");

        if (authority == Authority.TEACHER) {
            // subject 저장, subject 생성, subjectName 설정
            Subject newSubject = new Subject(classroom, subjectName);
            subjectRepository.save(newSubject);
            System.out.println("ClassroomServiceImpl.addSubject");
            return newSubject;
        }

        return null;
    }


}
