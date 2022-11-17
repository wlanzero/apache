package uz.pdp.entity;

public class Product {
    private static long counter = 0;

    {
        counter++;
        id = counter;
    }

    private long id;
    private String name;
    private int price;
    private int catalog_id;

    public Product() {
    }

    public Product(String name, int price, int catalog_id) {
        this.name = name;
        this.price = price;
        this.catalog_id = catalog_id;
    }

    public Product(long id, String name, int price, int catalog_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.catalog_id = catalog_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(int catalog_id) {
        this.catalog_id = catalog_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", catalog_id=" + catalog_id +
                '}';
    }
}
