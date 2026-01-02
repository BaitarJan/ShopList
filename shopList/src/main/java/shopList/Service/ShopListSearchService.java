package shopList.Service;

import shopList.Dao.ShopItemSearchDao;
import shopList.Java.ShopList;
import shopList.Java.ShopListSearch;

import java.util.List;

public class ShopListSearchService {

    private final ShopItemSearchDao dao = new ShopItemSearchDao();

    public List<ShopList> search(ShopListSearch search) {
        return dao.findByNameLike(search.getSearchInput());
    }
}