# PublicationManager
This is an ant java application that help you manage a number of publications in easy way

Bài Tập Giữa Phần:
Phát triển Ứng dụng Quản lý Ấn phẩm
Yêu cầu: 
- Ít nhất có 2 loại sách, báo; 
- Thống kê ấn phẩm; Tìm kiếm ít nhất theo 2 tiêu chí

IMPORTANT NOTE: PLEASE INSTALL VERSION JDK 14 OR HIGHER TO RUN THIS PROJECT. IF NOT, YOU CAN CHANGE THE SOURCE JDK OF THIS PROJECT AT IT'S PROPERTIES AND THEN FIX SOME PROBLEMS FROM THIS CHANGE.

1. Tên ứng dụng:
Publication Manager

2. Login
- User: admin
- Password: admin

3. Chức năng:
- Thêm, xóa, sửa thông tin của các ấn phẩm
 + Trường Id: id là  kiểu số nguyên int, tự động được chương trình thiết lập cho một ấn phẩm mới, bắt đầu từ 1, và tăng dần 1 đơn vị khi ấn phẩm mới được thêm vào.
 + Trường Title, Author, Type, Genre: là các trường chứa thông tin tiêu đề, tác giả, loại, thể loại của ấn phẩm, với dữ liệu đầu vào là String, bắt buộc không được để trống.
 + Trường Price: trường lưu giá tiền của ấn phẩm, kiểu dữ liệu đầu vào là int và phải lớn hơn hoặc không, không được để trống
 + Trường Abstract: dữ liệu đầu vào kiểu String, lưu một đoạn tóm tắt nội dung nổi bật của ấn phẩm, trường này có thể bỏ trống
- Sắp xếp theo các tiêu chí( ID, Title, Author, Type, Genre, Price) theo thứ tự từ a-z hoặc nhỏ đến lớn.
- Tìm kiếm:
 + Tìm kiếm theo Title, Author, Type, Genre: Bảng thống kê hiển thị ra các ấn phẩm có trường tương ứng CHỨA chuối kĩ tự người dùng nhập vào. Ví dụ: với nội dung tìm kiếm là "ap" theo tiêu chí title thì kết quả hiện thị trong bảng thống kê trả về có thể là các ấn phẩm có title như: "Geography Magazine" , "Science Newspaper", "National Geographic", "Chemistry Newspaper". Các ấn phẩm trong danh sách trả về sẽ được hiện thị trong bảng theo thứ tự nhất định, đó là ấn phẩm nào có độ chính xác với nội dung tìm kiếm hơn thì được hiển thị vị trí đầu.
 + Tìm kiếm theo ID: trả về chính xác ấn phẩm có ID nhập vào
 + Tìm kiếm theo Price: trả về danh sách các ấn phẩm có giá nằm trong khoảng 0.5-1.5 lần giá nhập vào, hiển thị chúng theo thứ tự cụ thể, đó là ấn phẩm nào có độ chính xác với giá tiền tìm kiếm hơn thì được hiển thị vị trí đầu. 
- Thống kê: các ấn phẩm được lưu trong file xml được hiển thị trên bảng 
- Làm mới: đưa danh sách các ấn phẩm được hiển thị trên bảng về mặc định - sắp xếp theo ID

4. Hướng dẫn sử dụng:
* Tại màn hình Đăng nhập:
- Người dùng phải đăng nhập đúng tài khoản đã cung cấp để sử dụng
* Tại màn hình chính của ứng dụng:
- Ứng dụng đã đưa 100 ấn phẩm có sẵn vào trong file xml để người dùng co thể trải nghiệm
- Tại mục Publication Info:
 + Người dùng nhập, sửa, xóa các thông tin của ấn phẩm theo các trường ID, Title, Author, Type, Genre, Price, Abstract
 + Để thao tác thêm / xóa / sửa được thực hiện thì người dùng phải click chuột vào các button tương ứng ADD, UPDATE, DELETE, CLEAR tương ứng tùy mục đích trong mục Main Manipulations
 + Trong Table List of Publications, người dụng có thể click chuột vào hàng chứa thông tin của ấn phẩm để thông tin của ấn phẩm đấy được lấy và hiển trị theo các trường trong mục Publiction Info. Tại mục này, người dùng lại có thể thực hiện các thao tác với ấn phẩm ấy.
 + Để sắp xếp danh sách ấn phẩm, mặc định thứ tự được sắp xếp theo ID, người dùng muốn danh sách trong bảng được hiển thị theo thứ tự dựa trên trường của nào ấn phẩm thì chọn trường tương ứng trong Item của ComboBox tại mục "Arrange By".
 + Để tìm kiếm ấn phẩm, mặc định thì ứng dụng sẽ tìm kiếm ấn phẩm theo ID, người dùng cần chọn trường tìm kiếm theo ý muốn tương ứng với Item của ComboBox tại mục "Search By", đồng thời nhập thông tin cần tìm kiếm liên quan đến trường tương ứng vào TextFieldFind nằm ngay phía trên bảng thống kê để ứng dụng có đủ dữ liệu đầu vào để thực hiện tìm kiếm, trả về danh sách theo yêu cầu tại bảng thống kê các ấn phẩm.
  Lệnh tìm kiếm và trả về danh sách ấn phẩm được thực thi khi người dùng: Thay đổi selected Item của comboBoxSearch; Nhấn phím ENTER tại textFieldSearch; click chuột vào phím btnSearch.
+ Để đưa bảng thống kê về trạng  thái mặc định, click nút "Refresh" đê bảng thống kê hiện thị tất cả các ấn phẩm theo thứ tự ID tăng dần.
 
