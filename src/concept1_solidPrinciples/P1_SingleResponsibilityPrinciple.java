/*
    S: Single Responsibility Principle
    A class should have only one reason to change.
*/


/*
class Marker {
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }
}

class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        int price = (this.marker.price * this.quantity);
        return price;
    }

    public void printInvoice() {
        System.out.println("Invoice Details:");
        System.out.println("Marker: " + this.marker.getName());
        System.out.println("Color: " + this.marker.getColor());
        System.out.println("Year: " + this.marker.getYear());
        System.out.println("Price per unit: " + this.marker.getPrice());
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Total Price: " + this.calculateTotal());
    }

    public void save() {
        // save the invoice.
        System.out.println("Invoice saved in DB.");
    }
}

public class P1_SingleResponsibilityPrinciple {
    public static void main(String args[]) {
        Marker m1 = new Marker("M1", "blue", 2021, 30);

        Invoice inv = new Invoice(m1, 5);
        System.out.println("Total Price : " + inv.calculateTotal());
        inv.printInvoice();
        inv.save();
    }
}
*/

/*
    In the above code, the Invoice class is not following the SRP.
    The Invoice class contains methods for calculating, printing, and saving invoices, and if any of these methods change, 
    it will affect the class in multiple ways, violating SRP.

    After converting Invoice to SRP: Below code.
    The Invoice class now solely handles calculating the total price of markers.
    New classes, `InvoicePrinter` and `InvoiceSaver`, were introduced to handle the printing and saving of invoices, respectively.
    
    This way, each class has only one reason to change:
    - `Invoice` handles the calculation of the total price.
    - `InvoicePrinter` handles the printing of the invoice.
    - `InvoiceSaver` handles the saving of the invoice.
*/


class Marker {
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }
}

class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        return this.marker.price * this.quantity;
    }

    public Marker getMarker() {
        return marker;
    }

    public int getQuantity() {
        return quantity;
    }
}

class InvoicePrinter {
    Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        System.out.println("Invoice Details:");
        System.out.println("Marker: " + invoice.getMarker().getName());
        System.out.println("Color: " + invoice.getMarker().getColor());
        System.out.println("Year: " + invoice.getMarker().getYear());
        System.out.println("Price per unit: " + invoice.getMarker().getPrice());
        System.out.println("Quantity: " + invoice.getQuantity());
        System.out.println("Total Price: " + invoice.calculateTotal());
    }
}

class InvoiceSaver {
    Invoice invoice;

    public InvoiceSaver(Invoice invoice) {
        this.invoice = invoice;
    }

    public void save() {
        System.out.println("Invoice saved in DB.");
    }
}

public class P1_SingleResponsibilityPrinciple {
    public static void main(String args[]) {
        Marker m1 = new Marker("M1", "blue", 2021, 30);
        Invoice inv = new Invoice(m1, 5);

        InvoicePrinter printer = new InvoicePrinter(inv);
        printer.printInvoice();

        InvoiceSaver saver = new InvoiceSaver(inv);
        saver.save();
    }
}
