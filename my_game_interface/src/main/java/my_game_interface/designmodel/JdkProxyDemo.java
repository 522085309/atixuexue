package my_game_interface.designmodel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyDemo {
    public static void main(String[] args) {
        //  创健被代理的对象
        UserService userService = new UserServiceImpl();
        //  获取类加载器
        ClassLoader classLoader = userService.getClass().getClassLoader();
        // 4. 创建一个将传给代理类的调用请求处理器，处理所有的代理对象上的方法调用
        //     这里创建的是一个自定义的日志处理器，须传入实际的执行对象 userServiceImpl
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        LogHandler logHandler = new LogHandler(userService);
//        5.根据上面提供的信息，创建代理对象 在这个过程中，
//        a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
//        b.然后根据相应的字节码转换成对应的class，
//        c.然后调用newInstance()创建代理实例
        UserService proxy = (UserService)Proxy.newProxyInstance(classLoader, interfaces, logHandler);
        proxy.select();
        proxy.update();
    }
}

interface UserService{
    public void select();
    public void update();
}

class UserServiceImpl implements UserService{

    @Override
    public void select() {
        System.out.println("执行select");
    }

    @Override
    public void update() {
        System.out.println("执行update");
    }
}

class LogHandler implements InvocationHandler{
    private Object object;

    public LogHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志记录前");
        Object invoke = method.invoke(object, args);
        System.out.println("日志记录后");
        return invoke;
    }
}
