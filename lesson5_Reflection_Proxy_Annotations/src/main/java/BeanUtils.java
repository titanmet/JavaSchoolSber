import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        Method[] methodsTo = to.getClass().getMethods();
        Method[] methodsFrom = from.getClass().getMethods();
        for (Method methodTo : methodsTo) {
            if (isSetter(methodTo)) {
                for (int i = 0; i < methodsFrom.length; i++) {
                    Method methodFrom = methodsFrom[i];
                    if (methodFrom == null) continue;
                    if (isGetter(methodFrom)) {
                        Object getterType = methodFrom.getReturnType();
                        Object setterType = methodTo.getParameterTypes()[0];
                        if (isTypeOf(getterType, setterType)) {
                            try {
                                methodTo.invoke(to, methodFrom.invoke(from));
                                methodsFrom[i] = null;
                                break;
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

    }

    private static boolean isTypeOf(Object clazz, Object superClass) {
        if (superClass.equals(Object.class)) {
            return true;
        }
        if (clazz.equals(superClass)) {
            return true;
        } else {
            clazz = clazz.getClass().getSuperclass();
            if (clazz.equals(Object.class)) {
                return false;
            }
            return isTypeOf(clazz, superClass);
        }
    }

    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        return !void.class.equals(method.getReturnType());
    }

    private static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        return method.getParameterTypes().length == 1;
    }
}


