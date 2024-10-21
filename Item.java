class Item {
    private double itemPrice;
    private String itemName;
    private String itemCode;
    private int itemQuantity;

    public Item() {}

    // Konstruktor baru untuk memasukkan jumlah pembelian
    public Item(String code, String name, double price, int quantity) {
        this.itemCode = code;
        this.itemName = name;
        this.itemPrice = price;
        this.itemQuantity = quantity;
    }

    // Mengembalikan jumlah total per item (harga * jumlah)
    public double getSubTotal() {
        return itemPrice * itemQuantity;
    }

    public String getCode() {
        return itemCode;
    }

    public String getName() {
        return itemName;
    }

    public double getPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return itemQuantity;
    }
}
