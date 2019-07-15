package my_game_interface.designmodel;

/**
 * 责任链模式
 */
public class ChainPattern {
    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "INFO");

        loggerChain.logMessage(AbstractLogger.DEBUG, "DEBUG");

        loggerChain.logMessage(AbstractLogger.ERROR, "ERROR");
    }
}

abstract class AbstractLogger {
    static int INFO = 1;
    static int DEBUG = 2;
    static int ERROR = 3;
    int level;
    AbstractLogger nextLogger;

    void logMessage(int level,String message){
        if (this.level < level){
            write(message);
        }
        if (nextLogger != null){
            nextLogger.logMessage(level,message);
        }
    }

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }
    abstract void write(String message);
}

class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }
    @Override
    protected void write(String message) {
        System.out.println("ConsoleLogger: " + message);
    }
}

class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("ErrorLogger: " + message);
    }
}

class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("FileLogger: " + message);
    }
}
