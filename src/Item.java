// 1. 클래스 정의: Menu를 상속받는 Item 클래스 정의 *피드백: 클래스명은 복수가 아닌 단수로 표현
public class Item extends Menu {
    // 2. 필드(속성) 정의: 상품 가격
    private double price;

    public double getPrice() { return price; }      // 상품 가격
    @Override
    public String getDescription() { return super.getDescription(); }       // 상속: 상품 설명

    // 3. 기본 생성자
    public Item() {}

    // 3. 생성자(모두 선택) 정의
    public Item(int index, String name, double price, String description) {
        super(index, name, description);
        this.price = price;
    }

} // Item.java