package com.example.firstBoot;

import java.util.ArrayList;
interface Obj{
    void test();
    void test1();
}
// 오버라이딩할 메소드를 추가 상속하는 클래스 뒤에 커서를 맞추고  alt + enter
class child implements Obj{

    @Override
    public void test() {
        System.out.println("test");
    }

    @Override
    public void test1() {

    }
}
public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        System.out.println("test");
        System.out.println("test");     // ctrl+d = 줄복사
        String str = new String ("java");
        int size = str.length();      // ctrl + alt + v = 자동으로 변수를 생성
        ArrayList list = null;          // alt + enter = 자동으로 import
        System.out.println(size);       // shift + f6 = 변수명을 한꺼번에 변경
        System.out.println(size);       // ctrl + shift + / = 블록주석
        System.out.println(size);       // ctrl + / = 한줄 주석
        System.out.println(size);       // ctrl + shift + enter = 코드 완성
        System.out.println(size);       // ctrl + y = 한 줄 삭제
    }
}
