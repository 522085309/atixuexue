package my_game_interface.designmodel;

/**
 * 单例模式(饿汉方式)
 * 缺点：无法懒加载，启动的时候就初始化了对象。
 */
public class SingleModel {
    public static void main(String[] args) {
        User user = User.getUser();
    }
}
/**
 * 单例模式(饿汉方式)
 * 缺点：无法懒加载，启动的时候就初始化了对象。
 */
class User{
    private User(){};
    private static User user = new User();
    public static User getUser(){
        return user;
    }
}

/**
 * 单例模式(懒汉方式)
 * 缺点：当在多线程环境下，无法保证单例
 */
class Teacher{
    private Teacher(){};
    private Teacher teacher = null;
    public Teacher getTeacher(){
        if (teacher == null){
            return new Teacher();
        }
        return teacher;
    }
}
/**
 * 单例模式(懒汉方式)
 * 缺点：可以保证线程同步，但是加锁，会影响效率
 */
class Teacher1{
    private Teacher1(){};
    private volatile Teacher1 teacher = null;
    public synchronized Teacher1 getTeacher(){
        if (teacher == null){
            return new Teacher1();
        }
        return teacher;
    }
}
