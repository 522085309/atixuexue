package my_game_interface.dataStruct.lineStruct.linkedlist;

/**
 * @author xj
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "逾期麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "关胜", "大刀");
        SingleLinkedList linkedList=new SingleLinkedList();
//        linkedList.add(heroNode2);
//        linkedList.add(heroNode1);
//        linkedList.add(heroNode4);
//        linkedList.add(heroNode3);
        linkedList.addOrderBy(heroNode2);
        linkedList.addOrderBy(heroNode1);
        linkedList.addOrderBy(heroNode4);
        linkedList.addOrderBy(heroNode3);
//        HeroNode heroNode=new HeroNode(1,"aa","bb");
//        linkedList.update(heroNode);
//        linkedList.delete(heroNode);
        reversetList(linkedList.getHead());
        linkedList.list();
    }
    /**
     * @Title:
     * @Description: 将单链表进行反转
     * @param:
     * @author xj
     * @date 2019/6/5 0005 17:01
     */
    public static void reversetList(HeroNode head){
        //如果只有头节点，或者只有一个节点，无需反转
        if(head.next==null || head.next.next==null){
            return;
        }
        //定义辅助变量，用来遍历链表
        HeroNode temp=head.next;
        HeroNode next=null;//指向当前节点[temp]的下一个节点
        HeroNode newHead=new HeroNode(0,"","");
        while (true){
            if(temp==null){
                break;
            }
            //先获取到当前节点的下一个节点的位置
            next=temp.next;
            //当前节点的指向 是新头节点的指向
            temp.next=newHead.next;
            //每获取到元素，便放到新头节点的最前端。即：新头节点永远指向最新获取的节点。
            /*
                t ->1 ->5 ->9           =>

                t ->5 ->9
                newt ->1 ->null         =>

                t ->9
                newt ->5 ->1            =>

                t ->null
                newt ->9 ->5 ->1        =>

                t-> newt.next
             */
            newHead.next=temp;
            temp=next;
        }
        head.next=newHead.next;
    }
}
/**
 * @Title:
 * @Description: 管理HeroNode
 *                  temp变量起到遍历节点的作用
 * @param:
 * @author xj
 * @date 2019/6/5 0005 11:53
 */
class  SingleLinkedList{
    //初始化一个头节点，头结点不要动
    private HeroNode head=new HeroNode(0,"","");
    //添加节点到单向链表

    public HeroNode getHead() {
        return head;
    }

    /**
     * 当前添加不考虑排序
     * 1、找到当前链表的最后一个节点
     * 2、将最后一个节点的next指向新节点
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        //创建一个辅助变量，便于查找
        HeroNode temp=head;
        while (true){
            //已经找到最后一个节点
            if(temp.next==null){
                break;
            }
            //没有找到最后一个节点，就将当前节点后移
            temp=temp.next;
        }
        temp.next=heroNode;
    }

    /**
     * @Title:
     * @Description: 根据no的序号排序插入链表
     * @param:
     * @author xj
     * @date 2019/6/5 0005 15:06
    */
    public void addOrderBy(HeroNode heroNode){
        HeroNode temp=head;
        boolean flag=true;
        while (true){
            //带插入的节点位置在最后
            if (temp.next==null){
                break;
            }
            //temp的下一个节点的no大于待插入的节点的no，说明temp和temp下一个节点之间就是待插入的节点位置
            if (temp.next.no>heroNode.no){
                break;
                //带插入的元素标号已存在
            }else if(temp.next.no==heroNode.no){
                flag=false;
                return;
            }
            temp=temp.next;
        }
        if(flag){
            heroNode.next=temp.next;
            temp.next=heroNode;
        }else {
            System.out.println("待插入的元素已存在");
        }
    }

    /**
     * @Title:
     * @Description: 根据no修改元素
     * @param:
     * @author xj
     * @date 2019/6/5 0005 15:18
    */
    public void update(HeroNode heroNode){
        HeroNode temp=head;
        if(temp.next==null){
            System.out.println("链表为空");
            return ;
        }
        boolean flag=false;
        while (true){
            if(temp.next==null){
                break;
            }
            if(temp.next.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //找到节点
        if(flag){
            temp.next.name=heroNode.name;
            temp.next.nickName=heroNode.nickName;
            //没有找到节点
        }else {
            System.out.println("没有找到此编号的节点,无法修改");
        }
    }
    /**
     * @Title:
     * @Description: 删除指定节点
     * @param:
     * @author xj
     * @date 2019/6/5 0005 15:47
    */
    public void delete(HeroNode heroNode){
        HeroNode temp=head;
        if(temp.next==null){
            System.out.println("链表为空");
            return;
        }
        boolean flag=false;
        while (true){
            //没有找到待删除的节点，退出循环
            if(temp.next==null){
                break;
            }
            //找到了待删除的数据 待删除的数据时temp的下一个节点
            if(temp.next.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.next=temp.next.next;
        }
    }
    /**
     *遍历链表
     */
    public void list(){
        HeroNode temp=head;
        if(temp.next==null){
            System.out.println("链表为空");
            return;
        }
        while (true){
            if(temp.next==null){
                break;
            }
            System.out.println(temp.next);
            //此次遍历完后，指针指向下一个节点，否则为死循环
            temp=temp.next;
        }
    }
}
/**
 * @Title:
 * @Description: 定义节点对象，每个对象就是一个节点
 * @param:
 * @author xj
 * @date 2019/6/5 0005 11:53
 */
class HeroNode{
    //编号
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode( int no,String name, String nickName) {
        this.name = name;
        this.no = no;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}