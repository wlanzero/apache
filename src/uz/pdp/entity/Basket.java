package uz.pdp.entity;

public class Basket {
    private static long counter=0;
    {
        counter++;
        id=counter;
    }
    private long id;
    private long user_id;
    private int product_id;

    public Basket() {
    }

    public Basket(long user_id, int product_id) {
        this.user_id = user_id;
        this.product_id = product_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public long getId() {
        return id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
