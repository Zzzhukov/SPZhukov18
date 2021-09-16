import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ymnozhenie_split {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение с умножением");
        String Line = in.nextLine();
        String A_1 = "";
        String B_1 = "";
        int i = 0;
        Matcher matcher = Pattern.compile("(\\d+)").matcher(Line);
        while(matcher.find()){
            if(i ==0){
                A_1 = matcher.group();
                i++;
            }
            B_1 = matcher.group();
        }
        int a = Integer.parseInt(A_1);
        int b = Integer.parseInt(B_1);
        System.out.println(product(a, b));
    }
    static int product(int a, int b) {
        if( a ==0 || b == 0)
        {
            return 0;
        }
        if (b==1)
        {
            return a;
        }
        else
        {
            return a + product(a, b - 1);
        }
    }
}
