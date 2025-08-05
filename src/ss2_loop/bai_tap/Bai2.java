package ss2_loop.bai_tap;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần in ra (n<20): ");
        int number = sc.nextInt();
        int n = 2;
        int check =0;
        while(check<number){
            int count =0;
            for (int i = 2; i < n ; i++) {
                if(n%i==0){
                    count ++;
                    break;
                }
        }
        if (count==0){
            System.out.println(n);
            check++;
        }
            n++;
        }

    }
}
