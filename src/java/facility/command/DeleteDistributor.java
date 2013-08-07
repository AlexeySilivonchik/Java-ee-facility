package facility.command;

import facility.dao.mysql.MySQLDistributorDAO;
import facility.entity.Distributor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

class DeleteDistributor implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("id");
        int distibutorId = Integer.parseInt(id);
        MySQLDistributorDAO dao = new MySQLDistributorDAO();
        dao.deleteDistributor(distibutorId);
        
        List<Distributor> distributors = dao.listDistributors();
        request.setAttribute("distributors", distributors); 
        return DISTRIBUTORS;
    }
    
}
