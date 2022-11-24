public class Calculator {
    int numberOfPeople = 0;
    String currentProduct = "";
    double currentPrice = 0;
    String productList = "";
    double allProductPrice = 0;

    void addProductName(String str) {
        this.productList += str;
    }

    void priceSum(double price) {
        this.allProductPrice += price;
    }
}
