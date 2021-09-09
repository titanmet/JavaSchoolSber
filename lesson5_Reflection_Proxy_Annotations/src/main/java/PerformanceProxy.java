import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceProxy implements InvocationHandler {
    Object delegate;

    public PerformanceProxy(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(!method.isAnnotationPresent(Metric.class)) return method.invoke(delegate, args);
        Long start = System.nanoTime();
        Object invoke = method.invoke(delegate, args);
        Long stop = System.nanoTime();
        System.out.println("Время работы метода: "+ method.getName() + " , " + (stop-start) +" (в наносек)");
        return invoke;
    }
}
