package my_game_interface.dataStruct.lineStruct.queue;

import java.util.Scanner;

public class ArraryQueueDemo {
    public static void main(String[] args) {
        ArraryQueue arraryQueue=new ArraryQueue(3);
        char key=' ';
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("请输入(0)判断是否为空：");
            System.out.println("请输入(1)判断是否为满：");
            System.out.println("请输入(a)添加一个数：");
            System.out.println("请输入(g)取得当前头元素：");
            System.out.println("请输入(d)删除当前头元素：");
            System.out.println("请输入(l)取得当前队列：");
            key=scanner.next().charAt(0);
            switch (key){
                case '0':
                    if(arraryQueue.isEmpty()){
                        System.out.println("队列为空");
                    }else {
                        System.out.println("队列不为空");
                    }
                    break;
                case '1':
                    if(arraryQueue.isFull()){
                        System.out.println("队列已满");
                    }else {
                        System.out.println("队列未满");
                    }
                    break;
                case 'a':
                    if(arraryQueue.isFull()){
                        System.out.println("队列已满，无法添加");
                        break;
                    }
                    int value=scanner.nextInt();
                    arraryQueue.addQueue(value);
                    break;
                case 'g':
                    if(arraryQueue.isEmpty()){
                        System.out.println("队列为空");
                        break;
                    }
                    int res=arraryQueue.getQueue();
                    System.out.println("取出的头元素为"+res);
                    break;
                case 'd':
                    if(arraryQueue.isEmpty()){
                        System.out.println("队列为空");
                        break;
                    }
                    arraryQueue.deleteQueue();
                    break;
                case 'l':
                    if(arraryQueue.isEmpty()){
                        System.out.println("队列为空");
                        break;
                    }
                    arraryQueue.getArraryQueue();
                    break;
                default:
                    break;
            }
        }
    }

}
class ArraryQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int []arr;

    public ArraryQueue(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
        front=-1;
        rear=-1;
    }

    //判断队列是否为满
    public boolean isFull(){
        if(rear==maxSize-1){
            return true;
        }else{
            return false;
        }
    }
    //判断队列是否为空
    public boolean isEmpty(){
        if(front==rear){
            return true;
        }else {
            return false;
        }
    }

    //添加一个元素
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，无法添加数据");
            return ;
        }
        rear++;
        arr[rear]=n;
    }
    //取得头元素，出队
    public int deleteQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有元素");
            throw  new RuntimeException("队列为空，没有元素");
        }
        front++;
        return arr[front];
    }

    //得到头元素，不出队
    public int getQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有元素");
            throw  new RuntimeException("队列为空，没有元素");
        }
        return arr[front+1];
    }
    public void getArraryQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有元素");
            throw  new RuntimeException("队列为空，没有元素");
        }
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
