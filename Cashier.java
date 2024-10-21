import java.util.ArrayList;

public class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    // Menambahkan item ke dalam daftar
    public void addItem(String code, String name, double price, int quantity) {
        items.add(new Item(code, name, price, quantity));
        System.out.println("Barang ditambahkan.");
    }

    // Menampilkan daftar item dan subtotal tiap item
    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("Tidak ada barang di keranjang.");
            return;
        }

        System.out.println("Daftar Transaksi:");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s\n", "Kode", "Nama", "Harga", "Jumlah", "SubTotal");

        double total = 0.0;
        for (Item item : items) {
            double subTotal = item.getSubTotal();
            total += subTotal;
            System.out.printf("%-10s %-20s %-10.2f %-10d %-10.2f\n",
                    item.getCode(), item.getName(), item.getPrice(), item.getQuantity(), subTotal);
        }
        System.out.println("Total harga: " + total);
    }

    // Menghapus item berdasarkan kode
    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode().equals(code)) {
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    // Menghitung total semua barang
    public double getTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getSubTotal();
        }
        return total;
    }

    // Proses pembayaran
    public void processPayment(double payment) {
        double total = getTotal();
        if (payment < total) {
            System.out.println("Pembayaran kurang. Total belanja: " + total);
        } else {
            double change = payment - total;
            System.out.println("Pembayaran berhasil.");
            System.out.println("Kembalian: " + change);
        }
    }
}
