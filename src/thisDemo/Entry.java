package thisDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Entry
{

    public static void main(String[] args)
    {
        new Person().eatApple(new Apple());
        Flower flower = new Flower();

        String s = null;
        InputStreamReader re = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(re);
        try
        {
            s = br.readLine();
            System.out.println("s= " + Integer.parseInt(s));
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (NumberFormatException e)// ��Ӧ�ó�����ͼ���ַ���ת����һ����ֵ���ͣ������ַ�������ת��Ϊ�ʵ���ʽʱ���׳����쳣��
        {
            System.out.println(" ����Ĳ������� ");
        }
    }

}
