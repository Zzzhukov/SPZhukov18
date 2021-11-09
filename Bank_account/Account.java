package Bank_account;
import java.util.Scanner;
import java.util.Random;

public class Account extends Thread {
    int balance;

    public Account(int balance) {
        this.balance = balance;
    }
    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        balance += random.nextInt(1_000_000);
        System.out.println("\nВаш баланс: " + balance + " рублей");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int money;
        byte check2 = 0;
        while (true) {
            if(check2 % 2 == 0){
                System.out.println("\nДля пополнения баланса введите: Пополнить счёт" + "\nДля снятия введите: Снять средства");
                check2++;
            }
            else{
                check2++;
            }

            String ifElse = in.nextLine();
            if (ifElse.equals("Пополнить счёт")) {
                System.out.println("Введите сумму для пополнения");
                money = in.nextInt();
                if (money < 1){
                    System.out.println("Минимальная сумма пополнения 1 рубль" + "\n");
                    continue;
                }
                upAccount(money);

            }
            else if (ifElse.equals("Снять средства")) {
                System.out.println("Введите сумму для снятия");
                money = in.nextInt();
                if(money > balance){
                    System.out.println("У Вас недостаточно средств" + "\n");
                    continue;
                }
                if (money < 1){
                    System.out.println("Минимальная сумма снятия 1 рубль" + "\n");
                    continue;
                }
                withdrawMoney(money);
            }
        }
    }
    public void withdrawMoney(int money){
        balance -= money;
        System.out.println("Со счета снято " + money + " рублей" + "\nВаш баланс: " + balance + " рублей");
    }
    public void upAccount(int money){
        balance += money;
        System.out.println("На счет зачислено " + money + " рублей" + "\nВаш баланс: " + balance + " рублей");
    }
}
