package facility.command;

import facility.dao.mysql.MySQLWarehouseDAO;
import facility.entity.Warehouse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

class EditWarehouse implements Command {

    private static int warehouseId;

    @Override
    public String execute(HttpServletRequest request) {

        String vers = request.getParameter("v");
        if (vers.equals("1")) {
            String id = request.getParameter("id");
            warehouseId = Integer.parseInt(id);
            MySQLWarehouseDAO dao = new MySQLWarehouseDAO();
            Warehouse warehouse = dao.getWarehouse(warehouseId);
            request.setAttribute("warehouse", warehouse);
        }
        if (vers.equals("2")) {
            MySQLWarehouseDAO dao = new MySQLWarehouseDAO();
            try {
                request.setCharacterEncoding("UTF-8");
                String name = request.getParameter("name");
                String category = request.getParameter("category");
                String area = request.getParameter("area");
                
                if (name != null && !name.isEmpty() && category != null && !category.isEmpty() && area != null && !area.isEmpty()) {
                    int iarea = Integer.parseInt(area);
                    dao.editWarehouse(warehouseId,name, category, iarea);

                    List<Warehouse> warehouses = dao.listWarehouses();
                    request.setAttribute("warehouses", warehouses);
                    return WAREHOUSES;
                } else {
                    request.setAttribute("error", "Все поля формы обязательны для заполнения");
                    Warehouse warehouse = dao.getWarehouse(warehouseId);
                    request.setAttribute("warehouse", warehouse);
                }
            } catch (NumberFormatException ex) {
                request.setAttribute("error", "Неверная площадь склада");
                Warehouse warehouse = dao.getWarehouse(warehouseId);
                request.setAttribute("warehouse", warehouse);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AddWarehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return EDIT_WAREHOUSE;
    }
}
