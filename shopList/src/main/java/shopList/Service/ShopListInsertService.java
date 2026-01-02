package shopList.Service;

import shopList.Dao.ShopItemWriteDao;
import shopList.Java.ShopList;

public class ShopListInsertService {
    private final ShopItemWriteDao dao = new ShopItemWriteDao();

    public void addItem(ShopList item) {
        if (item.getPrice() <= 0) {
            throw new IllegalArgumentException("Cena musí být větší než 0");
        }

        if (item.getNumberOfPurchases() < 0) {
            throw new IllegalArgumentException("Počet nákupů nesmí být záporný");
        }

        dao.addItem(item);
    }
}
