package com.todo.dao;

import java.util.Date;

public class TodoItem { // 데이터 클래스
    private String title;
    private String desc;
    private Date current_date;

    public TodoItem(String title, String desc) {
        // 객체 생성자
        this.title = title;
        this.desc = desc;
        this.current_date = new Date(); // 현재 시각 자동 입력
    }

    // 기본적인 getter와 setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(Date current_date) {
        this.current_date = current_date;
    }

    // 화면상에 보이기 위해 변형
    @Override
    public String toString() {
        return "[" + title + "]" + desc + "-" + current_date;
    }


}
