package Threds;

public class MultiThreading03 {

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        //thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 7; i++) {
                    brackets.generateBracket();
                }
            }        });
        thread1.start();
        //thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 7; i++) {
                    brackets.generateBracket();
                }
            }        });
        thread2.start();
    }  }
class Brackets {
    public synchronized void generateBracket() {
        for (int i = 0; i <= 10; i++) {
            if (i <= 5) System.out.print("[");
            else System.out.print("]");
        }
        System.out.println("");
    }
}

