package cmpt213.assignment3.packagedeliveries.model;

import java.time.LocalDateTime;

public class Perishable extends Package {

    private LocalDateTime expiry_date;

    public Perishable(String name, String notes, double price, double weight, boolean delivered, LocalDateTime expected_delivery_date) {
        super(name, notes, price, weight, delivered, expected_delivery_date);
    }

    public Perishable(String name, String notes, double price, double weight,
                      boolean delivered, LocalDateTime expected_delivery_date,
                      LocalDateTime expiry_date) {

        super(name, notes, price, weight, delivered, expected_delivery_date);
        this.expiry_date = expiry_date;
    }

    public LocalDateTime getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(LocalDateTime expiry_date) {
        this.expiry_date = expiry_date;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "name='" + getName() + '\'' +
                ", notes='" + getNotes() + '\'' +
                ", price=" + getPrice() +
                ", weight=" + getWeight() +
                ", delivered=" + isDelivered() +
                ", expected_delivery_date=" + getExpected_delivery_date() +
                ", expiry_date=" + expiry_date +

                '}';
    }
}
