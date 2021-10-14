package Chicken;

public class Dispute {
    public static void main(String[] args) {
        Discussion chicken = (new Discussion("Chicken", 5));
        Discussion egg = (new Discussion("Egg", 5));
        chicken.start();
        egg.start();
        String win = "";
        while (true){
            if (egg.isAlive() && !chicken.isAlive()){
                win = "Egg win!!!";
                break;
            }
            else if(!egg.isAlive() && chicken.isAlive()){
                win = "Chicken win!!!";
                break;
            }
        }

        try {
            chicken.join();
            egg.join();
            System.out.println(win);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
