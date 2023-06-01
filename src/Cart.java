import java.util.*;

public class Cart {
    // 장바구니 필드 생성
    private List<Items> cartList = new ArrayList<>();
    private int number = 1;     // 상품 개수

    // 필드에 접근 가능한 getter
    public List<Items> getCartList() {    // 장바구니에 접근할 수 있는 getter 생성
        return cartList;
    }

    public int getNumber() {    // 상품 수량에 접근할 수 있는 getter 생성
        return number;
    }

    // 장바구니 담기
    public void countList(Items items) {
        this.cartList.add(items);
    }

    // 장바구니 비우기
    public void clearCart() {
        this.cartList.clear();
    }

    // 기본 생성자
    public Cart() {}

    public Cart(List<Items> cartList, int number) {
        this.cartList = cartList;
        this.number = number;
    }

} // Cart.java
