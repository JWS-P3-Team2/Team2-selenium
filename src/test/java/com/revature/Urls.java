package com.revature;

public abstract class Urls {
    // should pull base from env variable
    public static String base = "http://localhost:4200";
    public static String profile = base + "/userProfile";
    public static String login = base + "/login";
    public static String register = base + "/register";
    public static String editProducts = base + "/admin/products";
    public static String createProduct = base + "/admin/createproduct";
    public static String editProductBase = base + "/admin/product";
    public static String orders = base + "/orders";
}
