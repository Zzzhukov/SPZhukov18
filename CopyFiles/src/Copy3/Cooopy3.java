package Copy3;

public class Cooopy3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ParallelCopy copyOne = (new ParallelCopy("первый", 5));
        ParallelCopy copyTwo = (new ParallelCopy("второй", 5)) ;
        copyOne.start();
        copyTwo.start();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
