package 美团;

public class _1114_按序打印 {

    private int status = 0;

    public _1114_按序打印() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (status == 1 || status == 2) {

        }
        status = 1;
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (status == 0 || status == 2) {

        }
        status = 2;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (status == 0 || status == 1) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
