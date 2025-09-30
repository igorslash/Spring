package todo.bankrestapi.util;

public class MaskUtil {
    public static String maskCardNumber(String cardNumber) {
        if(cardNumber == null || cardNumber.length() < 4) {
            return "*****";
        }
        return "**** **** ****" + cardNumber.substring(cardNumber.length() - 4);
    }
}
