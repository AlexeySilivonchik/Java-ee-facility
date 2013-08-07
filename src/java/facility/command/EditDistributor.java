package facility.command;

import facility.dao.mysql.MySQLDistributorDAO;
import facility.entity.Distributor;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

class EditDistributor implements Command {

    private static int distributorId;

    @Override
    public String execute(HttpServletRequest request) {

        String vers = request.getParameter("v");
        if (vers.equals("1")) {
            String id = request.getParameter("id");
            distributorId = Integer.parseInt(id);
            MySQLDistributorDAO dao = new MySQLDistributorDAO();
            Distributor distributor = dao.getDistributor(distributorId);
            request.setAttribute("distributor", distributor);
        }
        if (vers.equals("2")) {
            MySQLDistributorDAO dao = new MySQLDistributorDAO();
            try {
                request.setCharacterEncoding("UTF-8");
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                
                if (name != null && !name.isEmpty() && address != null && !address.isEmpty()) {
                    dao.editDistributor(distributorId,name, address);

                    List<Distributor> distributors = dao.listDistributors();
                    request.setAttribute("distributors", distributors);
                    return DISTRIBUTORS;
                } else {
                    request.setAttribute("error", "Все поля формы обязательны для заполнения");
                    Distributor distributor = dao.getDistributor(distributorId);
                    request.setAttribute("distributor", distributor);
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AddWarehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return EDIT_DISTRIBUTOR;
    }
    
}
