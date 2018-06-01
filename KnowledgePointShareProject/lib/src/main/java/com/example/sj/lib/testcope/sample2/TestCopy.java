package com.example.sj.lib.testcope.sample2;

public class TestCopy {

//    ��΢���ӵ����(deep copy)

    public static void main(String[] args) {
        Address address = new Address("ɽ��");
        Student originalStudent = new Student(0, address);
        System.out.println("ԭʼ���ݣ�  " + originalStudent);
        Student copyStudent =  originalStudent.clone();
        System.out.println("�������ݣ�  " + copyStudent);
        copyStudent.setNumber(1);
        copyStudent.getAddress().setAdd("����");
        System.out.println("�ı�Ŀ������ݣ� " + copyStudent + "        ԭʼ���ݣ� " + originalStudent);
        System.out.println("==�Ƚϣ�  " + (originalStudent == copyStudent));
        System.out.println("equals�Ƚϣ�  " + originalStudent.equals(copyStudent));
    }


}
