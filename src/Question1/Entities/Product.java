package Question1.Entities;

import java.util.Objects;

public class Product {
    private String identifier;
    private String name;

    public Product() {

    }

    public Product(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return  Objects.equals(identifier, product.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

}
