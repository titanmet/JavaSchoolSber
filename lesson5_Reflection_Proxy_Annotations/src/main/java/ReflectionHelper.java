import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelper {
    public static void allMethods(Object object) {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        Class<?> superClass = clazz.getSuperclass();
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method);
        }
        if (superClass != null) {
            allGetters(superClass);
        }
    }

    public static void allGetters(Object object) {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                System.out.println(method);
            }
        }
    }

    public static void checkFieldsValue(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!field.getName().equals(field.get(object))){
//                throw new IllegalStateException(field.getName() + " - Имя и значение не совпадает !");
                System.out.println(field.getName() + " - Имя и значение не совпадает !");
            }
            System.out.println(field);
        }
    }

    public static void main(String[] args) throws Exception {
        allMethods(new CalculatorImpl());
        System.out.println("-----------------------------------------------------------------------");
        allGetters(new CalculatorImpl());
        System.out.println("-----------------------------------------------------------------------");
        checkFieldsValue(new CalculatorImpl());

    }
}

