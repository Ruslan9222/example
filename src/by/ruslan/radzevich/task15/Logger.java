package by.ruslan.radzevich.task15;

public interface Logger {
    void log(String logMessage);
}

class StdOutLogger implements Logger {

    @Override
    public void log(String logMessage) {
        System.out.println("logMessage = " + logMessage);

    }
}

class A {
    private final Logger logger;

    A(Logger logger) {
        this.logger = logger;
    }

    public void doSomeWork() {
        this.logger.log("Message 1");
    }
}

class B {
    private final Logger logger;

    B(Logger logger) {
        this.logger = logger;
    }

    public void doSomeWork() {
        this.logger.log("Message 2");
    }
}


class C {
    private final Logger logger;

    C(Logger logger) {
        this.logger = logger;
    }

    public void doSomeWork() {
        this.logger.log("Message 3");
    }
}

class Main {
    public static void main(String[] args) {
        final var stdOutLogger = new StdOutLogger();

        final var a = new A(stdOutLogger);
        final var b = new B(stdOutLogger);
        final var c = new C(stdOutLogger);

        a.doSomeWork();

    }
}

