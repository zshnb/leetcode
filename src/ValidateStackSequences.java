import java.util.Stack;

/**
* 946 验证出栈序列是否合法
* 模拟原始入栈操作，每次入栈后检查栈顶元素和出栈队列头元素是否相等
 * 如果相等，移除栈顶和队列头元素，最后判断栈是否空，若空出栈序列合法，否则不合法
 * 存放出栈序列的队列可以优化为使用下标记录当前队列头元素
* */
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = new int[] {1, 0};
        int[] poped = new int[] {1, 0};
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        System.out.println(validateStackSequences.validateStackSequences(pushed, poped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0;i < pushed.length;i++) {
            stack.push(pushed[i]);
            while (index < popped.length && !stack.isEmpty() && popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
