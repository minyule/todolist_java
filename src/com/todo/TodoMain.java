package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
    public static void start() {  // 프로그램이 돌아가는 가장 큰 구조
        Scanner sc = new Scanner(System.in);
        TodoList l = new TodoList();
        boolean isList = false;  // 플래그 변수
        boolean quit = false;  // 플래그 변수

        Menu.displaymenu();  // 메뉴를 화면에 보임
        do { // 루프가 돌고 있음.
            Menu.prompt();  // 메소드 실행
            isList = false;  //플래그 변수를 false로 세팅
            String choice = sc.next();
            switch (choice) {
                // CRUD
                case "add":
                    TodoUtil.createItem(l);  // todolist 객체를 받아서 createItem 메서드 실행
                    break;
                case "del":
                    TodoUtil.deleteItem(l);
                    break;
                case "edit":
                    TodoUtil.updateItem(l);
                    break;
                case "ls":
                    TodoUtil.listAll(l);
                    break;
                // 정렬에 관한 명령어
                case "ls_name_asc":
                    l.sortByName();
                    System.out.println("제목순으로 정렬했습니다.");
                    isList = true;
                    break;
                case "ls_name_desc":
                    l.sortByName();
                    l.reverseList();
                    System.out.println("제목 역순으로 정렬했습니다.");
                    isList = true;
                    break;
                case "is_date":
                    l.sortByDate();
                    System.out.println("날짜순으로 정렬했습니다.");
                    isList = true;
                    break;
                // 그 외 기능
                case "help":
                    Menu.displaymenu();
                    break;
                case "exit": // 플래그 변수 변경
                    quit = true;
                    break;
                default:  // 예외 처리
                    System.out.println("정확한 명령어를 입력하세요. (도움말 - help_");
                    break;
            }
            if (isList) TodoUtil.listAll(l);
        } while (!quit); // do 반복문 제어. quit 플래그 변수가 True가 되기 전까지는 무한 반복


    }
}
