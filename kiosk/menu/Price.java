package kiosk.menu;

public class Price {
    private final int PRICE01 = 2000;
    private final int PRICE02 = 2500;
    private final int PRICE03 = 3000;
    private final int PRICE04 = 3500;
    private final int PRICE05 = 4000;
    private final int PRICE06 = 4500;
    
    public int[] getBeveragePrice() {    	
    	int[] priceArr = {PRICE01, PRICE02, PRICE03, PRICE04, PRICE05, PRICE06};
    	return priceArr;
    }
}
