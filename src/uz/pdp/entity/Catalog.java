package uz.pdp.entity;

public class Catalog {
    private static long counter = 0;

    {
        counter++;
        id = counter;
    }

    private long id;
    private String name;

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    public Catalog(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
