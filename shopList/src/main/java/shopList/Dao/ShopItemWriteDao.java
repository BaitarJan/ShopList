package shopList.Dao;

import shopList.Database.Database;
import shopList.Java.ShopList;

import java.sql.*;

public class ShopItemWriteDao {

    // vložení položky do DB
    public void addItem(ShopList shopList) {

        String sql = "INSERT INTO shop_list (name, price, numberOfPurchases) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, shopList.getName());
            stmt.setDouble(2, shopList.getPrice());
            stmt.setInt(3, shopList.getNumberOfPurchases());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    shopList.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Chyba při vkládání položky", e);
        }
    }
}