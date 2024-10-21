import java.util.Scanner;

class App {
    public static void main(String[] args) {

        Cashier cashier = new Cashier();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Lihat Daftar Barang");
            System.out.println("4. Tampilkan Total dan Bayar");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    String addCode = scanner.next();

                    System.out.print("Masukkan nama barang: ");
                    scanner.nextLine();  // Untuk menangkap newline
                    String addName = scanner.nextLine();

                    System.out.print("Masukkan harga barang: ");
                    double addPrice = scanner.nextDouble();

                    System.out.print("Masukkan jumlah barang: ");
                    int addQuantity = scanner.nextInt();

                    cashier.addItem(addCode, addName, addPrice, addQuantity);
                    break;

                case 2:
                    System.out.print("Masukkan kode barang yang akan dihapus: ");
                    String removeCode = scanner.next();
                    cashier.removeItem(removeCode);
                    break;

                case 3:
                    cashier.viewItems();
                    break;

                case 4:
                    double total = cashier.getTotal();
                    System.out.println("Total belanja: " + total);

                    System.out.print("Masukkan jumlah pembayaran: ");
                    double payment = scanner.nextDouble();
                    cashier.processPayment(payment);
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem kasir kami!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}
