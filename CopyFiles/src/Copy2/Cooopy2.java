package Copy2;

import java.io.*;

public class Cooopy2 {
    public static void main(String[] args) throws IOException {
        File fileOne = new File("copy1.txt");
        File fileTwo = new File("copy2.txt");
        File fileThree = new File("copy3.txt");
        File fileFour = new File("copy4.txt");
        copyFileUsingStream(fileOne, fileTwo ,fileThree, fileFour);
    }
    private static void copyFileUsingStream(File fileOne, File fileTwo, File fileThree, File fileFour) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        long start = System.currentTimeMillis();
        try {
            is = new FileInputStream(fileOne);
            os = new FileOutputStream(fileTwo);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
        finally {
            is.close();
            os.close();
        }
        InputStream is1 = null;
        OutputStream os1 = null;
        try {
            is1 = new FileInputStream(fileThree);
            os1 = new FileOutputStream(fileFour);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is1.read(buffer)) > 0) {
                os1.write(buffer, 0, length);
            }
        }
        finally {
            is1.close();
            os1.close();
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }

}
