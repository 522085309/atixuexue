package my_game_interface.dataStruct.lineStruct.stack;

public class ArraryStackDemo {
    public static void main(String[] args) {
        ArraryStack arraryStack=new ArraryStack(5);
        arraryStack.push(1);
        arraryStack.push(2);
        arraryStack.push(5);
        arraryStack.push(4);
        arraryStack.push(3);
        arraryStack.list();
    }
}

class ArraryStack{
    //栈的大小
    private int maxSize;
    //数组模拟栈
    private int[] stack;
    //栈顶
    private int top=-1;

    public ArraryStack(int maxSize) {
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
}
