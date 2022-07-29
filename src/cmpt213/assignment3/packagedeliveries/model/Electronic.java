package cmpt213.assignment3.packagedeliveries.model;

import java.time.LocalDateTime;

public class Electronic extends Package {

    private double environmental_handling_fee;

    public Electronic(String name, String notes, double price, double weight, boolean delivered, LocalDateTime expected_delivery_date) {
        super(name, notes, price, weight, delivered, expected_delivery_date);
    }

    public Electronic(String name, String notes, double price, double weight,
                      boolean delivered, LocalDateTime expected_delivery_date,
                      double environmental_handling_fee) {

        super(name, notes, price, weight, delivered, expected_delivery_date);
        this.environmental_handling_fee = environmental_handling_fee;
    }

    public double getEnvironmental_handling_fee() {
        return environmental_handling_fee;
    }

    public void setEnvironmental_handling_fee(double environmental_handling_fee) {
        this.environmental_handling_fee = environmental_handling_fee;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "environmental_handling_fee=" + environmental_handling_fee +
                ", name='" + getName() + '\'' +
                ", notes='" + getNotes() + '\'' +
                ", price=" + getPrice() +
                ", weight=" + getWeight() +
                ", delivered=" + isDelivered() +
                ", expected_delivery_date=" + getExpected_delivery_date() +
                '}';
    }
}
