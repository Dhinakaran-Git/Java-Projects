
import java.lang.reflect.Constructor;

public class ReflectString {

    public static void main(String[] args) {
        Class s = String.class;
        System.out.println(s.getConstructors().length);
        Constructor[] cs = s.getConstructors();
        Constructor last = cs[cs.length - 1];
        System.out.println(last.getParameterCount());
    }
}
