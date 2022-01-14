package com.example.ios_back.service;

import com.example.ios_back.domain.User;
import com.example.ios_back.repository.MemoRepository;
import com.example.ios_back.repository.UserRepository;

import java.util.Optional;

public class MemoService {

    private final MemoRepository memoRepository;
    private final UserRepository userRepository;

    public MemoService(MemoRepository memoRepository, UserRepository userRepository) {
        this.memoRepository = memoRepository;
        this.userRepository = userRepository;
    }

    /* 메모 생성 */
    public void createMemo(Long userId, String title, String content) {
        Optional<User> user = userRepository.findUserById(userId);
        memoRepository.saveMemo(user.get(), title, content);
    }

    /* 메모 업데이트 */
    public void updateMemo(Long memoId, String content) {
        memoRepository.updateMemo(memoId, content);
    }

    /* 메모 삭제 */
    public void deleteMemo(Long memoId) {
        memoRepository.clear(memoId);
    }


}
