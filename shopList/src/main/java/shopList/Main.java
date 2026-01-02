package shopList;

import shopList.JavaInput.InputReader;
import shopList.Java.ShopList;
import shopList.Java.ShopListSearch;
import shopList.Service.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        InputReader reader = new InputReader();

        ShopListInsertService insertService = new ShopListInsertService();
        ShopListSearchService searchService = new ShopListSearchService();
        ShopListUpdateService updateService = new ShopListUpdateService();

        boolean running = true;

        while (running) {
            System.out.println("""
                    
                    ===== SHOP LIST =====
                    1 - Přidat položku
                    2 - Vyhledat položku
                    3 - Zvýšit počet nákupů
                    0 - Konec
                    =====================
                    """);

            int choice = reader.readValidatedNumber();

            switch (choice) {
                case 1 -> {
                    System.out.print("Název: ");
                    String name = reader.readValidatedText();

                    System.out.print("Cena: ");
                    double price = Double.parseDouble(reader.readValidatedNumber() + "");

                    ShopList item = new ShopList(name, price, 1);
                    insertService.addItem(item);
                    System.out.println("✅ Položka přidána.");
                }

                case 2 -> {
                    System.out.print("Hledat: ");
                    String searchText = reader.readValidatedText();

                    ShopListSearch search = new ShopListSearch(searchText);
                    List<ShopList> result = searchService.search(search);

                    result.forEach(i ->
                            System.out.println(
                                    i.getId() + " | " +
                                            i.getName() + " | " +
                                            i.getPrice() + " | " +
                                            i.getNumberOfPurchases()
                            )
                    );
                }

                case 3 -> {
                    System.out.print("ID položky: ");
                    int id = reader.readValidatedNumber();

                    System.out.print("Nový počet nákupů: ");
                    int count = reader.readValidatedNumber();

                    updateService.updateNumberOfPurchases(id, count);

                    System.out.println("✅ Aktualizováno.");
                }

                case 0 -> running = false;

                default -> System.out.println("❌ Neplatná volba.");
            }
        }

        System.out.println("Program ukončen.");
    }
}