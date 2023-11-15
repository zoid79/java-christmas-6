package christmas;

import christmas.Menu.Menu;
import christmas.UI.InputView;
import christmas.UI.OutputView;

import java.util.List;

public class Calculation {
    private List<Menu> menus;
    int sellingprice =0;
    InputView inputView;
    OutputView outputView;
    public Calculation(List<Menu> menus) {
        this.menus = menus;
        inputView = new InputView();
        outputView= new OutputView();
    }
    private int beverageCount=0;
    private int mainMenuCount=0;
    private int dessertCount=0;
    private int appetizerCount=0;
    private int salePrice=0;
    private boolean presentationFlag=false;

    public void calculate(int date, int sellingprice) {
        this.sellingprice = sellingprice;
        this.outputView.showSellingPrice(sellingprice);
        if(sellingprice>120000){
            this.sellingprice +=Menu.eChampagne.getPrice();
            this.salePrice+=Menu.eChampagne.getPrice();
            this.presentationFlag=true;
        }
        this.outputView.showPresentation(this.presentationFlag);

        if(date<=25){
            this.salePrice+=900+date*100;
            this.outputView.addBenefitText("크리스마스 디데이 할인: "+this.outputView.formatPrice(-900+date*100)+"원\n");
        }
        if(date%7==2||date%7==1){
            this.salePrice += mainMenuCount*2023;
            this.outputView.addBenefitText("주말 할인: "+this.outputView.formatPrice(-mainMenuCount*2023)+"원\n");
        }
        if(date%7==0||date%7==3||date%7==4||date%7==5||date%7==6){
            this.salePrice += dessertCount*2023;
            this.outputView.addBenefitText("평일 할인: "+this.outputView.formatPrice(-dessertCount*2023)+"원\n");
        }
        if(date%7==3||date==25){
            this.salePrice += 1000;
            this.outputView.addBenefitText("특별 할인: "+this.outputView.formatPrice(-1000)+"원\n");
        }
        if(this.presentationFlag){
            this.outputView.addBenefitText("증정 이벤트: "+this.outputView.formatPrice(-25000)+"원\n");
        }
        this.outputView.showBenefit();
        this.outputView.showDiscount(this.salePrice);
        this.outputView.showTotalPrice(this.sellingprice-this.salePrice);
        this.outputView.showbadge(this.takeBadge(this.salePrice));
    }

public String takeBadge(int salePrice){
        if(salePrice>=20000) return "산타";
        if(salePrice>=10000) return "트리";
        if(salePrice>=5000) return "별";
        return "없음";
}
    public int countMenu() {
        int totalPrice=0;
        for(Menu menu:this.menus){
            if(menu.getType()==1)mainMenuCount++;
            if(menu.getType()==2)appetizerCount++;
            if(menu.getType()==3)dessertCount++;
            if(menu.getType()==4)beverageCount++;
            totalPrice=totalPrice+menu.getPrice();
        }
        if(mainMenuCount+dessertCount+appetizerCount==0)throw new IllegalArgumentException("주문하실 수 없습니다");
        if(mainMenuCount+dessertCount+appetizerCount+beverageCount>20)throw new IllegalArgumentException("주문하실 수 없습니다");
        return totalPrice;
    }

    public int getBeverageCount() {return beverageCount;}

    public void setBeverageCount(int beverageCount) {this.beverageCount = beverageCount;}

    public int getMainMenuCount() {return mainMenuCount;}

    public void setMainMenuCount(int mainMenuCount) {this.mainMenuCount = mainMenuCount;}

    public int getDessertCount() {return dessertCount;}

    public void setDessertCount(int dessertCount) {this.dessertCount = dessertCount;}

    public int getAppetizerCount() {return appetizerCount;}

    public void setAppetizerCount(int appetizerCount) {this.appetizerCount = appetizerCount;}
}
