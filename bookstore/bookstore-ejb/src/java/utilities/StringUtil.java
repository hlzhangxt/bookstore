package utilities;

public class StringUtil {

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNull(String obj) {
        return obj == null || obj.trim().length() == 0;
    }
}
