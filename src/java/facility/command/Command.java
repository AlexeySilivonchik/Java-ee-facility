package facility.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    public static final String ABOUT_PROJECT = "/jsp/aboutProject.jsp";
    
    public static final String PRODUCTION = "/jsp/production.jsp";
    public static final String ADD_PRODUCT = "/jsp/addProduct.jsp";  
    public static final String EDIT_PRODUCT = "/jsp/editProduct.jsp";
    
    public static final String MAIN_PAGE = "/jsp/main.jsp";
    
    public static final String WAREHOUSES = "/jsp/warehouses.jsp";
    public static final String ADD_WAREHOUSE = "/jsp/addWarehouse.jsp";
    public static final String EDIT_WAREHOUSE = "/jsp/editWarehouse.jsp";
    
    public static final String DISTRIBUTORS = "/jsp/distributors.jsp";   
    public static final String ADD_DISTRIBUTOR = "/jsp/addDistributor.jsp";
    public static final String EDIT_DISTRIBUTOR = "/jsp/editDistributor.jsp";
    
    public static final String LOGIN_REGISTER = "/jsp/loginAndRegister.jsp";
    
    public static final String SEARCH = "/jsp/search.jsp";
    public static final String SEARCH_DISTRIBUTOR = "/jsp/searchDistributor.jsp";
    public static final String SEARCH_WAREHOUSE = "/jsp/searchWarehouse.jsp";
    public static final String SEARCH_PRODUCTION = "/jsp/searchProduction.jsp";

    public String execute(HttpServletRequest request);
}
