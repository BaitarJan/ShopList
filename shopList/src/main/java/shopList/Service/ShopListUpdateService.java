package shopList.Service;

import shopList.Dao.ShopItemUpdateDao;

public class ShopListUpdateService {


    private final ShopItemUpdateDao dao = new ShopItemUpdateDao();

    public void updateNumberOfPurchases(int id, int newValue) {

        if (id <= 0) {
            throw new IllegalArgumentException("Neplatné ID");
        }

        if (newValue < 0) {
            throw new IllegalArgumentException("Počet nákupů nesmí být záporný");
        }

        dao.updateNumberOfPurchases(id, newValue);
    }


    public void updateItem(int id, String name, double price, int numberOfPurchases) {

        if (id <= 0) {
            throw new IllegalArgumentException("Neplatné ID");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Název nesmí být prázdný");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Cena musí být větší než 0");
        }

        if (numberOfPurchases < 0) {
            throw new IllegalArgumentException("Počet nákupů nesmí být záporný");
        }

        dao.updateShopList(id, name, price, numberOfPurchases);
    }
}