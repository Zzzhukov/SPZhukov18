package Copy3;

import java.io.*;

public class ParallelCopy extends Thread {
    String name;
    int priority;
    public ParallelCopy(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        Thread.currentThread().setName(name);
        File fileOne = new File("copy1.txt");
        File fileTwo = new File("copy2.txt");
        File fileThree = new File("copy3.txt");
        InputStream is = null;
        OutputStream os = null;
        OutputStream os1 = null;
        try {
            is = new FileInputStream(fileOne);
            os = new FileOutputStream(fileTwo);
            os1 = new FileOutputStream(fileThree);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                if(getName().equals("первый")){
                    os.write(buffer, 0, length);
                }
                else if(getName().equals("второй")){
                    os1.write(buffer, 0, length);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
                os.close();
                os1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}