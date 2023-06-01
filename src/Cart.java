import java.util.*;

public class Cart {
    // 장바구니 필드 생성
    private List<Items> cartList = new ArrayList<>();

    // 필드에 접근 가능한 getter
    public List<Items> getCartList() {    // 장바구니에 접근 가능한 getter 생성
        return cartList;
    }

    // 장바구니 담기
    public void countList(Items items) {
        this.cartList.add(items);
    }

    // 기본 생성자
    public Cart() {}

    // 장바구니 비우기
    public void clearCart() {
        this.cartList.clear();
    }
} // Cart.java
