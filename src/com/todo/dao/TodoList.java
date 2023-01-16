package com.todo.dao;

import com.todo.service.TodoSortByName;
import com.todo.service.TodoSortByDate;

import java.util.*;

public class TodoList {  // 데이터 클래스
    // 멤버변수
    private List<TodoItem> list; //TodoItem 객체를 리스트로 다룸.

    public TodoList() {
        // 생성자
        this.list = new ArrayList<TodoItem>(); // TodoItem이라는 객체를 ArrayList에 하나씩 담아서 관리
    }

    public void addItem(TodoItem t) {
        list.add(t);
    }

    public void deleteItem(TodoItem t) {
        list.remove(t);
    }

    void editItem(TodoItem t, TodoItem updated) {
        int index = list.indexOf(t);
        list.remove(index);
        list.add(updated);
    }

    public ArrayList<TodoItem> getList() {
        return new ArrayList<TodoItem>(list);
    }

    public void sortByName() { // 정렬
        Collections.sort(list, new TodoSortByName());
    }

    public void reverseList() { // 역정렬
        Collections.reverse(list);
    }

    public void sortByDate() { // 날짜 정렬
        Collections.sort(list, new TodoSortByDate());
    }

    public int indexOf(TodoItem t) { // 특정 객체 위치 반환
        return list.indexOf(t);
    }

    public Boolean isDuplicate(String title) {
        for (TodoItem item : list) { // 중복 입력 방지
            if (title.equals(item.getTitle())) return true;
        }
        return false;
    }


}
