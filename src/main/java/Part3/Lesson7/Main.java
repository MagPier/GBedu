package Part3.Lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void start(Class<?> className) {
        final int MIN_PRIORITY = 1;
        final int MAX_PRIORITY = 10;
        int afterSuiteCounter = 0;
        int beforeSuiteCounter = 0;
        Map<Integer, Method> map = new TreeMap<>();
        for (Method method : className.getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                map.put(MIN_PRIORITY - 1, method);
                beforeSuiteCounter++;
                if (beforeSuiteCounter>1){
                    throw new RuntimeException();
                }
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                map.put(MAX_PRIORITY + 1, method);
                afterSuiteCounter++;
                if (afterSuiteCounter>1){
                    throw new RuntimeException();
                }
            }
            if (method.getAnnotation(Test.class) != null) {
                Test test = method.getAnnotation(Test.class);
                map.put(test.priority(), method);
            }
        }
        System.out.println("Map:");
        for (Integer key : map.keySet()) {
            System.out.println("priority:" + key + " " + map.get(key).getName());
        }

        try {
            Tests tests = new Tests();
            for (Integer key : map.keySet()) {
                map.get(key).invoke(tests);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Annotations analyze:");
        start(Tests.class);
    }
}
