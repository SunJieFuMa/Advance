package com.example.sj.lib.testcope.sample1;

import java.util.Date;

public class TestCopy {

//    ��΢���ӵ����(deep copy)


/*
    һ�㲽���ǣ�ǳ��������
            1. ������������Ҫʵ��Clonenable�ӿ�
              ����ʵ�ֵĻ��ڵ���clone�������׳�CloneNotSupportedException�쳣)
               �ýӿ�Ϊ��ǽӿ�(�����κη���)
            2. ����clone()�������������η���Ϊpublic��
               �����е���super.clone()�����õ���Ҫ�Ŀ�������
              ��nativeΪ���ط���)
    ����Ŀ�������Ϊǳ����(Shallow Copy)  ǳ���������������͵ı���ֻ�Ƕ����ý��п���
*/
    public static void main(String[] args) {
        Address address = new Address("ɽ��");
        Student originalStudent = new Student(0, address);
        System.out.println("ԭʼ���ݣ�  " + originalStudent);
        Student copyStudent = (Student) originalStudent.clone();
        System.out.println("�������ݣ�  " + copyStudent);
        copyStudent.setNumber(1);
        // ǳ����ֻ�ǿ�����address���������ã���û�������Ŀ�����һ��ռ䣬��ֵ�������ٽ����÷��ظ��¶���
        copyStudent.getAddress().setAdd("����");
        System.out.println("�ı�Ŀ������ݣ� " + copyStudent + "        ԭʼ���ݣ� " + originalStudent);
        System.out.println("==�Ƚϣ�  " + (originalStudent == copyStudent));
        System.out.println("equals�Ƚϣ�  " + originalStudent.equals(copyStudent));
    }



    public static void main7(String[] args) {
        Student originalStudent = new Student(0);
        System.out.println("ԭʼ���ݣ�  " + originalStudent);
        Student copyStudent = (Student) originalStudent.clone();
        System.out.println("�������ݣ�  " + copyStudent);
        System.out.println("�ı�Ŀ������ݣ� " + copyStudent + "        ԭʼ���ݣ� " + originalStudent);
        System.out.println("==�Ƚϣ�  " + (originalStudent == copyStudent));
        System.out.println("equals�Ƚϣ�  " + originalStudent.equals(copyStudent));
    }

    public static void main6(String[] args) {
        Student originalStudent = new Student(0);
        System.out.println("ԭʼ���ݣ�  " + originalStudent);
        Student copyStudent = (Student) originalStudent.clone();
        System.out.println("�������ݣ�  " + copyStudent);
        copyStudent.setNumber(1);
        System.out.println("�ı�Ŀ������ݣ� " + copyStudent + "        ԭʼ���ݣ� " + originalStudent);
        System.out.println("==�Ƚϣ�  " + (originalStudent == copyStudent));
        System.out.println("equals�Ƚϣ�  " + originalStudent.equals(copyStudent));
    }

    public static void main5(String[] args) {
        Student originalStudent = new Student(0);
        System.out.println("ԭʼ���ݣ�  " + originalStudent);
        Student copyStudent = originalStudent;  // �����������ǽ�originalStudent�����ø�ֵ��copyStudent
        System.out.println("�������ݣ�  " + copyStudent);
        copyStudent.setNumber(1);
        System.out.println("�ı�Ŀ������ݣ� " + copyStudent + "        ԭʼ���ݣ� " + originalStudent);
        System.out.println("==�Ƚϣ�  " + (originalStudent == copyStudent));
        System.out.println("equals�Ƚϣ�  " + originalStudent.equals(copyStudent));
    }

    public static void main4(String[] args) {
        String originalString = new String("a");
        System.out.println("ԭʼ���ݣ�  " + originalString);
        String copyString = originalString;
        System.out.println("�������ݣ�  " + copyString);
        copyString = "b";
        System.out.println("�ı�Ŀ������ݣ� " + copyString + "        ԭʼ���ݣ� " + originalString);
    }

    public static void main3(String[] args) {
        String originalString = "a";
        System.out.println("ԭʼ���ݣ�  " + originalString);
        String copyString = originalString;
        System.out.println("�������ݣ�  " + copyString);
        copyString = "b";
        System.out.println("�ı�Ŀ������ݣ� " + copyString + "        ԭʼ���ݣ� " + originalString);
    }

    public static void main2(String[] args) {
        char originalChar = 'a';
        System.out.println("ԭʼ���ݣ�  " + originalChar);
        char copyChar = originalChar;
        System.out.println("�������ݣ�  " + copyChar);
        copyChar = 'b';
        System.out.println("�ı�Ŀ������ݣ� " + copyChar + "        ԭʼ���ݣ� " + originalChar);
    }

    public static void main1(String[] args) {
        int originalInt = 10;
        System.out.println("ԭʼ���ݣ�  " + originalInt);
        int copyInt = originalInt;
        System.out.println("�������ݣ�  " + copyInt);
        copyInt = ++copyInt;
        System.out.println("�ı�Ŀ������ݣ� " + copyInt + "        ԭʼ���ݣ� " + originalInt);
    }


}
