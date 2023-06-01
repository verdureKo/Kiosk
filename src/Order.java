import java.util.*;

public class Order {
    Scanner sc = new Scanner(System.in);

    // 장바구니로 사용할 cart 객체 생성
    Cart cart = new Cart();

    // 대기번호
    int number = 0;

    // 메인메뉴(초기화면) 생성
    public void Menu() {
        System.out.println("\n\"BOOK STORE 에 오신 것을 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ BOOK STORE MENU ]");
        for (Menu m: menuList) {
            if (Objects.equals(m.getIndex(), "5.")) { 
                System.out.println("\n[ ORDER MENU ]");
                System.out.println(m.getIndex() + "\t" + m.getName() + " | " + m.getDescription());

            } else {
                System.out.println(m.getIndex() + "\t" + m.getName() + " | " + m.getDescription());
            }
        }
        while (true) {
            String i = sc.nextLine();
            if (i.contains("1") || i.contains("세이노의 가르침")) {
                Menus("베스트", bestList); // 카테고리 이름
            } else if (i.contains("2") || i.contains("EBS 수능완성 국어영역")) {
                Menus("수능완성", CSATList);
            } else if (i.contains("3") || i.contains("작가, 업계인, 철학자, 스파이")) {
                Menus("신상품", newList);
            } else if (i.contains("4") || i.contains("투자의 역사는 반드시 되풀이 된다")) {
                Menus("이벤트", eventList);
            } else if (i.contains("5") || i.contains("Order") || i.contains("order")) {
                order();
            } else if (i.contains("6") || i.contains("Cancel") || i.contains("cancel")) {
                orderCancel();
            } else {
                System.out.println("잘못 입력하셨습니다. 상품명을 다시 입력해주세요.");
            }
        }

    }

    // 상세 메뉴판을 불러오는 메소드
    public void Menus(String category, List<Items> itemsList) {
        System.out.println("\n[ " + category + " MENU ]");
        for (Items items: itemsList) {
            System.out.println(items.getIndex() +"\t" + items.getName() + " | W " + items.getPrice() + " | " + items.getDescription());
        }
        String i = sc.nextLine();
        Items items = null;
        for (Items item: itemsList) {
            if ((item.getIndex()+item.getName()).contains(i)) {
                items = item;
            }
        }
        System.out.println();
        System.out.println("\"" + items.getName() + " | W " + items.getPrice() +  " | " + items.getDescription() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n");
        System.out.println("1. 확인            2. 취소");
        String option = sc.nextLine();
        if (Objects.equals(option, "1") || Objects.equals(option, "1.") || Objects.equals(option, "확인")) {
            cart.countList(items);
            System.out.println(items.getName() + " 이/가 장바구니에 추가되었습니다.\n");
        }
        Menu(); // 초기화면으로 가기
    }

    public void order() {
        System.out.println("\n아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for (Items items: cart.getCartList()) {
            System.out.println(items.getName() + " | W " + items.getPrice() + " | " + items.getDescription());
        }

        System.out.println("\n[ Total ]");
        double sum = 0;     // 주문하는 상품 합계
        int total = 0;     // 주문하는 상품 개수 합계
        for (Items items: cart.getCartList()) {     // size나 length를 선언하지 않고 바로 할 수 있는 for문
            sum += items.getPrice();
            total += cart.getNumber();
        }
        System.out.println("W " + Math.round(sum*100)/100.0 + " | " + total + " 권");
        System.out.println("W " + Math.round(sum) + " | " + total + " 권");
        System.out.println("W " + sum + " | " + total + " 권");


        System.out.println("\n1. 주문            2. 메뉴판");
        String option = sc.nextLine();
        if (Objects.equals(option, "1")|| Objects.equals(option, "1.") || Objects.equals(option, "확인")) {
            System.out.println("\n주문이 완료 되었습니다.\n");
            System.out.println("대기번호는 " + ++number + "번 입니다.");     // ++를 붙여서 대기번호가 1씩 증가되도록 함
            System.out.println("(3초후에 메인 메뉴판으로 돌아갑니다.)");
            try{
                Thread.sleep(3000); // 3초 간 쓰레드를 재우는? 것
            } catch (Exception e){
                System.out.println(e.getMessage());
            };
        }
        Menu(); // 초기화면으로 가기
    }

    // 주문취소 메소드
    public void orderCancel() {
        System.out.println("주문을 취소하시겠습니까?");
        System.out.println("1. 확인            2. 취소");
        String option = sc.nextLine();
        if (Objects.equals(option, "1")|| Objects.equals(option, "1.") || Objects.equals(option, "확인")) {
            System.out.println("주문이 취소되었습니다.\n");
            cart.clearCart();   // 리스트 내용 지움
        }
        Menu(); // 초기화면으로 가기
    }

    // 메인 메뉴 리스트
    public List<Menu> menuList = Arrays.asList(
        new Menu("1.", "세이노의 가르침", "대한민국 자산가의 통찰"),
        new Menu("2.", "EBS 수능완성 국어영역", "EBS 고등 국어영역 수능완성 필독도서"),
        new Menu("3.", "작가, 업계인, 철학자, 스파이", "김영준의 첫 번째 에세이가 출간"),
        new Menu("4.", "투자의 역사는 반드시 되풀이 된다", "행운의 황금 2달러 증정"),
        new Menu("5.", "장바구니", "장바구니를 확인 후 주문합니다."),
        new Menu("6.", "취소", "진행중인 주문을 취소합니다.")
    ); // menuList

    // 베스트셀러 리스트
    List<Items> bestList = Arrays.asList(
        new Items("1.", "세이노의 가르침", 7.2, "대한민국 자산가의 통찰"),
        new Items("2.", "네 인생 우습지 않다", 18.0, "일타강사의 행복론"),
        new Items("3.", "그냥 밥 먹자는 말이 아니었을지도 몰라", 17.0, "달에서 만든 맛있는 이야기"),
        new Items("4.", "역행자(확장판)", 19.5, "돈 시간 운명으로부터 완전한 자유를 얻는 7단계 인생 공략집"),
        new Items("5.", "상식을 뒤엎는 돈의 심리학", 18.8, "돈에 관해 반드시 알아야 할 것들")
    ); // productListCoffee

    // 수능완성 리스트
    List<Items> CSATList = Arrays.asList(
        new Items("1.", "EBS 수능완성 국어영역", 12.7, "EBS 고등 국어영역 수능완성 필독도서"),
        new Items("2.", "EBS 수능완성 영어영역", 12.7, "EBS 고등 영어영역 수능완성 필독도서"),
        new Items("3.", "EBS 수능완성 수학영역", 12.7, "EBS 고등 수학영역 수능완성 필독도서"),
        new Items("4.", "EBS 수능완성 사회탐구영역", 8.3, "EBS 고등 사회탐구영역 수능완성 필독도서"),
        new Items("5.", "EBS 수능완성 과학탐구영역", 8.3, "EBS 고등 과학탐구영역 수능완성 필독도서")
    ); // productListTea

    // 신상품 리스트
    List<Items> newList = Arrays.asList(
        new Items("1. ", "작가, 업계인, 철학자, 스파이", 17.0, "김영준의 첫 번째 에세이가 출간"),
        new Items("2. ", "원피스 105: 루피의 꿈", 5.5, "새로운 사황의 탄생"),
        new Items("3. ", "조이스박의 챗GPT 영어공부법", 19.8, "30년차 영어교육 전문가가 만든 챗GTP 영어 학습서"),
        new Items("4. ", "리얼 하노이 2023~2024", 20.0, "하노이를 가장 멋지게 여행하는 방법"),
        new Items("5. ", "자가포식", 17.0, "생명과학이 밝혀낸 수명 연장의 비밀")
    ); // productListIB

    // 이벤트 리스트
    List<Items> eventList = Arrays.asList(
        new Items("1.", "투자의 역사는 반드시 되풀이 된다", 20.0, "행운의 황금 2달러 증정"),
        new Items("2.", "식물적 낙관", 15.0, "식물적 낙관 스티커 세트 증정"),
        new Items("3.", "해커스경찰 갓대환", 37.5, "김대환 형사법 조문집 증정"),
        new Items("4.", "좋은 말만 하기 운동 본부", 9.0, "이영주작가 친필 사인본 증정"),
        new Items("5.", "김언호의 서재탐험", 19.8, "양장 노트 증정")
    ); // productListDessert
} // Order.java
