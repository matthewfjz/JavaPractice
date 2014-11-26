package javaio.redirecting;

import java.io.*;

public class RedirectOut
{
    public static void main(String[] args)
    {
        PrintStream ps = null;
        try
        {
            // һ�δ���PrintStream�����
            ps = new PrintStream(new FileOutputStream("out.txt"));
            // ����׼����ض���ps�����
            System.setOut(ps);
            // ���׼���һ���ַ���
            System.out.println("��ͨ�ַ���");
            // ���׼������һ������
            System.out.println(new RedirectOut());
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (ps != null)
            {
                ps.close();
            }
        }
    }
}