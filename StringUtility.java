package utils;

public class StringUtility {

    public static String verifyEquals(String expected, String actual) {

        if (actual == expected) {
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
        return actual;
    }
}
