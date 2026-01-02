package shopList.Dao;

import shopList.Database.Database;
import shopList.Java.ShopList;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
public class ShopItemSearchDao {

    public List<ShopList> findByNameLike(String name) {

        List<ShopList> result = new ArrayList<>();

        String sql = """
            SELECT id, name, price, numberOfPurchases
            FROM shop_list
            WHERE name LIKE ?
        """;

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ShopList item = new ShopList(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getInt("numberOfPurchases")
                    );
                    result.add(item);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Chyba při vyhledávání položek", e);
        }

        return result;
    }
}