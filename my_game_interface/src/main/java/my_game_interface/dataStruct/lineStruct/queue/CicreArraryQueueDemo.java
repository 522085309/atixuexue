package my_game_interface.dataStruct.lineStruct.queue;

import java.util.Scanner;

/*
 * @Title: 
 * @Description: 数组实现循环队列
 * @param: 
 * @author xj
 * @date 2019/6/5 0005
*/
public class CicreArraryQueueDemo {
    public static void main(String[] args) {
        //创建大小为4的空间，实际只能存储3个元素。空出一位做为约定。
        //在循环队列中，当队列为空时，有front=rear，而当所有队列空间全占满时，也有front=rear。为了区别这两种情况，规定循环队列最多只能有MaxSize-1个队列元素，当循环队列中只剩下一个空存储单元时，队列就已经满了
        CicreArraryQueue arraryQueue=new CicreArraryQueue(4);
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
                    int i = arraryQueue.deleteQueue();
                    System.out.println(i);
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

/*
 * @Title:
 * @Description:
 * 1、fron指针从0开始，指向头元素：即第一个元素的下标。
 * 2、rear指针指向队尾的后一个位置。
 * @param:
 * @author xj
 * @date 2019/6/5 0005 09:42
*/
class CicreArraryQueue{
    private int maxSize;
    private int front=0;
    private int rear=0;
    private int[] arr;

    public CicreArraryQueue(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        if(front==rear){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 判断是否为满
     */
    public boolean isFull(){
        if((rear+1)%maxSize==front){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 添加元素
     */
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }
    /**
     * 去除头元素，出队
     */
    public int deleteQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw  new RuntimeException("队列为空");
        }
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }
    /**
     * 得到头元素，不出队
     */
    public int getQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw  new RuntimeException("队列为空");
        }
        return arr[front];
    }
    /**
     * 遍历队列数据
     */
    public void getArraryQueue(){
        for(int i=front;i<(front+size());i++){
            System.out.println(arr[i]);
        }
    }
    /**
     * 获得队列有效数据个数
     */
    public int size(){
        return (rear-front+maxSize)%maxSize;
    }
}
