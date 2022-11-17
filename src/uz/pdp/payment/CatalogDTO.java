package uz.pdp.payment;

public class CatalogDTO {
    private String name;

    public CatalogDTO() {
    }

    public CatalogDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
