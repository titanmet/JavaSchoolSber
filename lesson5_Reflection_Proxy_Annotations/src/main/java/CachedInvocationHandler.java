import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

public class CachedInvocationHandler implements InvocationHandler {
    Object delegate;
    Map<Object, Object> result = new HashMap<>();

    public CachedInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(!method.isAnnotationPresent(Cache.class)) return method.invoke(delegate,args);
        Object invoke = method.invoke(delegate,args);
        traceInvocation(method, args);
        result.put(key(method, args), invoke);
        return result.get(key(method, args));
    }

//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        traceInvocation(method, args);
//        return method.invoke(delegate, args);
//    }

    private void traceInvocation(Method method, Object[] args) {
        System.out.println("invoke: " + method.getName() +
                (args != null ? "(" + Arrays.toString(args) + ")" : "()"));
    }

    private Object key(Method method , Object[] args){
        List<Object> key = new ArrayList<>();
        key.add(method);
        key.addAll(Arrays.asList(args));
        return key;
    }


}
