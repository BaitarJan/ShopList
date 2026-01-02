package shopList.Java;

public class ShopList {

    private int id;
    private String name;
    private double price;
    private int numberOfPurchases;

    public ShopList(int id,String name , double price ,int numberOfPurchases){
        this.id=id;
        this.numberOfPurchases=numberOfPurchases;
        this.name=name;
        this.price=price;
    }
    public ShopList(String name , double price ,int numberOfPurchases){

        this.numberOfPurchases=numberOfPurchases;
        this.name=name;
        this.price=price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumberOfPurchases(int numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }
}
