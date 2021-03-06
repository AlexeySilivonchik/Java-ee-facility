package facility.command;

import facility.dao.mysql.MySQLDistributorDAO;
import facility.dao.mysql.MySQLProductionDAO;
import facility.dao.mysql.MySQLWarehouseDAO;
import facility.entity.Distributor;
import facility.entity.Production;
import facility.entity.Warehouse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

class EditProduct implements Command {

    private static int productionId;
    private static List<Distributor> listDistributor;
    private static List<Warehouse> listWarehouse;

    @Override
    public String execute(HttpServletRequest request) {

        String vers = request.getParameter("v");
        if (vers.equals("1")) {
            String id = request.getParameter("id");
            productionId = Integer.parseInt(id);
            MySQLProductionDAO dao = new MySQLProductionDAO();
            Production production = dao.getProduction(productionId);
            request.setAttribute("production", production);

            MySQLDistributorDAO dao2 = new MySQLDistributorDAO();
            if (listDistributor != null) {
                listDistributor.clear();
            }
            listDistributor = dao2.listDistributors();

            MySQLWarehouseDAO dao3 = new MySQLWarehouseDAO();
            if (listWarehouse != null) {
                listWarehouse.clear();
            }
            listWarehouse = dao3.listWarehouses();
            request.setAttribute("listDistributor", listDistributor);
            request.setAttribute("listWarehouse", listWarehouse);
        }
        if (vers.equals("2")) {
            MySQLProductionDAO dao = new MySQLProductionDAO();
            try {
                request.setCharacterEncoding("UTF-8");
                String name = request.getParameter("name");
                String retailPrice = request.getParameter("retail_price");
                String batchSize = request.getParameter("batch_size");
                String batchPrice = request.getParameter("batch_price");
                String amount = request.getParameter("amount");
                String warehouseId = request.getParameter("menu2");
                String distributorId = request.getParameter("menu");

                if (name != null && !name.isEmpty() && retailPrice != null
                        && !retailPrice.isEmpty() && batchSize != null && !batchSize.isEmpty()
                        && batchPrice != null && !batchPrice.isEmpty() && amount != null && !amount.isEmpty()
                        && warehouseId != null && !warehouseId.isEmpty() && distributorId != null && !distributorId.isEmpty()) {

                    int iretailPrice = Integer.parseInt(retailPrice);
                    int ibatchSize = Integer.parseInt(batchSize);
                    int ibatchPrice = Integer.parseInt(batchPrice);
                    int iamount = Integer.parseInt(amount);

                    String[] is = distributorId.split("\"");
                    int idistributorId = Integer.parseInt(is[0]);

                    String[] is2 = warehouseId.split("\"");
                    int iwarehouseId = Integer.parseInt(is2[0]);

                    dao.editProduction(productionId, name, iretailPrice, ibatchSize, ibatchPrice, iamount, iwarehouseId, idistributorId);

                    List<Production> production = dao.listProduction();
                    request.setAttribute("products", production);
                    return PRODUCTION;
                } else {
                    request.setAttribute("error", "Все поля формы обязательны для заполнения");
                    request.setAttribute("listDistributor", listDistributor);
                    request.setAttribute("listWarehouse", listWarehouse);
                    Production production = dao.getProduction(productionId);
                    request.setAttribute("production", production);
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Неверный ввод");
                request.setAttribute("listDistributor", listDistributor);
                request.setAttribute("listWarehouse", listWarehouse);
                Production production = dao.getProduction(productionId);
                request.setAttribute("production", production);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AddWarehouse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return EDIT_PRODUCT;
    }
}
