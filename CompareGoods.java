import java.util.*;
public class CompareGoods {
    private TreeSet<Goods> goods;

    public CompareGoods(){
        goods = new TreeSet<>();
    }

    public void addGoods(String name, int price, int quantity){
        Goods good = new Goods(name, price, quantity);
        goods.add(good);
    }

    public void displayGoods(){
        for(Goods good:goods){
            System.out.println(good);
        }
    }

    public double calculateTotalSales() {
        double total = 0;
        for (Goods good: goods) {
            total += good.getPrice() * good.getQuantity();
        }
        return total;
    }

    public Goods getMostPopularGoood() {
        return Collections.max(goods, Comparator.comparingInt(Goods::getQuantity));
    }


    public static void main(String[] args) {
        CompareGoods compare = new CompareGoods();

        
        compare.addGoods("Banana", 121, 6);
        compare.addGoods("Orange", 150, 10);
        compare.addGoods("Strawberry", 170, 5);
        compare.addGoods("Apple", 139, 2);
        compare.addGoods("Vine", 1500, 2);

        System.out.println("The list of the goods");
        compare.displayGoods();

        double totalSales = compare.calculateTotalSales();
        System.out.println("total sales amount " + totalSales);

        Goods mostPopular = compare.getMostPopularGoood();
        System.out.println("The most popular is " + mostPopular);
    }

        
  


    
}
