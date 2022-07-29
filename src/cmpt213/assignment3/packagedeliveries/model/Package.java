package cmpt213.assignment3.packagedeliveries.model;

import java.time.LocalDateTime;

public class Package implements Comparable<Package> {

    private String name;
    private String notes;
    private double price;
    private double weight;
    private boolean delivered;
    private LocalDateTime expected_delivery_date;

    public Package(String name, String notes, double price,
                   double weight, boolean delivered,
                   LocalDateTime expected_delivery_date) {
        this.name = name;
        this.notes = notes;
        this.price = price;
        this.weight = weight;
        this.delivered = delivered;
        this.expected_delivery_date = expected_delivery_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public LocalDateTime getExpected_delivery_date() {
        return expected_delivery_date;
    }

    public void setExpected_delivery_date(LocalDateTime expected_delivery_date) {
        this.expected_delivery_date = expected_delivery_date;
    }

    @Override
    public String toString() {
        return "Package{" +
                "name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", delivered=" + delivered +
                ", expected_delivery_date=" + expected_delivery_date +
                '}';
    }


    @Override
    public int compareTo(Package o) {

        if (expected_delivery_date.compareTo(o.expected_delivery_date) == 0){
            return 0;
        }else if (expected_delivery_date.compareTo(o.expected_delivery_date) > 0){
            return 1;
        }else {
            return -1;
        }

    }


}
