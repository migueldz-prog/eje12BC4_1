import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

            String sql = "SELECT COUNT(*) AS total " +      //LE DAMOS NOMBRE AL RESULTADO DEL COUNT Y DESPUES LO GUARDAMOS EN UN VARIABLE QUE SACAMOS EN EL PRINT
                    "FROM EMPLEADO " +
                    "WHERE salario > 3000";
            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int total=rs.getInt("total");

                System.out.println("Empleados con salario >3000: " + total);
            }

        } catch (SQLException e) {
            System.out.println("Error encontrado: " + e.getMessage());
        }
    }
}