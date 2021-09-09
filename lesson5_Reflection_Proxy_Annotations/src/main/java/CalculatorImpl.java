import java.lang.reflect.Proxy;

public class CalculatorImpl implements Calculator {
    private static int num1;
    private static double num2;
    private static final String MONDAY = "MONDAY";
    private static final String TUESDAY = "TUESDAY";
    private static final String WEDNESDAY = "WEDNESDAY";
    private static final String THURSDAY = "THURSDAY";
    private static final String FRIDAY = "FRIDAY";
    private static final String SATURDAY = "SATURDA";
    private static final String SUNDAY = "SUNDAY";

    public static int getNum1() {
        return num1;
    }

    public static void setNum1(int num1) {
        CalculatorImpl.num1 = num1;
    }

    public static double getNum2() {
        return num2;
    }

    public static void setNum2(double num2) {
        CalculatorImpl.num2 = num2;
    }

    public static String getMONDAY() {
        return MONDAY;
    }

    public static String getTUESDAY() {
        return TUESDAY;
    }

    public static String getWEDNESDAY() {
        return WEDNESDAY;
    }

    public static String getTHURSDAY() {
        return THURSDAY;
    }

    public static String getFRIDAY() {
        return FRIDAY;
    }

    public static String getSATURDAY() {
        return SATURDAY;
    }

    public static String getSUNDAY() {
        return SUNDAY;
    }

    @Override
    public int calc(int number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * calc(number - 1);
        }
    }

    private int calcP(int number) {
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new CalculatorImpl().calc(25));
        System.out.println("-------------------------------------------------------------------------------");
        Calculator delegate = new CalculatorImpl();
        Calculator calculator = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CachedInvocationHandler(delegate));
        int result = calculator.calc(2);
        System.out.println("result = " + result);
        int result2 = calculator.calc(7);
        System.out.println("result = " + result2);
        System.out.println("-------------------------------------------------------------------------------");
        Calculator calculatorMetric = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new PerformanceProxy(delegate));
        System.out.println(calculatorMetric.calc(9));
        System.out.println("-------------------------------------------------------------------------------");
        Test1 toClass = new Test1();
        Test1 fromClass = new Test1();
        Test2 toClass2 = new Test2();
        fromClass.setNum1(99);
        fromClass.setStr1("Testing ....");
        toClass2.setNum2(99.99);
        toClass2.setStr2("Testing 2 ....");
        System.out.println("toClass getInt = "+toClass.getNum1()+" , getString = "+toClass.getStr1());
        BeanUtils.assign(toClass, fromClass);
        System.out.println("toClass getInt = "+toClass.getNum1()+" , getString = "+toClass.getStr1());
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("to2Class getDouble = "+toClass2.getNum2()+" , getString = "+toClass2.getStr2());
        BeanUtils.assign(toClass2, fromClass);
        System.out.println("to2Class getDouble = "+toClass2.getNum2()+" , getString = "+toClass2.getStr2());
    }
}
