package facility.command;

import facility.dao.mysql.MySQLWarehouseDAO;
import facility.entity.Warehouse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

class AddWarehouse implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String vers = request.getParameter("v");
        if (vers.equals("1")) {
        }
        if (vers.equals("2")) {
            try {
                request.setCharacterEncoding("UTF-8");
                String name = request.getParameter("name");
                String category = request.getParameter("category");
                String area = request.getParameter("area");
                if (name != null && !name.isEmpty() && category != null && !category.isEmpty() && area != null && !area.isEmpty()) {
                    int iarea=Integer.parseInt(area);
                    MySQLWarehouseDAO dao = new MySQLWarehouseDAO();
                    dao.addWarehouse(name, category, iarea);
                    
                    List<Warehouse> warehouses = dao.listWarehouses();
                    request.setAttribute("warehouses", warehouses); 
                    return WAREHOUSES;
                } else {
                    request.setAttribute("error", "Все поля формы обязательны для заполнения");
                }
            }catch (NumberFormatException ex) {
                request.setAttribute("error", "Неверная площадь склада");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AddWarehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ADD_WAREHOUSE;
    }
}
