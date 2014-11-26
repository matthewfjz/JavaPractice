package javaio.xstream;

import com.thoughtworks.xstream.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.<br>
 * <b>User</b>: leizhimin<br>
 * <b>Date</b>: 2008-5-22 21:10:47<br>
 * <b>Note</b>: XStreamѧϰ[[url]http://lavasoft.blog.51cto.com[/url]]
 */
public class XStreamDemo
{

    public static void main(String args[]) throws IOException
    {
        test();
    }

    public static void test() throws IOException
    {
        System.out
                .println("----------XStreamѧϰ:http://lavasoft.blog.51cto.com----------");
        // Ŀ�����
        Address address1 = new Address("3 zhenzhou rd", "450001");
        Address address2 = new Address("yanta rd", "710002");
        List<Address> addList = new ArrayList<Address>();
        addList.add(address1);
        addList.add(address2);
        Profile profile = new Profile("Sofeware Engineer", "13512129933", "Comment");
        Person person = new Person("JZ", "27", profile, addList);

        // ת��װ��
        XStream xStream = new XStream();

        /************** ��������� ****************/
        xStream.alias("PERSON", Person.class);
        xStream.alias("PROFILE", Profile.class);
        xStream.alias("ADDRESS", Address.class);
        
        /************* �������Ա�ı��� ***************/
        // ����Person���name��Ա����Name
        xStream.aliasField("NAME", Person.class, "name");
        xStream.aliasField("AGE", Person.class, "age");
        /*
         * [ע��] ����Person���profile��Ա����PROFILE,���������Profile��ı���һ��, �������Ա���XStream������Դ�profile��Ա���ɵ�xmlƬ��ֱ��ת��ΪProfile��Ա,
         * �����Աprofile�ı�����Profile�ı�����һ��,��profile��Ա���ɵ�xmlƬ�β��� ֱ��ת��ΪProfile����,��Ҫ���´���XStream����,���񲻸��Լ����鷳?
         */
        xStream.aliasField("PROFILE", Person.class, "profile");
        xStream.aliasField("ADDLIST", Person.class, "addlist");
        xStream.aliasField("ADD", Address.class, "add");
        xStream.aliasField("ZIPCODE", Address.class, "zipcode");
        xStream.aliasField("JOB", Profile.class, "job");
        xStream.aliasField("TEL", Profile.class, "tel");
        xStream.aliasField("REMARK", Profile.class, "remark");

        Writer os = null;
        os = new FileWriter("person.xml");
        xStream.toXML(person, os);

        xStream.alias("PERSON", Person.class);
        Person p = (Person) xStream.fromXML(new File("person.xml"));
        System.out.println("From XML file: "+p);

        /*********************************************/
        String xml = xStream.toXML(person);
        System.out.println(xml);
        output(1, xStream, person);
              
        Person anotherPerson = (Person)xStream.fromXML(xml);
        System.out.println("From XML variable: "+p);
  
        /******* �������ԱΪxmlһ��Ԫ���ϵ����� *******/
        xStream.useAttributeFor(Address.class, "zipcode");
        /************* �������Եı��� ***************/
        xStream.aliasAttribute(Address.class, "zipcode", "Zipcode");
        output(3, xStream, person);
        
     

    
    }

    public static void output(int i, XStream xStream, Object obj)
    {
        String xml = xStream.toXML(obj);
        System.out.println(">>>��[ " + i + "]�����\n");
        System.out.println(xml + "\n");
    }
}