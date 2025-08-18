package ss10_stack_queue.bai_tap.optional_bai_1;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số thập phân: ");
        int number = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            int remainder = number % 2;
            stack.push(remainder);
            number = number / 2;
        }
        System.out.print("Số nhị phân: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
