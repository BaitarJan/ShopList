package shopList.Dao;

import shopList.Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShopItemUpdateDao {

    public void updateNumberOfPurchases(int id, int newNumberOfPurchases) {

        String sql = "UPDATE shop_list SET numberOfPurchases = ? WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newNumberOfPurchases);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Chyba při aktualizaci počtu nákupů", e);
        }
    }

    public void updateShopList(int id, String newName, double newPrice, int newNumberOfPurchases) {

        String sql = "UPDATE shop_list SET name = ?, price = ?, numberOfPurchases = ? WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newName);
            stmt.setDouble(2, newPrice);
            stmt.setInt(3, newNumberOfPurchases);
            stmt.setInt(4, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Chyba při aktualizaci položky", e);
        }
    }
}






