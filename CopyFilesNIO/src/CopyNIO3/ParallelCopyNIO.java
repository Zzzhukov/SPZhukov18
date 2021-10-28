package CopyNIO3;

import java.io.*;
import java.nio.channels.FileChannel;

public class ParallelCopyNIO extends Thread {
    String name;
    int priority;
    public ParallelCopyNIO(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        Thread.currentThread().setName(name);
        File copy1 = new File("copy1.txt");
        File copy2 = new File("copy2.txt");
        File copy3 = new File("copy3.txt");
        FileChannel Channel1 = null;
        FileChannel Channel2 = null;
        FileChannel Channel3 = null;
        try {
            Channel1 = new FileInputStream(copy1).getChannel();
            Channel2 = new FileOutputStream(copy2).getChannel();
            Channel3 = new FileOutputStream(copy3).getChannel();
            if(getName().equals("первый")){
                Channel2.transferFrom(Channel1, 0, Channel1.size());
            }
            else if(getName().equals("второй")){
                Channel3.transferFrom(Channel1, 0, Channel1.size());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                Channel1.close();
                Channel2.close();
                Channel3.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}