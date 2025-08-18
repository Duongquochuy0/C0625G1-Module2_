package ss10_stack_queue.bai_tap.optional_bai_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(String input) {
        if (input.length() <= 1) return true;
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            char lower = Character.toLowerCase(c);
            queue.add(lower);
            stack.push(lower);
        }
        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String str = sc.nextLine();
        boolean result = isPalindrome(str);
        System.out.println(result ? "Đây là chuỗi Palindrome" : "Đây không phải Palindrome");
    }
}
