package kiosk.operation;

import kiosk.customerOrder.OrderCollection;
import kiosk.customerOrder.Orders;
import kiosk.menu.BeverShot;
import kiosk.receipt.UnitChange;

import java.util.Scanner;

//음료 샷 개수를 입력받는 역할 수행
public class Operation2_shot implements Operation {
	@Override
	public boolean execute(Scanner scan) {
		int input	 		= 0;		//주문내역 저장
		boolean goToNext 	= false;	//반복 플래그 변수
		boolean wantToCancel = false;	//리턴 객체

		//커피 종류를 주문하지 않았다면 아래 while 문 실행되지 않음
		Orders order = OrderCollection.get_orderData();
		if(!(order.getBeverKind()==1 || order.getBeverKind()==2)){
			goToNext = true;
		}

		while(!goToNext) {
			Mention m = new Mention();
			System.out.print(m.getMent2_shot());
			String request = scan.next().trim().toLowerCase();
			boolean isNumber = CheckRequest.isNumber(request);

			if(isNumber){
				int num = Integer.parseInt(request);
				int count = BeverShot.values().length;

				if(0<num && num<count+1) {
					input = num;

					int kind = order.getBeverKind();
					int temper = order.getBeverTemper();
					String str1 = UnitChange.toString_kind(kind);
					String str2 = UnitChange.toString_temper(temper);
					String str3 = UnitChange.toString_shot(num);

					System.out.printf("%s(%s/%s)\n", str1, str2, str3);

					goToNext = true;
				} else {
					System.out.println("번호를 다시 입력바랍니다 (1~2)");
				}
			}
			else if(request.equals("c")) {
				System.out.println(m.getMent6_cancel());

				request = scan.next().trim().toLowerCase();
				boolean isYesOrNo = CheckRequest.isYesOrNo(request);

				if(isYesOrNo && request.equals("y")) {
					System.out.println(m.getMent7_orderAgain());
					wantToCancel = true;
					break;
				}
			}
			else {
				System.out.println(m.getMent8_numberOnly());
			}
		}
		order.setBeverShot(input);

		return wantToCancel;
	}
}
