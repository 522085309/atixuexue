package my_game_interface.dataStruct.lineStruct.linkedlist;


/**
 * @Title: 约瑟夫问题
 * @Description: 单向循环链表
 * @param:
 * @author xj
 * @date 2019/6/10 0010 18:56
*/
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        circleSingleLinkedList.add(25);
        circleSingleLinkedList.countBoy(3,5,25);
//        circleSingleLinkedList.list();
    }

}

/**
 * 创建一个环形单向链表
 */
class CircleSingleLinkedList{
    //创建一个辅助指针，指向第一个节点
    Boy first=null;

    /**
     * 添加数据
     * @param num
     */
    public void add(int num){
        if(num<1){
            System.out.println("添加的节点数不能小于1");
            return;
        }
        Boy cur=first;
        for (int i=1;i<=num;i++){
            Boy boy=new Boy(i);
            //创建一个辅助指针，指向当前的节点
            if(i==1){
                first=boy;
                //构成环形链表
                first.setNext(first);
                //当前节点就是第一个节点
                cur=first;
            }else{
                //当前节点的next指向新创建的节点
                cur.setNext(boy);
                //新创建的节点指向第一个节点，构成环形链表
                boy.setNext(first);
                //让当前节点指向新创建的节点
                cur=boy;
            }
        }
    }
    /**
     * 遍历数据
     */
    public void list(){
        if(first==null){
            System.out.println("链表为空");
            return;
        }
        Boy cur=first;
        while (true){
            System.out.println("编号为："+cur.getNo());
            //如果当前节点的next指向了first，说明已经找到最后一个节点了
            if(cur.getNext()==first){
                break;
            }
            cur=cur.getNext();
        }
    }

    /**
     *统计小孩出圈的序号
     * @param startNo 从哪个小孩开始报数
     * @param count 每次数count次时，小孩出圈
     * @param num 一共多少小孩
     *
     *     first指针指向出圈节点
     *     helper指针指向出圈节点的后一个节点
     */
    public void countBoy(int startNo,int count,int num){
        if(first == null || startNo < 1 || count > num){
            System.out.println("参数有误");
            return;
        }
        //创建一个辅助指针，开始时，指向最后一个节点
        Boy helper=first;
        while (true){
            //helper指针指向first，说明已经是指向最后一个节点了
            if(helper.getNext()==first){
                break;
            }
            //指针往后移动
            helper=helper.getNext();
        }
        //当循环退出时，heleper指针已经指向最后一个节点了

        //将first指针和helper指针指向开始报数的小孩位置 =>startNo
        for (int i=0;i<startNo-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }
        while (true){
            //说明只剩一个节点了
            if (helper==first){
                System.out.println("最后一个小孩的编号为："+helper.getNo());
                break;
            }
            //每次数count次时，小孩出圈。
            for (int i=0;i<count-1;i++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println("出圈小孩的标号："+first.getNo());
            //出圈后，修改指针位置，重新构成循环链表
            //first指向出圈小孩节点的下一个节点
            first=first.getNext();
            //heleper指针位置不变，但是指向的节点为first节点
            helper.setNext(first);
        }
    }
}

/**
 * 创建一个Boy对象，表示一个节点
 */
class Boy{
    private int no ;
    private Boy next;
    public Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
