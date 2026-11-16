import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sach> danhSachSach = new ArrayList<>();

        System.out.print("Nhap so luong sach can them: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin sach thu " + (i + 1) + ":");
            System.out.print("Ma sach: ");
            String maSach = scanner.nextLine();

            System.out.print("Tieu de: ");
            String tieuDe = scanner.nextLine();

            System.out.print("Tac gia: ");
            String tacGia = scanner.nextLine();

            System.out.print("Nam xuat ban: ");
            int namXuatBan = Integer.parseInt(scanner.nextLine());

            System.out.print("So luong: ");
            int soLuong = Integer.parseInt(scanner.nextLine());

            Sach s = new Sach(maSach, tieuDe, tacGia, namXuatBan, soLuong);
            danhSachSach.add(s);
        }

        System.out.println("\n=== DANH SACH SACH DA NHAP ===");
        for (Sach s : danhSachSach) {
            s.hienThiThongTin();
        }

        scanner.close();
    }
}