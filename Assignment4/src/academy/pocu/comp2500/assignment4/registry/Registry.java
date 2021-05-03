package academy.pocu.comp2500.assignment4.registry;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * DO NOT MODIFY. YOU DON'T HAVE TO!
 */
public class Registry {
    public static String ASSIGNMENT4_PACKAGE_NAME = "academy.pocu.comp2500.assignment4";
    protected static final int TOTAL_INTERFACES_COUNT = 8;

    protected HashMap<InterfaceKey, Interface> interfaces = new HashMap<>();

    public final HashMap<InterfaceKey, Interface> getInterfaces() {
        return this.interfaces;
    }

    public final void registerDrawPixelCommandCreator(final String className) {
        this.interfaces.put(InterfaceKey.DRAW_PIXEL_COMMAND, new Interface(className));
    }

    public final void registerDrawPixelCommandCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.DRAW_PIXEL_COMMAND, new Interface(className, methodName));
    }

    public final void registerIncreasePixelCommandCreator(final String className) {
        this.interfaces.put(InterfaceKey.INCREASE_PIXEL_COMMAND, new Interface(className));
    }

    public final void registerIncreasePixelCommandCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.INCREASE_PIXEL_COMMAND, new Interface(className, methodName));
    }

    public final void registerDecreasePixelCommandCreator(final String className) {
        this.interfaces.put(InterfaceKey.DECREASE_PIXEL_COMMAND, new Interface(className));
    }

    public final void registerDecreasePixelCommandCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.DECREASE_PIXEL_COMMAND, new Interface(className, methodName));
    }

    public final void registerToUppercaseCommandCreator(final String className) {
        this.interfaces.put(InterfaceKey.TO_UPPER_CASE_COMMAND, new Interface(className));
    }

    public final void registerToUppercaseCommandCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.TO_UPPER_CASE_COMMAND, new Interface(className, methodName));
    }

    public final void registerToLowercaseCommandCreator(final String className) {
        this.interfaces.put(InterfaceKey.TO_LOWER_CASE_COMMAND, new Interface(className));
    }

    public final void registerToLowercaseCommandCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.TO_LOWER_CASE_COMMAND, new Interface(className, methodName));
    }

    public final void registerFillHorizontalLineCommandCreator(final String className) {
        this.interfaces.put(InterfaceKey.FILL_HORIZONTAL_LINE_COMMAND, new Interface(className));
    }

    public final void registerFillHorizontalLineCommandCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.FILL_HORIZONTAL_LINE_COMMAND, new Interface(className, methodName));
    }

    public final void registerFillVerticalLineCommandCreator(final String className) {
        this.interfaces.put(InterfaceKey.FILL_VERTICAL_LINE_COMMAND, new Interface(className));
    }

    public final void registerFillVerticalLineCommandCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.FILL_VERTICAL_LINE_COMMAND, new Interface(className, methodName));
    }

    public final void registerClearCommandCreator(final String className) {
        this.interfaces.put(InterfaceKey.CLEAR_COMMAND, new Interface(className));
    }

    public final void registerClearCommandCreator(final String className, final String methodName) {
        this.interfaces.put(InterfaceKey.CLEAR_COMMAND, new Interface(className, methodName));
    }

    public void validate() {
        assertTrue(this.interfaces.size() >= TOTAL_INTERFACES_COUNT,
                "%d unregistered method(s)",
                TOTAL_INTERFACES_COUNT - this.interfaces.size());

        HashSet<String> visited = new HashSet<>();
        for (Map.Entry<InterfaceKey, Interface> entry : this.interfaces.entrySet()) {
            Interface aInterface = entry.getValue();
            String className = aInterface.getClassName();

            Class<?> aClass = getClassByNameOrNull(className);

            assertTrue(aClass != null, "not found: %s", className);

            String methodName = aInterface.getMethodName();

            if (methodName != null) {
                ArrayList<Method> methods = getMethodsByName(aClass, methodName);

                assertTrue(methods.size() > 0, "not found: %s.%s()", className, methodName);
            }
        }
    }

    protected void assertTrue(boolean condition, String format, Object... args) {
        assert condition : String.format(format, args);
    }

    private final Class<?> getClassByNameOrNull(final String name) {
        try {
            String fullClassName = String.format("%s.%s", ASSIGNMENT4_PACKAGE_NAME, name);
            return Class.forName(fullClassName);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private final ArrayList<Method> getMethodsByName(final Class<?> aClass, final String methodName) {
        Method[] declaredMethods = aClass.getDeclaredMethods();
        ArrayList<Method> methods = new ArrayList<>();

        for (int i = 0; i < declaredMethods.length; ++i) {
            if (declaredMethods[i].getName().equals(methodName)) {
                methods.add(declaredMethods[i]);
            }
        }

        return methods;
    }
}
