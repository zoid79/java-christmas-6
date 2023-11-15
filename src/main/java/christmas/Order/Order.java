package christmas.Order;

import camp.nextstep.edu.missionutils.Console;
import christmas.Calculation;
import christmas.Menu.Menu;
import christmas.UI.InputView;
import christmas.UI.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Order {
    InputView inputView;
    OutputView outputView;
    List<Menu> menus;
    Calculation calculation;
    private Map<String, Menu> menuMap = new HashMap<>();

    public Order() {
        for(Menu menu : Menu.values()){menuMap.put(menu.getMenuName(), menu);}
        inputView = new InputView();
        outputView= new OutputView();
        menus = new ArrayList<Menu>();
    }
    public void start() {
        boolean flag =true;
        int date=-1;
        while(flag) {
            try {
                outputView.showFirstMessage();
                date = inputView.inputDate();
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println(flag);
                flag = true;
            }
        }
        flag = true;
        while(flag){
            try{
                outputView.showOrderExample();
                String order = this.inputView.getOrder();
                String[] menus = order.split("[,\\-]");
                this.validationMenu(menus);
                flag=false;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                flag=true;
            }
        }
        this.outputView.showOrder();
        int totalPrice = 0;

        calculation = new Calculation(this.menus);
        try{
            totalPrice=calculation.countMenu();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        if(totalPrice<10000){
            this.outputView.showNoSaleUI(totalPrice);
            return;
        }
        calculation.calculate(date,totalPrice);
    }

    private void validationMenu(String[] menus) throws IllegalArgumentException{
        Menu menu=null;
        for(int j=0;j< menus.length;j++){
            if(j%2==0)menu = getMenu(menus[j]);
            if(j%2==1)addMenu(menus[j], menu);
        }
    }


    private void addMenu(String num, Menu menu) {
        this.outputView.addCountText(num);
        if(!num.matches("^[1-9]\\d*$"))throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        for(int k = 0; k<Integer.parseInt(num); k++) this.menus.add(menu);
    }
    private Menu getMenu(String menus) {
        Menu menu = null;
        menu = this.menuMap.get(menus);
        this.menus.remove(menu);
        if(menu==null)throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        this.outputView.addMenuText(menu.getMenuName());
        return menu;
    }
}

