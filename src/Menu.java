//📌 클래스는 객체를 생성하기 위한 설계도라고 배웠습니다.
//    - 클래스의 구성 멤버에는 필드, 생성자, 메서드가 있습니다.
//
//📌 우리가 클래스를 만들기 위해서는 4가지 STEP 이 필요합니다.
//        1. 만들려고 하는 설계도를 선언합니다.(클래스 선언)
//        2. 객체가 가지고 있어야할 속성(필드)을 정의합니다.
//        3. 객체를 생성하는 방식을 정의합니다.(생성자)
//        4. 객체가 가지고 있어야할 행위(메서드)를 정의합니다.

// 1. 클래스 선언: 초기화면 클래스
public class Menu  {
    // 2. 필드(속성) 정의 : 상품 번호, 상품 이름, 상품 설명
    private String index;
    private String name;
    private String description;

    // 4. 메소드 정의: 각 상품에 접근 가능한 getter 메소드
    public String getIndex() {
        return index;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    // 3. 기본 생성자
    public Menu() {}

    // 3. 생성자
    public Menu(String index, String name, String description) {
        this.index = index;
        this.name = name;
        this.description = description;
    }
} // Menu.java
