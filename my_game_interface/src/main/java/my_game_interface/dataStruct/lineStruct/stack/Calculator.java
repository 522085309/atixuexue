package my_game_interface.dataStruct.lineStruct.stack;

public class Calculator {
    public static int calculatorResult(String s) {
//        String s="31+2*61-2";
        //创建两个栈，一个数字栈，一个符号栈
        ArraryStack2 numStack=new ArraryStack2(10);
        ArraryStack2 operStack=new ArraryStack2(10);
        //定义需要的相关变量
        int index=0;
        int oper=0;
        int num1=0;
        int num2=0;
        int res=0;
        char ch=' ';//存放每次扫描到的字符
        String keepNum = "";//用于拼接多位数
        while (true){
            ch=s.substring(index,index+1).charAt(0);
            //  如果是操作符
            if(operStack.isOper(ch)) {
                //  如果操作符栈不为空
                if (!operStack.isEmpty()) {
                    //  如果此操作符小于栈中的操作符
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        //  将栈中的操作符和数字先进行计算后，将结果放回数字栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        //  将当前的操作符直接入栈
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            }else {
                //  因为字符和int的asci码相差48
//                numStack.push(ch-48);
                //  如果是数，不能立即入栈
                keepNum += ch;
                //  如果已经是最后一位了，就直接入栈
                if (index == s.length()-1){
                    numStack.push(Integer.valueOf(keepNum));
                }else {
                    //  再往后看一个数，如果是数，则拼接，如果是操作符，则入栈
                    //  如果满足调节，说明后一位是运算符
                    if (operStack.isOper(s.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.valueOf(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if(index>=s.length()){
                break;
            }
        }
        while (true){
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        return  res;
//        System.out.println("表达式："+s+" = "+res);
    }
}
class ArraryStack2{
    //栈的大小
    private int maxSize;
    //数组模拟栈
    private int[] stack;
    //栈顶
    private int top=-1;

    public ArraryStack2(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[this.maxSize];
    }

    public boolean isFull(){
        if(top==maxSize-1){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }

    public int peek(){
        return stack[top];
    }
    /**
     * 入栈 先将栈顶top++，然后赋值
     * @param value
     */
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }

    /**
     * 出栈 先出栈，在top--
     * @return
     */
    public int pop(){
        if (isEmpty()){
            System.out.println("栈空");
            throw new RuntimeException("栈空");
        }
        int value=stack[top];
        top--;
        return value;
    }

    /**
     * 遍历时，需要从栈顶遍历数据
     */
    public void list(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i=top;i>=0;i--){
            System.out.println(stack[i]);
        }
    }
    /**
     * 返回运算符的优先级,优先级使用数字表示
     * 数字越大，优先级就越高
     */
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }
        else if(oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 判断是不是一个操作符
     * @param val
     * @return
     */
    public boolean isOper(char val){
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    /**
     * 计算方法
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1,int num2 ,int oper){
        int res=0;
        switch (oper){
            case '+':
                res=num2 + num1;
                break;
            case '-':
                res=num2 - num1;
                break;
            case '*':
                res=num2 * num1;
                break;
            case '/':
                res=num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}

