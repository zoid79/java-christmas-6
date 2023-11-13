package christmas.Menu;

import java.util.HashMap;
import java.util.Map;

public enum Menu {
    eTBonesteak("티본스테이크",1,55000),
    eBarbecueRibs("바비큐립",1,54000),
    eSeafoodPasta("해산물파스타",1,35000),
    eChiristmasPasta("크리스마스파스타",1,25000),
    eSoup("양송이수프",2,6000),
    eTapas("타파스",2,5500),
    eSalad("시저샐러드",2,8000),
    eChocoCake("초코케이크",3,15000),
    eIceCream("아이스크림",3,5000),
    eZeroCoke("제로콜라",4,3000),
    eRedWine("레드와인",4,60000),
    eChampagne("샴페인",4,25000);
    final private String menuName;
    final private int type;
    final private int price;

    Menu(String menuName, int type, int price) {
        this.type = type;
        this.menuName = menuName;
        this.price = price;
    }
    public String getMenuName() {return menuName;}
    public int getPrice() {return price;}
    public int getType() {return type;}
}
