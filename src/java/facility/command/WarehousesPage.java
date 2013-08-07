package facility.command;

import facility.dao.mysql.MySQLWarehouseDAO;
import facility.entity.Warehouse;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

class WarehousesPage implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        MySQLWarehouseDAO dao = new MySQLWarehouseDAO();
        List<Warehouse> warehouses = dao.listWarehouses();
        request.setAttribute("warehouses", warehouses);      
        
        return WAREHOUSES;
    }
    
}
