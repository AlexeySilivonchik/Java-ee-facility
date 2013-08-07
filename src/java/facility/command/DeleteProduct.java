package facility.command;

import facility.dao.mysql.MySQLProductionDAO;
import facility.entity.Production;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

class DeleteProduct implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        String id = request.getParameter("id");
        int productionId = Integer.parseInt(id);
        MySQLProductionDAO dao = new MySQLProductionDAO();
        dao.deleteProduction(productionId);

        List<Production> production = dao.listProduction();
        request.setAttribute("products", production); 
        
        return PRODUCTION;
    }
}
