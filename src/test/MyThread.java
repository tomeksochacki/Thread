package test;

class MyThread implements Runnable {
    Thread thrd;

    MyThread(String name) {
        thrd = new Thread(this, name);
    }

    public static MyThread createAndStart(String name){
        MyThread myThread = new MyThread(name);
        myThread.thrd.start();
        return myThread;
    }

    @Override
    public void run() {
        System.out.println(thrd.getName() + " rozpoczyna działanie.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println(thrd.getName() + " jest wykonywany, wartość licznika: " + count);
            }

        } catch (InterruptedException ex) {
            System.out.println(thrd.getName() + " został przerwany.");
        }
        System.out.println(thrd.getName() + " kończy działąnie.");
     }
}

class UserThreads{
    public static void main(String[] args) {
        System.out.println("Główny wątek rozpoczyna działanie.");
        MyThread myThread = MyThread.createAndStart("Wątek potomny nr 1");

        for (int i = 0; i<50; i++){
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex){
                System.out.println("Wątek główny został przerwany.");
            }
        }
        System.out.println("Wątek główny zakończył działanie.");
    }
}
