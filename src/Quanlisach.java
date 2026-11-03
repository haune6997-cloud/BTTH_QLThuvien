import java.util.Scanner;

public class Quanlisach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] danhSachSach = new String[100];
        int soLuongSach = 0;
        int luaChonMenu;

        do {
            System.out.println("\n========= MENU BÀI THỰC HÀNH TUẦN 6 =========");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Bài 1: Quản lý mảng số lượng (5 cuốn)");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn (1-9): ");

            try {
                luaChonMenu = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                luaChonMenu = 0;
            }

            switch (luaChonMenu) {
                case 1:
                    if (soLuongSach >= 100) {
                        System.out.println("Danh sách đã đầy, không thể thêm sách mới!");
                        break;
                    }
                    System.out.print("Nhập mã sách: ");
                    String maSach = scanner.nextLine();
                    System.out.print("Nhập tên sách: ");
                    String tenSach = scanner.nextLine();
                    System.out.print("Nhập tác giả: ");
                    String tacGia = scanner.nextLine();
                    System.out.print("Nhập năm xuất bản: ");
                    int namXuatBan = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập đơn giá: ");
                    double donGia = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nhập số lượng: ");
                    int soLuong = Integer.parseInt(scanner.nextLine());

                    System.out.println("--- CHỌN LOẠI SÁCH ---");
                    System.out.println("1. Sách giáo khoa");
                    System.out.println("2. Sách tham khảo");
                    System.out.println("3. Sách chuyên ngành");
                    System.out.println("4. Sách khác");
                    System.out.print("Nhập lựa chọn (1-4): ");
                    int loai = Integer.parseInt(scanner.nextLine());

                    String tenLoaiSach;
                    switch (loai) {
                        case 1: tenLoaiSach = "Sách giáo khoa"; break;
                        case 2: tenLoaiSach = "Sách tham khảo"; break;
                        case 3: tenLoaiSach = "Sách chuyên ngành"; break;
                        case 4: tenLoaiSach = "Sách khác"; break;
                        default: tenLoaiSach = "Không xác định"; break;
                    }

                    double thanhTien = donGia * soLuong;
                    double tongTienNhap = thanhTien + (thanhTien * 0.05);

                    String thongTinSach = maSach + ";" + tenSach + ";" + tacGia + ";" + tenLoaiSach + ";"
                            + namXuatBan + ";" + donGia + ";" + soLuong + ";" + tongTienNhap;

                    danhSachSach[soLuongSach] = thongTinSach;
                    soLuongSach++;
                    System.out.println("-> Đã thêm sách thành công!");
                    break;

                case 2:
                    System.out.println("\n--- DANH SÁCH SÁCH ---");
                    if (soLuongSach == 0) {
                        System.out.println("Danh sách trống!");
                    } else {
                        for (int i = 0; i < soLuongSach; i++) {
                            String[] arr = danhSachSach[i].split(";");
                            System.out.printf("Mã: %s | Tên: %s | Tác giả: %s | Loại: %s | Năm XB: %s | Đơn giá: %,.0f | SL: %s | Tổng tiền: %,.0f\n",
                                    arr[0], arr[1], arr[2], arr[3], arr[4], Double.parseDouble(arr[5]), arr[6], Double.parseDouble(arr[7]));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTimKiem = scanner.nextLine();
                    boolean timThay = false;
                    for (int i = 0; i < soLuongSach; i++) {
                        if (danhSachSach[i].startsWith(maTimKiem + ";")) {
                            String[] arr = danhSachSach[i].split(";");
                            System.out.printf("TÌM THẤY -> Mã: %s | Tên: %s | Tác giả: %s | Loại: %s | Năm XB: %s | Đơn giá: %,.0f | SL: %s | Tổng tiền: %,.0f\n",
                                    arr[0], arr[1], arr[2], arr[3], arr[4], Double.parseDouble(arr[5]), arr[6], Double.parseDouble(arr[7]));
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) {
                        System.out.println("Không tìm thấy sách có mã: " + maTimKiem);
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = scanner.nextLine();
                    int viTriXoa = -1;
                    for (int i = 0; i < soLuongSach; i++) {
                        if (danhSachSach[i].startsWith(maXoa + ";")) {
                            viTriXoa = i;
                            break;
                        }
                    }
                    if (viTriXoa != -1) {
                        for (int i = viTriXoa; i < soLuongSach - 1; i++) {
                            danhSachSach[i] = danhSachSach[i + 1];
                        }
                        danhSachSach[soLuongSach - 1] = null;
                        soLuongSach--;
                        System.out.println("-> Đã xóa sách thành công!");
                    } else {
                        System.out.println("Không tìm thấy sách có mã: " + maXoa);
                    }
                    break;

                case 5:
                    System.out.print("Nhập mã sách cần sửa: ");
                    String maSua = scanner.nextLine();
                    int viTriSua = -1;
                    for (int i = 0; i < soLuongSach; i++) {
                        if (danhSachSach[i].startsWith(maSua + ";")) {
                            viTriSua = i;
                            break;
                        }
                    }

                    if (viTriSua != -1) {
                        System.out.println("Nhập thông tin mới cho sách (Giữ nguyên mã sách):");
                        System.out.print("Nhập tên sách mới: ");
                        String tenMoi = scanner.nextLine();
                        System.out.print("Nhập tác giả mới: ");
                        String tacGiaMoi = scanner.nextLine();
                        System.out.print("Nhập năm xuất bản mới: ");
                        int namMoi = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhập đơn giá mới: ");
                        double donGiaMoi = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nhập số lượng mới: ");
                        int soLuongMoi = Integer.parseInt(scanner.nextLine());

                        System.out.println("--- CHỌN LOẠI SÁCH MỚI ---");
                        System.out.println("1. Sách giáo khoa");
                        System.out.println("2. Sách tham khảo");
                        System.out.println("3. Sách chuyên ngành");
                        System.out.println("4. Sách khác");
                        System.out.print("Nhập lựa chọn (1-4): ");
                        int loaiMoi = Integer.parseInt(scanner.nextLine());

                        String tenLoaiMoi;
                        switch (loaiMoi) {
                            case 1: tenLoaiMoi = "Sách giáo khoa"; break;
                            case 2: tenLoaiMoi = "Sách tham khảo"; break;
                            case 3: tenLoaiMoi = "Sách chuyên ngành"; break;
                            case 4: tenLoaiMoi = "Sách khác"; break;
                            default: tenLoaiMoi = "Không xác định"; break;
                        }

                        double tongTienMoi = (donGiaMoi * soLuongMoi) * 1.05;
                        String thongTinMoi = maSua + ";" + tenMoi + ";" + tacGiaMoi + ";" + tenLoaiMoi + ";"
                                + namMoi + ";" + donGiaMoi + ";" + soLuongMoi + ";" + tongTienMoi;

                        danhSachSach[viTriSua] = thongTinMoi;
                        System.out.println("-> Đã sửa sách thành công!");
                    } else {
                        System.out.println("Không tìm thấy sách có mã: " + maSua);
                    }
                    break;

                case 6:
                    int tongSL = 0;
                    for (int i = 0; i < soLuongSach; i++) {
                        String[] arr = danhSachSach[i].split(";");
                        tongSL += Integer.parseInt(arr[6]);
                    }
                    System.out.println("Tổng số lượng sách trong danh sách: " + tongSL);
                    break;

                case 7:
                    double tongGia = 0;
                    for (int i = 0; i < soLuongSach; i++) {
                        String[] arr = danhSachSach[i].split(";");
                        tongGia += Double.parseDouble(arr[7]);
                    }
                    System.out.printf("Tổng giá trị sách (đã gồm 5%% phí VC): %,.0f VNĐ\n", tongGia);
                    break;

                case 8:
                    int[] mangSoLuong = new int[5];
                    int tongMang = 0;
                    int maxSL = 0;
                    System.out.println("\n--- BÀI 1: XỬ LÝ MẢNG SỐ LƯỢNG ---");
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Nhập số lượng cuốn sách thứ " + (i + 1) + ": ");
                        mangSoLuong[i] = Integer.parseInt(scanner.nextLine());
                        tongMang += mangSoLuong[i];
                        if (i == 0 || mangSoLuong[i] > maxSL) {
                            maxSL = mangSoLuong[i];
                        }
                    }
                    System.out.print("Các số lượng đã nhập: ");
                    for (int sl : mangSoLuong) {
                        System.out.print(sl + " ");
                    }
                    System.out.println("\nTổng số lượng của mảng: " + tongMang);
                    System.out.println("Số lượng lớn nhất trong mảng: " + maxSL);
                    break;

                case 9:
                    System.out.println("Đang thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                    break;
            }
        } while (luaChonMenu != 9);

        scanner.close();
    }
}