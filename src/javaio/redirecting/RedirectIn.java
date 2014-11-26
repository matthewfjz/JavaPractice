package javaio.redirecting;

import java.io.*;
import java.util.Scanner;

public class RedirectIn
{
    public static void main(String[] args)
    {
        FileInputStream fis = null;
        try
        {
            // һ�δ���PrintStream�����
            fis = new FileInputStream(".\\src\\javalib\\RedirectIn.java");
            // ����׼����ض���pis������
            System.setIn(fis);
            // ʹ��System.in����Scanner����,���ڻ�ȡ��׼����
            Scanner sc = new Scanner(System.in);
            // ��������һ�н�ֻ�ѻس���Ϊ�ָ���
            sc.useDelimiter("\n");
            // �ж��Ƿ�����һ��������
            while (sc.hasNext())
            {
                // ���������
                System.out.println("���������������:" + sc.next());
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (fis != null)
            {
                try
                {
                    fis.close();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }
}