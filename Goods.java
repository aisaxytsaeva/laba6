public class Goods implements Comparable<Goods>{
    private String name;
    private int price;
    private int quantity;

    public Goods(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    @Override
    public int compareTo(Goods other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("Good: " + name +" , Price: " + price +", The amount of sold: " + quantity);
    }


}
