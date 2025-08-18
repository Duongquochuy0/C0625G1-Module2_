package ss10_stack_queue.bai_tap.bai_1;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "DuongQuocHuy";
        System.out.println("Chuỗi ban đầu: " + str);
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }
        System.out.println("Chuỗi sau khi đảo ngược: " + reversed.toString());
    }


}
