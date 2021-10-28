package CopyNIO2;
import java.io.*;
import java.nio.channels.FileChannel;

public class CooopyNIO2 {
    public static void main(String[] args) throws IOException {
        File copy1 = new File("copy1.txt");
        File copy2 = new File("copy2.txt");
        File copy3 = new File("copy3.txt");
        File copy4 = new File("copy4.txt");
        copy(copy1, copy2 ,copy3, copy4);
    }
    private static void copy(File copy1, File copy2, File copy3, File copy4) throws IOException {
        FileChannel Channel1 = null;
        FileChannel Channel2 = null;
        long start = System.currentTimeMillis();
        try {
            Channel1 = new FileInputStream(copy1).getChannel();
            Channel2 = new FileOutputStream(copy2).getChannel();
            Channel2.transferFrom(Channel1, 0, Channel1.size());
        }
        finally{
            Channel1.close();
            Channel2.close();
        }

        //////

        FileChannel Channel3 = null;
        FileChannel Channel4 = null;
        try {
            Channel3 = new FileInputStream(copy3).getChannel();
            Channel4 = new FileOutputStream(copy4).getChannel();
            Channel4.transferFrom(Channel3, 0, Channel3.size());
        }finally{
            Channel3.close();
            Channel4.close();
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
