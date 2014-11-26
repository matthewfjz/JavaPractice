package javalib;

public class StringTest
{
    public static void main(String args[])
    {
        // �ڳ��кͶ��зֱ𴴽�String����"abc",s1ָ����ж���
        String s1 = new String("abc");
        // s2ֱ��ָ����ж���"abc"
        String s2 = "abc";
        // �ڶ����´���"abc"����s3ָ��ö���
        String s3 = new String("abc");
        // �ڳ��д�������"ab" �� "c"������s4ָ����ж���"abc"
        String s4 = "ab" + "c";
        // cָ����ж���"c"
        String c = "c";
        // �ڶ��д����µĶ���"abc"������s5ָ��ö���
        String s5 = "ab" + c;

        String s6 = "ab".concat("c");
        String s7 = "ab".concat(c);

        System.out.println("------------ʵ��-----------");
        System.out.println(s1 == s2); // false
        System.out.println(s1 == s3); // false
        System.out.println(s2 == s3); // false
        System.out.println(s2 == s4); // true
        System.out.println(s2 == s5); // false
        System.out.println(s2 == s6); // false
        System.out.println(s2 == s7); // false

        String b1 = new String("");
        String b2 = "";
        String b3 = new String("");
        String b4 = "".intern();
        String b5 = "" + "";
        String b6 = "".concat("");
        String b7 = "  ".trim();
        String b8 = "  ";
        String b9 = "    ".trim();

        System.out.println("------------�մ�-----------");
        System.out.println(b1 == b2); // false
        System.out.println(b1 == b3); // false
        System.out.println(b2 == b3); // false
        System.out.println(b2 == b4); // true
        System.out.println(b2 == b5); // true*
        System.out.println(b2 == b6); // true*
        System.out.println(b2 == b7); // false*
        System.out.println("-----a----");
        System.out.println(b2.equals(b7)); // true
        System.out.println(b7 == b8); // false
        System.out.println(b7 == b9); // false
        System.out.println(b7.equals(b9)); // true
        System.out.println(b9 == null);// false

        System.out.println("b8.trim():");
        for (byte b : b8.getBytes())
        {
            System.out.print(">>>" + (int) b + " ");
        }
        System.out.println("\nb8.trim():");
        for (byte b : b8.trim().getBytes())
        {
            System.out.print(">>>" + (int) b + " ");
        }
        System.out.println("\nb9.trim():");
        for (byte b : b9.trim().getBytes())
        {
            System.out.print(">>>" + (int) b + " ");
        }
    }
}