# Chương trình quản lý trung tâm ngoại ngữ

## Chạy chương trình:
    - Truy cập theo đường dẫn: out > artifacts > QuanLyTrungTamNgoaiNgu_jar và mở file QuanLyTrungTamNgoaiNgu.jar lên để chạy

## Lưu ý về data:
    - Thư mục resource trong src > main chứa các file xml. Đây chỉ là các file dữ liệu gốc.
    - Chương trình chạy, đọc/ghi và lưu tại các file xml trong thư mục out > artifacts > QuanLyTrungTamNgoaiNgu_jar > data

## Đăng nhập với vai trò Quản lý:
username: admin
password: admin
## Đăng nhập với vai trò học viên
username: HV + {id của học viên}
password: {ngày tháng năm sinh của học viên (bỏ '/')}
- Ví dụ:
    Học viên có Id = 3 và sinh ngày 29/11/2004
    username: HV3
    password: 29112004
## Đăng nhập với vai trò giảng viên
username: GV + {id của giảng viên}
password: {ngày tháng năm sinh của Giảng viên (bỏ '/')}
- Ví dụ:
    Giảng viên có Id = 3 và sinh ngày 29/11/2004
    username: GV3
    password: 29112004

## Với vai trò quản lý: 
 - Quyền quản lý các học viên/giảng viên/khóa học như: thêm, sửa, xóa
 - Cho phép quản lý sử dụng học viên/giảng viên để đăng ký khóa học

## Với vai trò giảng viên/học viên
 - Chỉ được đăng ký khóa học

# Chú ý:
    - Chỉ đăng ký được khóa học có giảng viên.
## Nguoi thuc hien: Nguyen Huu Nien
