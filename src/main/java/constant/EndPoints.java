package constant;

public class EndPoints {

    public static final String GET_ALL_USERS = "/users";
    public static final String GET_USER = "/users/{id}";
    public static final String GET_ALL_DRESSES = "/dresses";
    public static final String GET_DRESS = "/dresses/{id}";
    public static final String ADD_USER = "/users";
    public static final String ADD_DRESS = "/dresses";
    public static final String UPDATE_USER = "/users/{id}";
    public static final String UPDATE_DRESS = "/dresses/{id}";
    public static final String DELETE_USER = "/users/{id}";
    public static final String DELETE_DRESS = "/dresses/{id}";

    public static final String CART_PAGE = "?controller=order";
    public static final String DRESSES_PAGE = "?id_category=8&controller=category";
    public static final String LOGIN_PAGE = "?controller=authentication&back=my-account";
    public static final String CONTACT_PAGE = "?controller=contact";
    public static final String ITEM_PAGE = "?id_product=5&controller=product";


}
