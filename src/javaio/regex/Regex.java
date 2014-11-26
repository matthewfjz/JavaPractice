package javaio.regex;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������ʽ
 * 
 * @version V5.0
 * @author ���ý�
 * @date 2009-11-9
 */
public class Regex
{

    /**
     * @param args
     * @author ���ý�
     * @date 2009-11-9 ����11:27:28
     */

    public static void main(String[] args)
    {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        Pattern pattern = Pattern.compile("b*g");
        Matcher matcher = pattern.matcher("bbg");
        System.out.println(matcher.matches());
        System.out.println(pattern.matches("b*g", "bbg"));
        // ��֤��������
        System.out.println(pattern.matches("[0-9]{6}", "200038"));
        System.out.println(pattern.matches("//d{6}", "200038"));
        // ��֤�绰����
        System.out.println(pattern.matches("[0-9]{3,4}//-?[0-9]+", "02178989799"));
        getDate("Nov 10,2009");
        charReplace();
        // ��֤���֤:�ж�һ���ַ����ǲ������֤���룬���Ƿ���15��18λ���֡�
        System.out.println(pattern.matches("^//d{15}|//d{18}$", "123456789009876"));
        getString("D:/dir1/test.txt");
        getChinese("welcome to china,��������,welcome,��!");
        validateEmail("luosijin123@163.com");
    }

    /**
     * ������ȡ:��ȡ���·���
     * 
     * @param str
     * @author ���ý�
     * @date 2009-11-9 ����11:56:06
     */
    public static void getDate(String str)
    {
        String regEx = "([a-zA-Z]+)|//s+[0-9]{1,2},//s*[0-9]{4}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find())
        {
            System.out.println("���ڸ�ʽ����!");
            return;
        }
        System.out.println(matcher.group(1)); // ���������ֵ�Ǵ�1��ʼ�ģ�����ȡ��һ������ķ�����m.group(1)������m.group(0)��
    }

    /**
     * �ַ��滻:��ʵ��Ϊ��һ���ַ��������а���һ�����������ġ�a���ĵط����滻�ɡ�A����
     * 
     * @author ���ý�
     * @date 2009-11-10 ����12:06:03
     */
    public static void charReplace()
    {
        String regex = "a+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("okaaaa LetmeAseeaaa aa booa");
        String s = matcher.replaceAll("A");
        System.out.println(s);
    }

    /**
     * �ַ�����ȡ
     * 
     * @param str
     * @author ���ý�
     * @date 2009-11-10 ����12:20:48
     */
    public static void getString(String str)
    {
        String regex = ".+/(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find())
        {
            System.out.println("�ļ�·����ʽ����ȷ��");
            return;
        }
        System.out.println(matcher.group(1));
    }

    /**
     * ������ȡ
     * 
     * @param str
     * @author ���ý�
     * @date 2009-11-10 ����12:27:17
     */
    public static void getChinese(String str)
    {
        String regex = "[//u4E00-//u9FFF]+";// [//u4E00-//u9FFF]Ϊ����
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find())
        {
            sb.append(matcher.group());
        }
        System.out.println(sb);
    }

    /**
     * ��֤Email
     * 
     * @param email
     * @author ���ý�
     * @date 2009-11-10 ����12:34:50
     */
    public static void validateEmail(String email)
    {
        String regex = "[0-9a-zA-Z]+@[0-9a-zA-Z]+//.[0-9a-zA-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches())
        {
            System.out.println("���ǺϷ���Email");
        }
        else
        {
            System.out.println("���ǷǷ���Email");
        }
    }
}