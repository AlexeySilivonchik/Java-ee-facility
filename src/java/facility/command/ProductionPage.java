package facility.command;

import facility.dao.mysql.MySQLProductionDAO;
import facility.entity.Production;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

class ProductionPage implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        MySQLProductionDAO dao = new MySQLProductionDAO();
        List<Production> production = dao.listProduction();
        request.setAttribute("products", production); 
        
        return PRODUCTION;
    }
}
