package javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputBufTest
{

    public static void main(String[] args)
    {
        // InputStreamReader���ֽ���ת��Ϊ�ַ�����Reader���ַ�����BufferedReader���л�����ַ���
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String s = br.readLine() ;
            
            while (s.length() !=0)
            {
                System.out.println(s);
                s= br.readLine();
            }
            
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
