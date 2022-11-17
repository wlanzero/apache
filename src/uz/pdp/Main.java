package uz.pdp;

import uz.pdp.entity.Basket;
import uz.pdp.entity.Catalog;
import uz.pdp.entity.Product;
import uz.pdp.entity.User;
import uz.pdp.enums.User_type;
import uz.pdp.payment.CatalogDTO;
import uz.pdp.payment.ProductDTO;
import uz.pdp.payment.Result;
import uz.pdp.payment.UserDTO;
import uz.pdp.service.*;

import java.util.Scanner;

import static uz.pdp.service.BasketService.baskets;
import static uz.pdp.service.CatalogService.catalogs;
import static uz.pdp.service.ProductService.products;

public class Main {
    static Scanner textScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);
    static User currentUser = null;
    static User currentAdmin = null;
    static UserService userService = new UserServiceImpl();
    static CatalogService catalogService = new CatalogServiceImpl();
    static ProductService productService = new ProductServiceImpl();
    static BasketService basketService = new BasketServiceImpl();
    static {
        User user = new User("admin","admin","admin", User_type.ADMIN);
        UserService.users.add(user);
    }
    public static void main(String[] args) {
        market();
    }
    public static void market(){
        while (true) {
            System.out.println("0=>exit, 1=>admin, 2=>user");
            switch (numberScanner.nextInt()){
                case 0: return;
                case 1:
                    adminLogin();
                    if(currentAdmin!=null){
                        adminMenu();
                    }else{
                        System.out.println("login yoki password xato, qaytadan urinib ko'ring");
                    }
                    break;
                case 2:
                    userMenu();
                    break;
                default:
                    System.out.println("Noto'g'ri buyruq kiritildi!");
            }
        }
    }
    public static void userMenu(){
        while (true) {
            System.out.println("0=>orqaga, 1=>login, 2=>register");
            switch (numberScanner.nextInt()){
                case 0: return;
                case 1:
                    userLogin();
                    if(currentUser!=null){
                        userPage();
                    }else{
                        System.out.println("login yoki password xato, qaytadan urinib ko'ring");
                    }
                    break;
                case 2:
                    userRegister();
                    if(currentUser!=null){
                        userPage();
                    }else{
                        System.out.println("login yoki password xato, qaytadan urinib ko'ring");
                    }
                    break;
                default:
                    System.out.println("Noto'g'ri buyruq kiritildi!");
            }
        }
    }
    public static void userPage(){
        while (true) {
            System.out.println("0=>chiqish, 1=>barcha kataloglar, 2=>barcha mahsulotlar, 3=>basket");
            switch (numberScanner.nextInt()){
                case 0: currentUser=null; return;
                case 1:
                    getCatalogForUser();
                    break;
                case 2:
                    getAllProductsForUser();
                    break;
                case 3:
                    getBasket();
                    break;
                default:
                    System.out.println("Noto'g'ri buyruq kiritildi!");
            }
        }
    }
    public static void getBasket(){
        if(baskets.size()>0){
            while (true) {
                int sum = 0;
                for (Product product : products) {
                    for (Basket basket : baskets) {
                        if (basket.getUser_id() == currentUser.getId() && basket.getProduct_id() == product.getId()) {
                            System.out.println(product.getId()+" - "+product.getName()+", narxi: "+product.getPrice()+"$");
                            sum += product.getPrice();
                        }
                    }
                }
                System.out.println("0=>orqaga, 1=>mahsulotlarni xarid qilish, 2=>basketni bo'shatish");
                switch (numberScanner.nextInt()) {
                    case 0: return;
                    case 1:
                        System.out.println("Umumiy narx " + sum + "$ ni tashkil qildi. Xaridingiz uchun raxmat:)");
                        baskets.removeIf(basket1 -> basket1.getUser_id() == currentUser.getId());
                        break;
                    case 2:
                        baskets.removeIf(basket1 -> basket1.getUser_id() == currentUser.getId());
                        if(baskets.isEmpty()){
                            System.out.println("Basketda hech qanday mahsulot mavjud emas");
                        }
                        break;
                    default:
                        System.out.println("Noto'g'ri buyruq kiritildi!");
                }
            }
        }else{
            System.out.println("Basket bo'sh");
        }
    }
    public static void getAllProductsForUser(){
        if(products.size()>0) {
            while (true) {
                int counter1 = 0;
                for (Product product : products) {
                    System.out.println(product.getId() + " - " + product.getName() + ", narxi: " + product.getPrice() + "$");
                    counter1++;
                }
                System.out.println("0=>orqaga, basketga qo'shish uchun mahsulot tanlang(id bo'yicha)");
                int selectProduct1 = numberScanner.nextInt();
                if (selectProduct1 == 0) break;
                if (selectProduct1 > 0 && selectProduct1 <= counter1) {
                    Basket basket = new Basket(currentUser.getId(), selectProduct1);
                    Result result = basketService.create(basket);
                    if (result.isSuccess()) {
                        System.out.println(result.getMessage());
                    } else {
                        System.out.println(result.getMessage());
                    }
                    break;
                } else {
                    System.out.println("Noto'g'ri buyruq kiritildi!");
                }
            }
        }else {
            System.out.println("Xozircha mahsulotlar mavjud emas");
        }
    }
    public static void getCatalogForUser(){
        while (true) {
            allCatalog();
            System.out.println("0=>orqaga, Katalogdagi mahsulotlarni ko'rish uchun katalog tanlang(id bo'yicha)");
            int selectCatalog = numberScanner.nextInt();
            if (selectCatalog == 0) break;
            int counter = 0;
            if (products.size() > 0) {
                while (true) {
                    for (Product product : products) {
                        if (product.getCatalog_id() == selectCatalog) {
                            counter++;
                            System.out.println(product.getId()+" - "+product.getName()+", narxi: "+product.getPrice());
                        }
                    }
                    System.out.println("0=>orqaga, basketga qo'shish uchun mahsulot tanlang(id bo'yicha)");
                    int selectProduct = numberScanner.nextInt();
                    if (selectProduct == 0) break;
                    if (selectProduct > 0 && selectProduct <= counter) {
                        Basket basket = new Basket(currentUser.getId(), selectProduct);
                        Result result = basketService.create(basket);
                        if (result.isSuccess()) {
                            System.out.println(result.getMessage());
                        } else {
                            System.out.println(result.getMessage());
                        }
                        break;
                    } else {
                        System.out.println("Noto'g'ri buyruq kiritildi!");
                    }
                }
            } else {
                System.out.println("Xozircha mahsulot mavjud emas");
            }
        }
    }
    public static void userRegister(){
        UserDTO userDTO = new UserDTO();
        System.out.print("Ism familya kiriting: ");
        userDTO.setFullname(textScanner.nextLine());
        System.out.print("login kiriting: ");
        userDTO.setLogin(textScanner.nextLine());
        System.out.print("password kiriting: ");
        userDTO.setPassword(textScanner.nextLine());
        currentUser = userService.create(userDTO);
    }
    public static void userLogin(){
        System.out.print("login: ");
        String userLogin = textScanner.nextLine();
        System.out.print("password: ");
        String userPassword = textScanner.nextLine();
        currentUser = userService.getUser(userLogin, userPassword);
    }
    public static void adminLogin(){
        System.out.print("login: ");
        String adminLogin = textScanner.nextLine();
        System.out.print("password: ");
        String adminPassword = textScanner.nextLine();
        currentAdmin = userService.getUser(adminLogin, adminPassword);
    }
    public static void adminMenu(){
        while (true) {
            System.out.println("0=>chiqish, 1=>katalog qo'shish, 2=>mahsulot qo'shish");
            switch (numberScanner.nextInt()) {
                case 0: return;
                case 1:
                    addCatalog();
                    break;
                case 2:
                    addProduct();
                    break;
                default:
                    System.out.println("Noto'g'ri buyruq kiritildi!");
            }
        }
    }
    public static void addCatalog(){
        CatalogDTO catalogDTO = new CatalogDTO();
        System.out.print("Katalog nomini kiriting: ");
        catalogDTO.setName(textScanner.nextLine());
        Result result = catalogService.create(catalogDTO);
        if(result.isSuccess()){
            System.out.println(result.getMessage());
        }else{
            System.out.println(result.getMessage());
        }
    }
    public static void allCatalog(){
        for(Catalog catalog:catalogs){
            System.out.println(catalog.getId()+" - "+catalog.getName());
        }
    }
    public static void addProduct(){
        allCatalog();
        ProductDTO productDTO = new ProductDTO();
        System.out.println("Qaysi katalokga mahsulot qo'shmoqchisiz(id bo'yicha tanlang)");
        int id = numberScanner.nextInt();
        if(id>0&&id<= catalogs.size()){
            System.out.print("Mahsulot nomini kiriting: ");
            productDTO.setName(textScanner.nextLine());
            System.out.print("Mahsulot narxini kiriting: ");
            productDTO.setPrice(numberScanner.nextInt());
            productDTO.setCatalog_id(id);
            Result result = productService.create(productDTO);
            if(result.isSuccess()){
                System.out.println(result.getMessage());
            }else{
                System.out.println(result.getMessage());
            }
        }
    }
}
