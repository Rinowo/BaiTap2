import java.sql.*;

public class Methodd {
    public Connection getConnection() throws SQLException {
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Bai Tap 2";
        String username = "Rinowo";
        String password = "Rinochan205.";
        return DriverManager.getConnection(dbURL, username, password);
    }

    public void m1() throws SQLException {
        String query = "SELECT * \n" +
                "FROM [Hop Dong] HD \n" +
                "WHERE HD.soChoNgoi > 5";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int soHopDong = resultSet.getInt("soHopDong");
            String bienso = resultSet.getString("bienSoXe");
            String loaixe = resultSet.getString("loaixe");
            int maNCC = resultSet.getInt("maNCC");
            int soChoNgoi = resultSet.getInt("soChoNgoi");
            System.out.println("Số hợp đồng: " + soHopDong + " Biển số: " + bienso + " Loại xe: " + loaixe +
                    " Mã Nhà Cung Cấp: " + maNCC + " Số chỗ ngồi: " + soChoNgoi);
        }
    }

    public void m2() throws SQLException {
        String query = "SELECT NCC.maNCC, NCC.tenNCC, NCC.diaChi, NCC.maSoThue, NCC.sdt\n" +
                "FROM [Nha Cung Cap] NCC INNER JOIN [Hop Dong] HD \n" +
                "ON NCC.maNCC = HD.maNCC INNER JOIN [Dang Ky] DK\n" +
                "ON HD.soHopDong = DK.soHopDong INNER JOIN [Muc Phi] MP \n" +
                "ON DK.maMP = MP.maMP\n" +
                "WHERE (NCC.tenNCC = 'Toyota' AND MP.loaiMP = '15.000 VNĐ/km') OR " +
                "(NCC.tenNCC = 'Kia' AND MP.loaiMP = '20.000 VNĐ/km')";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int maNCC = resultSet.getInt("maNCC");
            String tenNCC = resultSet.getString("tenNCC");
            String diaChi = resultSet.getString("diaChi");
            int maSoThue = resultSet.getInt("maSoThue");
            int sdt = resultSet.getInt("sdt");
            System.out.println("Mã nhà cung cấp: " + maNCC + "Tên nhà cung cấp: " + tenNCC + "Địa chỉ: " + diaChi +
                    "Mã số thuế: " + maSoThue + "Số điện thoại: " + sdt);
        }
    }

    public void m3() throws SQLException {
        String query = "SELECT * FROM [Nha Cung Cap] NCC ORDER BY NCC.tenNCC, NCC.maSoThue DESC";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int maNCC = resultSet.getInt("maNCC");
            String tenNCC = resultSet.getString("tenNCC");
            String diaChi = resultSet.getString("diaChi");
            int maSoThue = resultSet.getInt("maSoThue");
            int sdt = resultSet.getInt("sdt");
            System.out.println("Mã nhà cung cấp: " + maNCC + "Tên nhà cung cấp: " + tenNCC + "Địa chỉ: " + diaChi +
                    "Mã số thuế: " + maSoThue + "Số điện thoại: " + sdt);
        }
    }

    public void m4() throws SQLException {
        String query = "SELECT COUNT(DK.maDK) AS [Toyota] FROM [Dang Ky] DK INNER JOIN [Hop Dong] HD \n" +
                "ON DK.soHopDong = HD.soHopDong INNER JOIN [Nha Cung Cap] NCC \n" +
                "ON HD.maNCC = NCC.maNCC\n" +
                "WHERE DK.ngayBatDau = '2022/06/21' ";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

        }
    }

    public void m5() throws SQLException {
        String query = "SELECT NCC.maNCC, NCC.tenNCC, NCC.diaChi, NCC.maSoThue, DV.tenDV, MP.soTien, HD.loaiXe, " +
                "DK.ngayBatDau, DK.ngayKetThuc\n" +
                "FROM [Nha Cung Cap] NCC INNER JOIN [Hop Dong] HD \n" +
                "ON NCC.maNCC = HD.maNCC INNER JOIN [Dang Ky] DK \n" +
                "ON HD.soHopDong = DK.soHopDong INNER JOIN [Dich Vu] DV \n" +
                "ON DK.maDV = DV.maDV INNER JOIN [Muc Phi] MP\n" +
                "ON DK.maMP = MP.maMP";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int maNCC = resultSet.getInt("maNCC");
            String tenNCC = resultSet.getString("tenNCC");
            String diaChi = resultSet.getString("diaChi");
            int maSoThue = resultSet.getInt("maSoThue");
            int sdt = resultSet.getInt("sdt");
            String tenDV = resultSet.getString("tenDV");
            double soTien = resultSet.getDouble("soTien");
            String loaiXe = resultSet.getString("loaiXe");
            String ngayBD = resultSet.getString("ngayBatDau");
            String ngayKT = resultSet.getString("ngayKetThuc");
            System.out.println("Mã nhà cung cấp: " + maNCC + "Tên nhà cung cấp: " + tenNCC + "Địa chỉ: " + diaChi +
                    "Mã số thuế: " + maSoThue + "Số điện thoại: " + sdt + "Tên dịch vụ: " + tenDV + "Số tiền: " + soTien
                    + "Loại xe: " + loaiXe + "Ngày bắt đầu: " + ngayBD + "Ngày kết thúc: " + ngayKT);
        }
    }

    public void m6() throws SQLException {
        String query = "SELECT DISTINCT * \n" +
                "FROM [Nha Cung Cap] NCC INNER JOIN [Hop Dong] HD \n" +
                "ON NCC.maNCC = HD.maNCC\n" +
                "WHERE HD.loaiXe = 'Hiace' OR HD.loaiXe = 'Cerato'";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int maNCC = resultSet.getInt("maNCC");
            String tenNCC = resultSet.getString("tenNCC");
            String diaChi = resultSet.getString("diaChi");
            int maSoThue = resultSet.getInt("maSoThue");
            int sdt = resultSet.getInt("sdt");
            int soHD = resultSet.getInt("soHopDong");
            String bienSoXe = resultSet.getString("bienSoXe");
            String loaiXe = resultSet.getString("loaiXe");
            System.out.println("Mã nhà cung cấp: " + maNCC + "Tên nhà cung cấp: " + tenNCC + "Địa chỉ: " + diaChi +
                    "Mã số thuế: " + maSoThue + "Số điện thoại: " + sdt + "Số hợp đồng: " + soHD +
                    "Biển số xe: " + bienSoXe + "Loại xe: " + loaiXe);
        }
    }

    public void m7() throws SQLException {
        String query = "SELECT DISTINCT * FROM [Nha Cung Cap]";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int maNCC = resultSet.getInt("maNCC");
            String tenNCC = resultSet.getString("tenNCC");
            String diaChi = resultSet.getString("diaChi");
            int maSoThue = resultSet.getInt("maSoThue");
            int sdt = resultSet.getInt("sdt");
            System.out.println("Mã nhà cung cấp: " + maNCC + "Tên nhà cung cấp: " + tenNCC + "Địa chỉ: " + diaChi +
                    "Mã số thuế: " + maSoThue + "Số điện thoại: " + sdt);
        }
    }

    public void m8() throws SQLException {
        String query = "SELECT NCC.maNCC, NCC.tenNCC, NCC.diaChi, NCC.sdt, NCC.maSoThue \n" +
                "FROM [Nha Cung Cap] NCC INNER JOIN [Hop Dong] HD\n" +
                "ON NCC.maNCC = HD.maNCC INNER JOIN [Dang Ky] DK \n" +
                "ON HD.soHopDong = DK.maDK\n" +
                "WHERE DK.soHopDong = 0";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int maNCC = resultSet.getInt("maNCC");
            String tenNCC = resultSet.getString("tenNCC");
            String diaChi = resultSet.getString("diaChi");
            int maSoThue = resultSet.getInt("maSoThue");
            int sdt = resultSet.getInt("sdt");
            System.out.println("Mã nhà cung cấp: " + maNCC + "Tên nhà cung cấp: " + tenNCC + "Địa chỉ: " + diaChi +
                    "Mã số thuế: " + maSoThue + "Số điện thoại: " + sdt);
        }
    }
}
