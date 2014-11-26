package javalib;

import java.lang.reflect.Method;
import java.util.Vector;

public class VectorDemo
{

    public static void main(String[] args)
    {

        int array[];
        int[] arr;
        array = new int[100];
        Method[] methods = VectorDemo.class.getMethods();

        Vector<String> vector = new Vector<String>();

        for (int i = 0; i <= 100; i++)
        {
            vector.addElement(String.valueOf(i));

        }

        for (int i = 10; i > 0; i--)
        {
            vector.removeElementAt(i * 10);
        }

        //best practice ��Ҫ��ǰ����ɾ��Ҫ�Ӻ���ǰɾ����Ϊremove��ʱ��size�ڱ�
/*        for (int i = 1; i < 10; i++)
        {
            vector.removeElementAt(i * 10);
        }
*/
        vector.insertElementAt("hello", 4); 
        for (int i = 0; i < vector.size(); i++)
        {
            System.out.println(vector.elementAt(i));
        }

    }

}
