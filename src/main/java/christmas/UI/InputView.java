package christmas.UI;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String DATE ="^(?:[1-9]|[12]\\d|3[0-1])$";
    public int inputDate() {
        String stringDate = Console.readLine().trim();
        if(stringDate.matches(DATE)) {
            System.out.println(stringDate);
            return Integer.parseInt(stringDate);}
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    public String getOrder() {
        String order = Console.readLine();
        System.out.println(order);
        return order;
    }
}
