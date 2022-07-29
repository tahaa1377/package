package cmpt213.assignment3.packagedeliveries.model;

import java.time.LocalDateTime;

public class PackageFactory {

    public Package getPackage(String packageType, String name, String notes, double price,
                            double weight, boolean delivered,
                            LocalDateTime expected_delivery_date){
        if(packageType == null){
            return null;
        }
        if(packageType.equalsIgnoreCase("Book")){
            return new Book(name, notes, price, weight, delivered, expected_delivery_date);

        } else if(packageType.equalsIgnoreCase("Perishable")){
            return new Perishable(name, notes, price, weight, delivered, expected_delivery_date);

        } else if(packageType.equalsIgnoreCase("Electronic")){
            return new Electronic(name, notes, price, weight, delivered, expected_delivery_date);
        }

        return null;
    }
}
