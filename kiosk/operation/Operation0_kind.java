package kiosk.operation;

import kiosk.customerOrder.OrderCollection;
import kiosk.customerOrder.Orders;
import kiosk.menu.Category_menu1;
import kiosk.receipt.UnitChange;

import java.util.Scanner;

//음료 종류를 입력받는 역할 수행
public class Operation0_kind implements Operation {
	@Override
	public boolean execute(Scanner scan) {
		int input	 		= 0;		//주문내역 저장
		boolean goToNext 	= false;	//반복 플래그 변수
		boolean wantToCancel = false;	//리턴 객체
		//입력 반복문
		while(!goToNext) {

			//멘트 출력 및 입력값 받기
			Mention m = new Mention();
			System.out.print(m.getMent0_choose());
			String request = scan.next().trim().toLowerCase();
			//입력값이 숫자인지 확인
			boolean isNumber = CheckRequest.isNumber(request);

			if(isNumber){
				int num = Integer.parseInt(request);
				int count = Category_menu1.values().length;

				//숫자가 범위에 해당하는지 확인
				if(0<num && num<count+1) {
					input = num;

					//요청사항 출력하기
					String str1 = UnitChange.toString_kind(num);
					System.out.printf("%s\n", str1);

					goToNext = true;
				} else {
					System.out.println("번호를 다시 입력바랍니다 (1~6)");
				}
			}
			//취소 희망시
			else if(request.equals("c")) {
				System.out.println(m.getMent6_cancel());

				//y or n 입력 확인
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
		//요청사항 반영
		Orders order = OrderCollection.get_orderData();
		order.setBeverKind(input);

		return wantToCancel;
	}
}