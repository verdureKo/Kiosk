package kiosk;

import kiosk.customerOrder.OrderCollection;
import kiosk.menu.Category_menu1;
import kiosk.menu.*;
import kiosk.menu.Price;
import kiosk.operation.*;
import kiosk.receipt.CreateReceipt;

import java.util.Scanner;

public class KioskOrder {

    boolean wantToCancel = false;	//주문취소 여부
    boolean orderMore = true;		//추가주문 여부
    boolean orderCheck = true;		//주문확인 결과

    //constructor. 생성과 동시에 start() 메서드 호출
    protected KioskOrder() {
        System.out.println("ORDER START!\n");
        start();
    }

    //주문받고(receiveOrder) 영수증을 출력(CreateReceipt)하는 메서드 호출
    private void start() {

        wantToCancel= false;
        orderMore = true;
        orderCheck = true;
        int count = 0;

        //추가주문 여부
        while (orderMore) {
            wantToCancel        = false;
            boolean[] boolArr   = receiveOrder();
            orderMore           = boolArr[0];

            //주문개수 증가
            if(!boolArr[1]){
                count++;
                System.out.println("count++");
            }
        }
        //주문확인 결과
        if(orderCheck){
            new CreateReceipt(count);
        } else {
            orderMore = true;
            orderCheck = true;
            this.start();
        }
    }

    //Operation 인터페이스 구현객체를 호출하여 주문받기
    private boolean[] receiveOrder() {
        Scanner scan = new Scanner(System.in);

        boolean[] booleans = new boolean[2];
        while (!wantToCancel) {
            printMenu();
            Operation oper = null;

            //음료 종류
            oper = new Operation0_kind();
            wantToCancel = oper.execute(scan);
            if(wantToCancel) { reset(); break; }

            //음료 온도
            oper = new Operation1_temper();
            wantToCancel = oper.execute(scan);
            if(wantToCancel) { reset(); break; }

            //음료 샷
            oper = new Operation2_shot();
            wantToCancel = oper.execute(scan);
            if(wantToCancel) { reset(); break; }

            //음료 크기
            oper = new Operation3_size();
            wantToCancel = oper.execute(scan);
            if(wantToCancel) { reset(); break; }

            //음료 섭취장소
            oper = new Operation4_where();
            wantToCancel = oper.execute(scan);
            if(wantToCancel) { reset(); break; }

            oper = new Operation5_orderMore();
            orderMore = oper.execute(scan);

            //추가주문을 원치 않는다면
            if(!orderMore) {
                oper = new Operation6_orderCheck();
                orderCheck = oper.execute(scan);
                break;
            }
        }
        booleans[0] = orderMore;
        booleans[1] = wantToCancel;
        return booleans;
    }

    //주문취소시 List를 null로 만듬
    private void reset(){
        System.out.println("reset 호출");
        OrderCollection col = OrderCollection.getInstance();
        col.reset_orderInfo();
    }

    //메뉴 출력
    private void printMenu() {
        MainMenu[] mainMenuArr = MainMenu.values();
        Price p		= new Price();
        int[] priceArr	= p.getBeveragePrice();

        System.out.println("PR COFFEE 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        for(int i = 0; i< Category_menu1.values().length; i++) {
            System.out.printf(" %d. %s\t %d원\n", i+1, mainMenuArr[i], priceArr[i]);  // 이스케이프 문자 츄라이 망함
        }
    }
}