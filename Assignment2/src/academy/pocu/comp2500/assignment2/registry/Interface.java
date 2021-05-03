package academy.pocu.comp2500.assignment2.registry;

/**
 * DO NOT MODIFY. YOU DON'T HAVE TO!
 */
public final class Interface {
    private String className;
    private String methodName;

    public Interface(final String className) {
        this(className, null);
    }

    public Interface(final String className, final String methodName) {
        this.className = className;
        this.methodName = methodName;
    }

    public String getClassName() {
        return this.className;
    }

    public String getMethodName() {
        return this.methodName;
    }

}
