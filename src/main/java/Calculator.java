public class Calculator {
    int numberOfPeople;
    String currentProduct;
    double currentPrice;
    String productList;
    double allProductPrice;

    Calculator(String productList, double allProductPrice) {
        this.productList = productList;
        this.allProductPrice = allProductPrice;
    }

    void addProductName(String str) {
        this.productList +=str;
    }

    void priceSum(double price) {
        this.allProductPrice += price;
    }
}
