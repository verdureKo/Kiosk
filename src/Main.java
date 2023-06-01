public class Main {
    public static void main(String[] args) {

        Order order = new Order();           // 주문할 수 있는 인스턴스 객체 생성

        System.out.println();
        try {
            order.Menu();
        } catch (Exception e) {                 // 예외 처리 필수
            System.out.println(e.getMessage()); // 예외 관련 메시지 출력
        }
    }
}