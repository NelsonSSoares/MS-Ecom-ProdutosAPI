package nelsonssoares.ecomproductsapi.commons.constants;

public class ControllersConstants {
    // API INFO
    public static final String API_TAG = "Ecommerce - Products API";
    public static final String API_DESCRIPTION = "API para gerenciamento de produtos do ecommerce";
    public static final String API_PRODUCES = "application/json";
    public static final String API_SECURITY_REQUIREMENT = "bearer-key";
    public static final String API_BASE_URL = "ecommerce/produtos";


    // CATEGORY ENDPOINTS
    public static final String API_TAG_CATEGORY = "Ecommerce - Categoria API";
    public static final String CATEGORY = API_BASE_URL + "/categoria";
    public static final String CATEGORY_ID = "/{id}";

    // SUBCATEGORY ENDPOINTS
    public static final String API_TAG_SUBCATEGORY = "Ecommerce - Subcategoria API";
    public static final String SUBCATEGORY = API_BASE_URL + "/subcategoria";
    public static final String SUBCATEGORY_ID = "/{id}";

    // PRODUCT ENDPOINTS
    public static final String ID = "/{id}";
    public static final String NAME = "name/{name}";
}
