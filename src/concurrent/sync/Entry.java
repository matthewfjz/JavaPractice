package concurrent.sync;

public class Entry
{

    public static void main(String[] args)
    {
        // �����Ƕ�ͬһ��ʵ��
        Deligate deligate = new Deligate();
        for (int i = 0; i < 10; i++)
        {

            new SyncThread(deligate).start();

        }

    }

}
