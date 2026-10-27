import java.util.Scanner;
public class Quanlisach_Tuan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sách: ");
        String maSach = scanner.nextLine();
        System.out.print("Nhập tên sách: ");
        String tenSach = scanner.nextLine();
        System.out.print("Nhập tác giả: ");
        String tacGia = scanner.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        int namXuatBan = scanner.nextInt();
        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();
        System.out.print("Nhập số lượng: ");
        int soLuong = scanner.nextInt();
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05;
        double tongTienNhap = thanhTien + phiVanChuyen;
        System.out.println("\n--- THÔNG TIN NHẬP SÁCH ---");
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tên sách: " + tenSach);
        System.out.println("Tác giả: " + tacGia);
        System.out.println("Năm xuất bản: " + namXuatBan);
        System.out.printf("Đơn giá: %,.0f VNĐ\n", donGia);
        System.out.println("Số lượng: " + soLuong);
        System.out.printf("Thành tiền: %,.0f VNĐ\n", thanhTien);
        System.out.printf("Phí vận chuyển: %,.0f VNĐ\n", phiVanChuyen);
        System.out.printf("Tổng tiền nhập: %,.0f VNĐ\n", tongTienNhap);
        scanner.close();
    }
}