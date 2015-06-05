import java.lang.Exception;
import java.lang.IllegalAccessException;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvokerTest{

    private static final MethodInvokerTest instance = new MethodInvokerTest();
    private static int count;

    public void hello() {
        ++count;
        System.out.println("find me " + count);
    }

    public static void main(String[] args) throws Exception {
        Method method = instance.getClass().getMethod("hello");
        method.invoke(instance);

        invokeException(method);

        while (count < 16) {
            method.invoke(instance);
        }

        invokeException(method);
    }

    private static void invokeException(Method method) {
        try {
            method.invoke(instance, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
