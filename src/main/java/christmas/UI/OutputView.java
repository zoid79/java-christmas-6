package christmas.UI;

import java.text.NumberFormat;

public class OutputView {
    private String newOrder="<주문 메뉴>\n";
    private String benefit="";
    public void showFirstMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
                "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");}

    public void showOrderExample() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }
    public void addMenuText(String menu) {
        newOrder=newOrder+menu+" ";
    }
    public void addCountText(String count) {
        newOrder=newOrder+count+"개\n";
    }
    public void addBenefitText(String benefit){
        this.benefit+=benefit;
    }
    public void showOrder(){
        System.out.println(newOrder);
    }

    public void showNoSaleUI(int totalPrice) {
        String stringPrice=this.formatPrice(totalPrice);
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(stringPrice);
        System.out.println(" ");
        System.out.println("<증정 메뉴>");
        System.out.println("없음");
        System.out.println(" ");
        System.out.println("<혜택 내역>");
        System.out.println("없음");
        System.out.println(" ");
        System.out.println("<총혜택 금액>");
        System.out.println("0원");
        System.out.println(" ");
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(stringPrice);
        System.out.println(" ");
        System.out.println("<12월 이벤트 배지>");
        System.out.println("없음");
    }
    public String formatPrice(int price) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(price);
    }
    public void showPresentation(boolean presentationFlag) {
        System.out.println("<증정 메뉴>");
        if(presentationFlag) System.out.println("샴페인 1개\n");
        if(!presentationFlag) System.out.println("없음\n");
    }
    public void showSellingPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(this.formatPrice(totalPrice)+"\n");
    }
    public void showBenefit(){
        System.out.println("<혜택 내역>");
        System.out.println(this.benefit);
    }

    public void showDiscount(int salePrice) {
        System.out.println("<총혜택 금액>");
        System.out.println(this.formatPrice(-salePrice));
        System.out.println();
    }

    public void showTotalPrice(int price) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(this.formatPrice(price)+"원");
    }

    public void showbadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
