/**
 *
 * @author Saad
 */

class Table{
    // Non-synchronized. Synchronized -> synchronized void prinTable(int n) { ... }
    void prinTable(int n) {
        for (int i = 1; i <= 5; i++) {
            try{
                Thread.sleep(500);
            } catch(InterruptedException e){
                System.out.println(e);
            }
            System.out.println(n*i);
        }
    }
}

class MyThread1 extends Thread{
    Table t;
    MyThread(Table t) {
        this.t = t;
    }

    public void run(){
        t.printTable(5);
    }
}

class MyThread2 extends Thread{
    Table t;
    MyThread(Table t) {
        this.t = t;
    }

    public void run(){
        t.printTable(100);
    }
}

public class NewClass {
    public static void main(String[] args) {
		Table obj = new Table();
        MyThread1 m1 = new MyThread1(obj);
        MyThread2 m2 = new MyThread2(obj);

        m1.start();
        m2.start();
    }
}
