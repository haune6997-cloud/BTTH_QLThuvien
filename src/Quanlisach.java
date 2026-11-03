import java.time.Year;
import java.util.Scanner;
public class Quanlisach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luaChonMenu;
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        String danhSachSach = "";
        int namHienTai = Year.now().getValue();
        do {
            System.out.println("\n========= MENU QUẢN LÝ SÁCH =========");
            System.out.println("1. Nhập n sách");
            System.out.println("2. Hiển thị tổng số lượng và tổng giá trị sách");
            System.out.println("3. Tìm sách theo mã");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn của bạn (1-4): ");
            luaChonMenu = scanner.nextInt();
            scanner.nextLine();
            switch (luaChonMenu) {
                case 1:
                    System.out.print("Nhập số lượng sách (n) cần thêm: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 1; i <= n; i++) {
                        System.out.println("\n--- Nhập thông tin sách thứ " + i + " ---");
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
                        System.out.println("--- CHỌN LOẠI SÁCH ---");
                        System.out.println("1. Sách giáo khoa");
                        System.out.println("2. Sách tham khảo");
                        System.out.println("3. Sách chuyên ngành");
                        System.out.println("4. Sách khác");
                        System.out.print("Nhập lựa chọn (1-4): ");
                        int loai = scanner.nextInt();
                        scanner.nextLine();
                        String tenLoaiSach;
                        switch (loai) {
                            case 1: tenLoaiSach = "Sách giáo khoa"; break;
                            case 2: tenLoaiSach = "Sách tham khảo"; break;
                            case 3: tenLoaiSach = "Sách chuyên ngành"; break;
                            case 4: tenLoaiSach = "Sách khác"; break;
                            default: tenLoaiSach = "Không xác định"; break;
                        }
                        double thanhTien = donGia * soLuong;
                        double phiVanChuyen = thanhTien * 0.05;
                        double tongTienNhap = thanhTien + phiVanChuyen;
                        tongSoLuong += soLuong;
                        tongGiaTri += tongTienNhap;
                        danhSachSach += "Mã: " + maSach + " | Tên: " + tenSach + " | Tác giả: " + tacGia
                                + " | Loại: " + tenLoaiSach + " | Năm XB: " + namXuatBan
                                + " | Đơn giá: " + donGia + " | SL: " + soLuong
                                + " | Tổng tiền nhập: " + tongTienNhap + "\n";
                        System.out.println("-> Đã thêm sách '" + tenSach + "' thành công!");
                    }
                    break;
                case 2:
                    System.out.println("\n========== TỔNG KẾT TÀI SẢN ==========");
                    System.out.println("Tổng số lượng sách trong thư viện: " + tongSoLuong);
                    System.out.printf("Tổng giá trị sách (đã cộng phí VC): %,.0f VNĐ\n", tongGiaTri);
                    break;
                case 3:
                    System.out.print("\nNhập mã sách cần tìm: ");
                    String maTimKiem = scanner.nextLine();
                    boolean timThay = false;
                    System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
                    Scanner stringScanner = new Scanner(danhSachSach);
                    while (stringScanner.hasNextLine()) {
                        String dong = stringScanner.nextLine();
                        if (dong.startsWith("Mã: " + maTimKiem + " |")) {
                            System.out.println(dong);
                            timThay = true;
                        }
                    }
                    stringScanner.close();
                    if (!timThay) {
                        System.out.println("Không tìm thấy sách có mã: " + maTimKiem);
                    }
                    break;
                case 4:
                    System.out.println("Đang thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập từ 1-4!");
                    break;
            }
        } while (luaChonMenu != 4);
        scanner.close();
    }
}
