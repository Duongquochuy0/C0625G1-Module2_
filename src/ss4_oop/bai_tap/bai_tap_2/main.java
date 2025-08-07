package ss4_oop.bai_tap.bai_tap_2;

public class main {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.start();
        for (long i = 0; i < 1000000; i++) {
            long a = 1;
            a = i * i;
        }
        watch.stop();
        System.out.println(watch.getElapsedTime());
    }
}
