package todo;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author caoyixiong
 * @Date: 2018/10/18
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public class 最小栈_待定 {

    class MinStack {
        private Stack<Integer> data = new Stack<Integer>();
        private Stack<Integer> minValue = new Stack<Integer>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            data.push(x);
            if (minValue.isEmpty() || x <= minValue.peek()) {
                minValue.push(x);
            }
        }

        public void pop() {
            int value = data.pop();
            if (value == minValue.peek())
                minValue.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return minValue.peek();
        }
    }

    public static void main(String[] args) {
        int[] data = new int[20];
        System.out.print(data[0]);
    }
}
