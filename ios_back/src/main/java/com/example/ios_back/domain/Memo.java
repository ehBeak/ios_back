package com.example.ios_back.domain;

public class Memo {
    private Long id;
    private String title;
    private String content;

    public Memo(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /* 비지니스 로직 */
    public static Memo createMemo(Long id, String title, String content) {
        Memo memo = new Memo(id, title, content);
        return memo;
    }
}
