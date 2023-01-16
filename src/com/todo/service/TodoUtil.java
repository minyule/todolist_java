package com.todo.service;

import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
    public static void createItem(TodoList list) {

        String title, desc;
        Scanner sc = new Scanner(System.in);

        System.out.print("[항목 추가]\n" + "제목 > ");
        title = sc.next(); // 제목 입력
        if (list.isDuplicate(title)) { // 중복 검사
            System.out.println("제목이 중복됩니다!");
            return;
        }
        sc.nextLine(); // 제목 뒤의 개행 문자 제외하기
        System.out.print("내용 > ");
        desc = sc.nextLine().trim(); // 한 문장을 통째로 받음. 좌우 공백 제거.

        TodoItem t = new TodoItem(title, desc); // TodoItem 객체 만듦
        list.addItem(t);
        System.out.println("추가되었습니다.");
    }
    public static void deleteItem(TodoList l) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[항목 삭제]\n" + "삭제할 항목의 제목을 입력하시오 > ");
        String title = sc.next();

        for (TodoItem item : l.getList()) {
            if (title.equals(item.getTitle())) {
                l.deleteItem(item);
                System.out.println("삭제되었습니다.");
                break;
            }
        }

    }
    public static void updateItem(TodoList l) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[항목 수정]\n" + "수정할 항목의 제목을 입력하시오 > ");
        String title = sc.next().trim();
        if (!l.isDuplicate(title)) {
            System.out.println("없는 제목입니다!");
            return;
        }
        System.out.print("새 제목 > ");
        String new_title = sc.next().trim();
        if (l.isDuplicate(new_title)) {
            System.out.println("제목이 중복됩니다!");
            return;
        }
        sc.nextLine();
        System.out.print("새 내용 > ");
        String new_description = sc.nextLine().trim();
        for (TodoItem item : l.getList()) {
            if (item.getTitle().equals(title)) {
                l.deleteItem(item);
                TodoItem t = new TodoItem(new_title, new_description);
                l.addItem(t);
                System.out.println("수정되었습니다.");
            }
        }
    }
    public static void listAll(TodoList l) {
        System.out.println("[전체 목록]");
        for (TodoItem item: l.getList()) {
            System.out.println(item.toString());
        }
    }
}
