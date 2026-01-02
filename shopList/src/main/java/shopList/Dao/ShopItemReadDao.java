package shopList.Dao;

import shopList.Database.Database;
import shopList.Java.ShopList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopItemReadDao {
   // načtení nakupního seznamu z db
public List<ShopList>loadShopListFromDb(){
  List<ShopList> shopLists = new ArrayList<>();
  String sql = "SELECT id,name,price,numberOfPurchases FROM shop_list";


    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            int numberOfPurchases = rs.getInt("numberOfPurchases");

            ShopList shopList = new ShopList(id, name, price,numberOfPurchases);
            shopLists.add(shopList);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return shopLists;



}

}
