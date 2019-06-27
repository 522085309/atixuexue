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
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.list();
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
        for (int i=1;i<num;i++){
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
            //如果当前节点的next指向了first，说明已经找到最后一个节点了
            if(cur.getNext()==first){
                break;
            }
            cur=cur.getNext();
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
