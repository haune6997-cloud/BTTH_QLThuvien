import java.time.Year;
import java.util.Scanner;
public class Quanlisach {
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
        System.out.println("\n--- CHỌN LOẠI SÁCH ---");
        System.out.println("1. Sách giáo khoa");
        System.out.println("2. Sách tham khảo");
        System.out.println("3. Sách chuyên ngành");
        System.out.println("4. Sách khác");
        System.out.print("Nhập lựa chọn (1-4): ");
        int loai = scanner.nextInt();
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05;
        double tongTienNhap = thanhTien + phiVanChuyen;
        int namHienTai = Year.now().getValue();
        boolean hopLe = true;
        if (donGia <= 0) {
            System.out.println("Cảnh báo: Giá sách phải > 0.");
            hopLe = false;
        }
        if (soLuong < 0) {
            System.out.println("Cảnh báo: Số lượng phải >= 0.");
            hopLe = false;
        }
        if (namXuatBan <= 0 || namXuatBan > namHienTai) {
            System.out.println("Cảnh báo: Năm xuất bản không hợp lệ.");
            hopLe = false;
        }
        String mucGia;
        if (donGia < 50000) {
            mucGia = "Sách giá thấp";
        } else if (donGia <= 100000) {
            mucGia = "Sách giá trung bình";
        } else if (donGia <= 200000) {
            mucGia = "Sách giá cao";
        } else {
            mucGia = "Sách giá đặc biệt";
        }
        String tonKho;
        if (soLuong == 0) {
            tonKho = "Hết sách";
        } else if (soLuong <= 5) {
            tonKho = "Sắp hết";
        } else if (soLuong <= 20) {
            tonKho = "Còn ít";
        } else {
            tonKho = "Còn nhiều";
        }
        String tenLoaiSach;
        switch (loai) {
            case 1:
                tenLoaiSach = "Sách giáo khoa";
                break;
            case 2:
                tenLoaiSach = "Sách tham khảo";
                break;
            case 3:
                tenLoaiSach = "Sách chuyên ngành";
                break;
            case 4:
                tenLoaiSach = "Sách khác";
                break;
            default:
                tenLoaiSach = "Không xác định";
                break;
        }
        System.out.println("\n========== BÁO CÁO CHI TIẾT ==========");
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tên sách: " + tenSach);
        System.out.println("Tác giả: " + tacGia);
        System.out.println("Loại sách: " + tenLoaiSach);
        System.out.println("Năm xuất bản: " + namXuatBan);
        System.out.printf("Đơn giá: %,.0f VNĐ\n", donGia);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Trạng thái dữ liệu: " + (hopLe ? "Hợp lệ" : "Không hợp lệ"));
        System.out.println("Phân loại giá: " + mucGia);
        System.out.println("Tình trạng kho: " + tonKho);
        System.out.println("--------------------------------------");
        System.out.printf("Thành tiền: %,.0f VNĐ\n", thanhTien);
        System.out.printf("Phí vận chuyển (5%%): %,.0f VNĐ\n", phiVanChuyen);
        System.out.printf("Tổng tiền nhập: %,.0f VNĐ\n", tongTienNhap);
        scanner.close();
    }
}