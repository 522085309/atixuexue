package my_game_interface.dataStruct.lineStruct.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "逾期麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "关胜", "大刀");
        DoubleLinkedList linkedList=new DoubleLinkedList();
        linkedList.add(heroNode1);
        linkedList.add(heroNode2);
        linkedList.add(heroNode3);
        linkedList.add(heroNode4);
        HeroNode2 heroNode5 = new HeroNode2(3, "aa", "aa");
        linkedList.update(heroNode5);
        linkedList.delete(heroNode4);
        linkedList.list();
    }
}

class DoubleLinkedList{
    HeroNode2 head=new HeroNode2(0,"","");
    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 增加节点
     * @param heroNode
     */
    public void add(HeroNode2 heroNode){
        //创建一个辅助变量，便于查找
        HeroNode2 temp=head;
        while (true){
            //已经找到最后一个节点
            if(temp.next==null){
                break;
            }
            //没有找到最后一个节点，就将当前节点后移
            temp=temp.next;
        }
        //构成双向链表
        temp.next=heroNode;
        heroNode.pre=temp;
    }

    /**
     * 修改节点和单链表思路一样
     * @param heroNode
     */
    public void update(HeroNode2 heroNode){
        HeroNode2 temp=head;
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
     * 删除节点
     * @param heroNode
     */
    public void delete(HeroNode2 heroNode){
        //添加辅助变量，指向头节点的下一个节点
        HeroNode2 temp=head.next;
        if(temp.next==null){
            System.out.println("链表为空");
            return;
        }
        boolean flag=false;
        while (true){
            //没有找到待删除的节点，退出循环
            if(temp==null){
                break;
            }
            //找到了待删除的数据,temp是待删除的元素
            if(temp.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            //待删除节点的前一个节点的next 指向待删除节点的下一个节点
            //如果待删除节点为空，则待删除节点的前一个节点的next指向Null
            temp.pre.next = temp.next;
            //如果待删除节点的前一个节点的next指向N不为ull，即不是待删除的节点不是最后一个节点
            if(temp.next!=null) {
                //但删除节点的下一个节点的per指向待删除节点的pre
                temp.next.pre = temp.pre;
            }
        }
    }
    /**
     *遍历链表
     */
    public void list(){
        HeroNode2 temp=head;
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

class HeroNode2 {
    //编号
    public int no;
    public String name;
    public String nickName;
    //指向前一个节点
    public HeroNode2 pre;
    //指向下一个节点
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
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