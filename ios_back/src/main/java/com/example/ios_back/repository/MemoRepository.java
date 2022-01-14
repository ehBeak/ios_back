package com.example.ios_back.repository;

import com.example.ios_back.domain.User;

public interface MemoRepository {

    /* save */
    void saveMemo(User user, String title, String content);

    /* update */
    void updateMemo(Long memoId, String memo);

    /* delete */
    void clear(Long memoId);
}
