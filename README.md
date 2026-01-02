# ShopList – Console Java Application

Jednoduchá konzolová aplikace v Javě pro správu nákupního seznamu.  
Projekt slouží jako ukázka základní architektury aplikace, práce s databází (JDBC) a oddělení odpovědností mezi jednotlivé vrstvy.

---

## 🧠 Cíl projektu

Cílem projektu nebylo vytvořit složitý systém, ale:
- navrhnout **čistou a čitelnou architekturu**
- oddělit vstup, logiku a databázi
- dotáhnout **funkční celek**, ne prototyp

Projekt je určen jako **ukázkový projekt pro hledání práce (junior Java developer)**.

---

## 🏗️ Architektura

Aplikace je rozdělena do jasných vrstev:

Main
└─ Input (čtení a technická validace vstupu)
└─ Service (aplikační a doménová logika)
└─ DAO (přístup k databázi)
└─ MySQL databáze


### Vrstvy:
- **Main** – řídí tok programu a menu
- **Input / Validator** – technická validace vstupu od uživatele
- **Service** – aplikační logika a doménová validace
- **DAO** – čistá práce s databází (JDBC)
- **Entity / DTO** – datové objekty

Každá vrstva má **jednu jasnou odpovědnost**.

---

## ⚙️ Použité technologie

- Java (JDK 17+)
- JDBC
- MySQL
- Konzolové rozhraní

Bez frameworků – cílem bylo porozumění základům.

---

## 📋 Funkcionalita

Aplikace umožňuje:
- přidání položky do nákupního seznamu
- vyhledávání položek podle názvu (`LIKE %text%`)
- aktualizaci počtu nákupů
- jednoduché konzolové menu

---

## 🗄️ Databáze

Použitá tabulka:

```sql
CREATE TABLE shop_list (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    numberOfPurchases INT NOT NULL
);

▶️ Spuštění aplikace

    Vytvořit databázi shop_list v MySQL
    Upravit přihlašovací údaje v Database.java
    Spustit třídu Main
    Ovládat aplikaci pomocí konzolového menu

🧪 Testování

Projekt je testován:
    ručně pomocí testovacího Main
    ověřením chování databázových operací (INSERT, SELECT, UPDATE)

Cílem nebylo pokrytí testy, ale ověření správného toku aplikace.
📝 Poznámka k návrhu

Projekt vznikal postupně:
    nejdříve byla navržena kostra
    následně byly ověřeny databázové operace
    až poté bylo doplněno menu a validace
Důraz byl kladen na:
čitelnost
jednoduchost
dlouhodobou udržitelnost
