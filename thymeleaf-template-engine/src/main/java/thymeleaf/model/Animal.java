package thymeleaf.model;

/**
 * Created by Ufuk on 15-10-15.
 */
public class Animal {

    private String family;

    public Animal() {
    }

    public Animal(String family) {
        this.family = family;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "{Family: " + this.family
                + "}";
    }
}
