package my_game_interface.designmodel;

/**
 * 责任链模式
 */
public class ChainPattern {

    public static void main(String[] args) {
        GroupLeader groupLeader = new GroupLeader();
        Director director = new Director();
        Manager manager = new Manager();
        groupLeader.setNextLeader(director);
        director.setNextLeader(manager);
        groupLeader.handleRequest(500);
    }
}

abstract class Leader{
    //  上级领导
    private Leader nextLeader;

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    //  报账处理类
    public final void handleRequest(int money){
        if (money < limit()){
            handle(money);
        }else {
            if (null != nextLeader){
                nextLeader.handleRequest(money);
            }
        }
    }
    abstract int limit();
    abstract void handle(int money);
}
class GroupLeader extends Leader{

    @Override
    int limit() {
        return 1000;
    }

    @Override
    void handle(int money) {
        System.out.println("组长批复报销："+money+"元");
    }
}

class Director extends Leader{

    @Override
    int limit() {
        return 5000;
    }

    @Override
    void handle(int money) {
        System.out.println("主管批复报销："+money+"元");
    }
}

class Manager extends Leader{

    @Override
    int limit() {
        return 10000;
    }

    @Override
    void handle(int money) {
        System.out.println("经理批复报销："+money+"元");
    }
}

