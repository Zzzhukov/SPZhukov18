package CopyNIO1;

import java.io.*;
import java.nio.channels.FileChannel;


public class CooopyNIO1 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("copy1.txt");
        File copy2 = new File("copy2.txt");
        copy(file1, copy2);

    }
    private static void copy(File copy1, File copy2) throws IOException {
        FileChannel Channel1 = null;
        FileChannel Channel2 = null;
        long start = System.currentTimeMillis();
        try {
            Channel1 = new FileInputStream(copy1).getChannel();
            Channel2 = new FileOutputStream(copy2).getChannel();
            Channel2.transferFrom(Channel1, 0, Channel1.size());
        }finally{
            Channel1.close();
            Channel2.close();
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}