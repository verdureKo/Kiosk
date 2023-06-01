public class Main {
    public static void main(String[] args) {
//        System.out.println("Kiosk Run"); // 구동확인

        Order order = new Order();           // 주문할 수 있는 인스턴스 객체 생성

        try {
            order.mainProduct();
        } catch (Exception e) {                 // 예외 처리 필수
            System.out.println(e.getMessage()); // 예외 관련 메시지 출력
        }
    }
}