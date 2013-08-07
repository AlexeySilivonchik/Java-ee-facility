package facility.command;

import facility.dao.mysql.MySQLDistributorDAO;
import facility.dao.mysql.MySQLProductionDAO;
import facility.dao.mysql.MySQLWarehouseDAO;
import facility.entity.Distributor;
import facility.entity.Production;
import facility.entity.Warehouse;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

class SearchPage implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String vers = request.getParameter("v");
        if (vers.equals("1")) {
        }
        if (vers.equals("2")) {
            return SEARCH_PRODUCTION;
        }
        if (vers.equals("3")) {
            return SEARCH_DISTRIBUTOR;
        }
        if (vers.equals("4")) {
            return SEARCH_WAREHOUSE;
        }
        if (vers.equals("5")) {
            try {
                request.setCharacterEncoding("UTF-8");
                String name = request.getParameter("name");
                MySQLDistributorDAO dao = new MySQLDistributorDAO();
                if (name != null && !name.isEmpty()) {
                    Distributor distributor = dao.getByName(name);
                    request.setAttribute("distributor",distributor);
                    return SEARCH_DISTRIBUTOR;
                } else {
                    request.setAttribute("error", "Все поля формы обязательны для заполнения");
                    return SEARCH_DISTRIBUTOR;
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(SearchPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (vers.equals("6")) {
            try {
                request.setCharacterEncoding("UTF-8");
                String name = request.getParameter("name");
                MySQLWarehouseDAO dao = new MySQLWarehouseDAO();
                if (name != null && !name.isEmpty()) {
                    Warehouse warehouse = dao.getByName(name);
                    request.setAttribute("warehouse",warehouse);
                    return SEARCH_WAREHOUSE;
                } else {
                    request.setAttribute("error", "Все поля формы обязательны для заполнения");
                    return SEARCH_WAREHOUSE;
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(SearchPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (vers.equals("7")) {
            try {
                request.setCharacterEncoding("UTF-8");
                String name = request.getParameter("name");
                MySQLProductionDAO dao = new MySQLProductionDAO();
                if (name != null && !name.isEmpty()) {
                    Production production = dao.getByName(name);
                    request.setAttribute("production",production);
                    return SEARCH_PRODUCTION;
                } else {
                    request.setAttribute("error", "Все поля формы обязательны для заполнения");
                    return SEARCH_PRODUCTION;
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(SearchPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return SEARCH;
    }
}
