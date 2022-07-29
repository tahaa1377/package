package cmpt213.assignment3.packagedeliveries.model;

import java.time.LocalDateTime;

public class Book extends Package {

    private String author_name;

    public Book(String name, String notes, double price, double weight, boolean delivered, LocalDateTime expected_delivery_date) {
        super(name, notes, price, weight, delivered, expected_delivery_date);
    }

    public Book(String name, String notes, double price,
                double weight, boolean delivered,
                LocalDateTime expected_delivery_date, String author_name) {

        super(name, notes, price, weight, delivered, expected_delivery_date);
        this.author_name = author_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author_name='" + author_name + '\'' +
                ", name='" + getName() + '\'' +
                ", notes='" + getNotes() + '\'' +
                ", price=" + getPrice() +
                ", weight=" + getWeight() +
                ", delivered=" + isDelivered() +
                ", expected_delivery_date=" + getExpected_delivery_date() +
                '}';
    }
}
