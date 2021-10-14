package Chicken;

public class Discussion extends Thread {
    String name;
    int priority;
    public Discussion(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        Thread.currentThread().setName(name);
        int Sleep = 500;
        for (int i = 1; i < 20; i++) {
            if(getName().equals("Chicken")){
                try {
                    Thread.sleep(Sleep);
                    System.out.println(getName());
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    Thread.sleep(Sleep);
                    System.out.println(getName());
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
