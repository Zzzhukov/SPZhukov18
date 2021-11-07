package converters;
import java.util.Scanner;
import org.apache.log4j.Logger;
public class convert {
    private static final Logger log = Logger.getLogger(String.valueOf(convert.class));
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Для перевода из рублей в доллары введите \n Р-Д," +
                "\nДля перевода из долларов в рубли, введите\n Д-Р");

        String str = in.nextLine();
        float course = 70.06f;

        if (str.equals("Р-Д")) {
            try {
                System.out.println("Введите рубли");
                float number = in.nextFloat();
                System.out.println(number / course + " долларов");
                log.info("dollar");
            } catch (Exception ex) {
                System.out.println("Вы ввели неправильные данные");
                log.info("error");
            }
        } else if (str.equals("Д-Р")) {
            try {
                System.out.println("Введите доллары");
                float number = in.nextFloat();
                System.out.println(course / number + " рублей");
                log.info("ruble");
            } catch (Exception ex) {
                System.out.println("Вы ввели неправильные данные");
                log.info("error");
            }

        }
        else{
            System.out.println("Вы ввели неправильные данные");
            log.info("error");
        }
    }
}