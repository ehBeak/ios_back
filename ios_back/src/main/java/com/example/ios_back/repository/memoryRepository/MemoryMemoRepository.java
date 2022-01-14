package com.example.ios_back.repository.memoryRepository;

import com.example.ios_back.domain.Memo;
import com.example.ios_back.domain.User;
import com.example.ios_back.repository.MemoRepository;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemoRepository implements MemoRepository {

    private static final Map<Long, Memo> store = new HashMap<>();
    private static Long sequence = 0L;

    /* save Memo*/
    @Override
    public void saveMemo(User user, String title, String content) {
        Memo memo = Memo.createMemo(++sequence, title, content);
        store.put(memo.getId(), memo);
    }

    @Override
    public void updateMemo(Long memoId, String content) {
        Memo memo = store.get(memoId);
        memo.setContent(content);
    }

    @Override
    public void clear(Long memoId) {
        store.remove(memoId);
    }

}
