package christmas.Order;

import camp.nextstep.edu.missionutils.Console;
import christmas.Calculation;
import christmas.Menu.Menu;
import christmas.UI.InputView;
import christmas.UI.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Order {
    InputView inputView;
    OutputView outputView;
    List<Menu> menus;
    int totalPrice=0;
    public Order() {
        inputView = new InputView();
        outputView= new OutputView();
        menus = new ArrayList<Menu>();
    }

    public void start() {
        boolean flag =true;
        outputView.showFirstMessage();
        int i=-1;
        while(flag){
            try{
                i=inputView.inputDate();
                flag = false;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                flag = true;
            }
            Menu menu = null;
            flag = true;
            while(flag){
                try{
                    outputView.showOrderExample();
                    String order = Console.readLine();
                    String[] menus = order.split("[,\\-]");
                    for(int j=0;j< menus.length;j++){
                        if(j%2==0)menu = getMenu(menus[j]);
                        if(j%2==1) addMenu(menus[j], menu);
                    }
                }catch (IllegalArgumentException e){System.out.println(e.getMessage());}
            }
            Calculation calculation = new Calculation(this.menus);
            calculation.calculate();
            }


        }

    private void addMenu(String num, Menu menu) {
        if(num.matches("^[1-9]\\d*$")){
            for(int k = 0; k<Integer.parseInt(num); k++) this.menus.add(menu);
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private Menu getMenu(String menus) {
        Menu menu = null;
        menu = Menu.getMainMenu(menus);
        if(menu==null)throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        return menu;
    }
}

