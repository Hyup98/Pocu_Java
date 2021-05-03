package academy.pocu.comp2500.assignment3.registry;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * DO NOT MODIFY. YOU DON'T HAVE TO!
 */
public class Registry {
    public static String ASSIGNMENT3_PACKAGE_NAME = "academy.pocu.comp2500.assignment3";
    protected static final int TOTAL_INTERFACES_COUNT = 7;

    protected HashMap<academy.pocu.comp2500.assignment3.registry.InterfaceKey, academy.pocu.comp2500.assignment3.registry.Interface> interfaces = new HashMap<>();

    public final HashMap<academy.pocu.comp2500.assignment3.registry.InterfaceKey, academy.pocu.comp2500.assignment3.registry.Interface> getInterfaces() {
        return this.interfaces;
    }

    public final void registerMarineCreator(final String className) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.MARINE, new academy.pocu.comp2500.assignment3.registry.Interface(className));
    }

    public final void registerMarineCreator(final String className, final String methodName) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.MARINE, new academy.pocu.comp2500.assignment3.registry.Interface(className, methodName));
    }

    public final void registerTankCreator(final String className) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.TANK, new academy.pocu.comp2500.assignment3.registry.Interface(className));
    }

    public final void registerTankCreator(final String className, final String methodName) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.TANK, new academy.pocu.comp2500.assignment3.registry.Interface(className, methodName));
    }

    public final void registerWraithCreator(final String className) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.WRAITH, new academy.pocu.comp2500.assignment3.registry.Interface(className));
    }

    public final void registerWraithCreator(final String className, final String methodName) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.WRAITH, new academy.pocu.comp2500.assignment3.registry.Interface(className, methodName));
    }

    public final void registerTurretCreator(final String className) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.TURRET, new academy.pocu.comp2500.assignment3.registry.Interface(className));
    }

    public final void registerTurretCreator(final String className, final String methodName) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.TURRET, new academy.pocu.comp2500.assignment3.registry.Interface(className, methodName));
    }

    public final void registerMineCreator(final String className) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.MINE, new academy.pocu.comp2500.assignment3.registry.Interface(className));
    }

    public final void registerMineCreator(final String className, final String methodName) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.MINE, new academy.pocu.comp2500.assignment3.registry.Interface(className, methodName));
    }

    public final void registerSmartMineCreator(final String className) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.SMART_MINE, new academy.pocu.comp2500.assignment3.registry.Interface(className));
    }

    public final void registerSmartMineCreator(final String className, final String methodName) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.SMART_MINE, new academy.pocu.comp2500.assignment3.registry.Interface(className, methodName));
    }

    public final void registerDestroyerCreator(final String className) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.DESTROYER, new academy.pocu.comp2500.assignment3.registry.Interface(className));
    }

    public final void registerDestroyerCreator(final String className, final String methodName) {
        this.interfaces.put(academy.pocu.comp2500.assignment3.registry.InterfaceKey.DESTROYER, new academy.pocu.comp2500.assignment3.registry.Interface(className, methodName));
    }

    public void validate() {
        assertTrue(this.interfaces.size() >= TOTAL_INTERFACES_COUNT,
                "%d unregistered method(s)",
                TOTAL_INTERFACES_COUNT - this.interfaces.size());

        HashSet<String> visited = new HashSet<>();
        for (Map.Entry<academy.pocu.comp2500.assignment3.registry.InterfaceKey, academy.pocu.comp2500.assignment3.registry.Interface> entry : this.interfaces.entrySet()) {
            academy.pocu.comp2500.assignment3.registry.Interface aInterface = entry.getValue();
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
            String fullClassName = String.format("%s.%s", ASSIGNMENT3_PACKAGE_NAME, name);
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
