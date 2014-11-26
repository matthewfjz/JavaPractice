package javaio.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.FileOutputStream;

public class ZipOutputStreamDemo1
{
    public static void main(String args[]) throws Exception
    { // �����쳣�׳�
        File file = new File(".\\copy.JPG"); // ����Ҫѹ�����ļ�
        File zipFile = new File(".\\copy.zip"); // ����ѹ���ļ�����
        InputStream input = new FileInputStream(file); // �����ļ���������
        
        ZipOutputStream zipOut = null; // ����ѹ��������
        zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOut.putNextEntry(new ZipEntry(file.getName())); // ����ZipEntry����
        zipOut.setComment("www.mldnjava.cn"); // ����ע��
        int temp = 0;
        while ((temp = input.read()) != -1)
        { // ��ȡ����
            zipOut.write(temp); // ѹ�����
        }
        input.close(); // �ر�������
        zipOut.close(); // �ر������
    }
};