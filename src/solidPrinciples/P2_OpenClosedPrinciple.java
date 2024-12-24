/*
    O - Open / Closed Principle
        A class should be open for extension but closed for modification.
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

public class P2_OpenClosedPrinciple {
    public static void main(String args[]) {
        Marker m1 = new Marker("M1", "blue", 2021, 30);
        Invoice inv = new Invoice(m1, 5);

        InvoicePrinter printer = new InvoicePrinter(inv);
        printer.printInvoice();

        InvoiceSaver saver = new InvoiceSaver(inv);
        saver.save();
    }
}
*/


/*
    In the above code, the InvoiceSaver class was violating the Open/Closed Principle (OCP).
    Initially, the InvoiceSaver class had a `save()` method to save invoices to the database. However, if we needed to add a new way of saving invoices (e.g., to a file), we would have to modify the `InvoiceSaver` class, which violates OCP.
    
    After converting the InvoiceSaver class to follow OCP: Below code.
    - The `InvoiceSaver` interface was introduced, allowing new classes to implement the interface for different ways of saving invoices.
    - We created `SaveInvoiceToDb` and `SaveInvoiceToFile` classes, each implementing the `InvoiceSaver` interface. This allows us to add new saving methods without modifying existing code.
    
    This approach keeps the `InvoiceSaver` class open for extension (we can add new ways of saving invoices) but closed for modification (we don't need to modify the existing classes to add new functionality).
*/

/*
import helperInterfaces.InvoiceSaver;

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

class SaveInvoiceToDb implements InvoiceSaver {
    Invoice invoice;

    public SaveInvoiceToDb(Invoice invoice) {
        this.invoice = invoice;
    }

    public void save() {
        System.out.println("Invoice saved in DB.");
    }
}

class SaveInvoiceToFile implements InvoiceSaver {
    Invoice invoice;

    public SaveInvoiceToFile(Invoice invoice) {
        this.invoice = invoice;
    }

    public void save() {
        System.out.println("Invoice saved in File.");
    }
}

public class P2_OpenClosedPrinciple {
    public static void main(String args[]) {
        Marker m1 = new Marker("M1", "blue", 2021, 30);
        Invoice invoice = new Invoice(m1, 5);

        InvoicePrinter printer = new InvoicePrinter(invoice);
        printer.printInvoice();

        SaveInvoiceToDb saveInvoiceDb = new SaveInvoiceToDb(invoice);
        saveInvoiceDb.save();

        SaveInvoiceToFile saveInvoiceFile = new SaveInvoiceToFile(invoice);
        saveInvoiceFile.save();
    }
}
*/