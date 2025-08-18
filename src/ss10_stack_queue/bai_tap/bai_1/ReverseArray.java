package ss10_stack_queue.bai_tap.bai_1;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println("Mảng ban đầu là:"+ Arrays.toString(arr));
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            stack.push(num);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println("Mảng đã đảo ngược là:"+Arrays.toString(arr));
    }
}
