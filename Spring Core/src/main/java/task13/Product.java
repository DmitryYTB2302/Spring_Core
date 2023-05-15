package task13;

public class Product {
    private String id;
    private String title;
    private double cost;

    public Product(String id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return " id " + id + " | " + title + " | " + cost;
    }
}
