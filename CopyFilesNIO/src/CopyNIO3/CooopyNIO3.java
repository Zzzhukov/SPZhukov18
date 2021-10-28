package CopyNIO3;

public class CooopyNIO3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ParallelCopyNIO copyOne = (new ParallelCopyNIO("первый", 5));
        ParallelCopyNIO copyTwo = (new ParallelCopyNIO("второй", 5)) ;
        copyOne.start();
        copyTwo.start();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}