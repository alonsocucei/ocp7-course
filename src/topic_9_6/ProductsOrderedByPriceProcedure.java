package topic_9_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author alonsocucei
 */
public class ProductsOrderedByPriceProcedure {

    public static void getProducts(String description, ResultSet[] rs) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:default:connection");
        PreparedStatement stmt = null;

        String query = "SELECT * FROM PRODUCT WHERE DESCRIPTION LIKE ? ORDER BY PURCHASE_COST DESC";

        stmt = con.prepareStatement(query);
        stmt.setString(1, description);
        rs[0] = stmt.executeQuery();
    }

    public static void main(String[] args) throws SQLException {
        createProcedures(DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app"));
    }

    public static void createProcedures(Connection con) throws SQLException {
        String queryShowSuppliers
                = "CREATE PROCEDURE SHOW_PRODUCTS( "
                + "IN description varchar(100)) "
                + "PARAMETER STYLE JAVA "
                + "LANGUAGE JAVA "
                + "DYNAMIC RESULT SETS 1 "
                + "EXTERNAL NAME "
                + "'topic_9_6."
                + "ProductsOrderedByPriceProcedure."
                + "getProducts'";

        try (Statement stmtCreateProductsProcedure = con.createStatement();){
            System.out.println("Calling CREATE PROCEDURE");
            stmtCreateProductsProcedure.executeUpdate(queryShowSuppliers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
