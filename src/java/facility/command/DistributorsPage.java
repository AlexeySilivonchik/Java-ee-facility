package facility.command;

import facility.dao.mysql.MySQLDistributorDAO;
import facility.entity.Distributor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

class DistributorsPage implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        MySQLDistributorDAO dao = new MySQLDistributorDAO();
        List<Distributor> distributors = dao.listDistributors();
        request.setAttribute("distributors", distributors);      
        
        return DISTRIBUTORS;
    }
    
}
