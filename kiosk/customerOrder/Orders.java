package kiosk.customerOrder;

public class Orders {
    private int beverKind;		//종류
    private int beverTemper;	//음료 온도
    private int beverShot;		//음료 샷
    private int beverSize;		//음료 크기
    private int beverWhere;		//음료 섭취장소

    public int getBeverKind() {
        return beverKind;
    }
    public Orders setBeverKind(int beverKind) {
        this.beverKind = beverKind;
        return this;
    }

    public int getBeverTemper() {
        return beverTemper;
    }
    public Orders setBeverTemper(int beverTemper) {
        this.beverTemper = beverTemper;
        return this;
    }

    public int getBeverShot() {
        return beverShot;
    }
    public Orders setBeverShot(int beverShot) {
        this.beverShot = beverShot;
        return this;
    }

    public int getBeverSize() {
        return beverSize;
    }
    public Orders setBeverSize(int beverSize) {
        this.beverSize = beverSize;
        return this;
    }

    public int getBeverWhere() {
        return beverWhere;
    }
    public Orders setBeverWhere(int beverWhere) {
        this.beverWhere = beverWhere;
        return this;
    }
}
