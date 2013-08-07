package facility.command;

import facility.dao.mysql.MySQLWarehouseDAO;
import facility.entity.Warehouse;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


class DeleteWarehouse implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("id");
        int warehouseId = Integer.parseInt(id);
        MySQLWarehouseDAO dao = new MySQLWarehouseDAO();
        dao.deleteWarehouse(warehouseId);
        
        List<Warehouse> warehouses = dao.listWarehouses();
        request.setAttribute("warehouses", warehouses); 
        return WAREHOUSES;
    }

}
