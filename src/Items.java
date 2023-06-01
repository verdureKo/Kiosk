// 1. 클래스 정의: Menu를 상속받는 Items 클래스 정의
public class Items extends Menu {
    // 2. 필드(속성) 정의: 상품 가격
    private double price;

    @Override
    public String getIndex() { return super.getIndex(); }       // 상속: 상품 번호
    @Override
    public String getName() { return super.getName(); }       // 상속: 상품 이름
    public double getPrice() { return price; }      // 상품 가격
    @Override
    public String getDescription() { return super.getDescription(); }       // 상속: 상품 설명

    // 3. 기본 생성자
    public Items() {}

    // 3. 생성자(모두 선택) 정의
    public Items(String index, String name, double price, String description) {
        super(index, name, description);
        this.price = price;
    }

} // Items.java
