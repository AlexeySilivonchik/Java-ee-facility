package facility.command;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class CommandChooser {

    private static CommandChooser instance = null;
    Map<String, Command> commands = new HashMap<String, Command>();

    private CommandChooser() {
        commands.put("aboutProject", new AboutProject());
        commands.put("mainPage", new MainPage());
        
        commands.put("addWarehouse", new AddWarehouse());
        commands.put("deleteWarehouse", new DeleteWarehouse());
        commands.put("editWarehouse", new EditWarehouse());
        commands.put("warehouses", new WarehousesPage());
        
        commands.put("production", new ProductionPage());
        commands.put("addProduct", new AddProduct());
        commands.put("deleteProduct", new DeleteProduct());
        commands.put("editProduct", new EditProduct());
        
        commands.put("addDistributor", new AddDistributor());
        commands.put("distributors", new DistributorsPage());
        commands.put("deleteDistributor", new DeleteDistributor());
        commands.put("editDistributor", new EditDistributor());
        
        commands.put("loginRegister", new LoginRegister());
        
        commands.put("search", new SearchPage());
    }

    public Command getCommand(HttpServletRequest request) {
        
        String action = request.getParameter("command");
        Command command = commands.get(action);
        /*if (command == null) {
            command = new NoCommand();
        }*/
        return command;
    }
    
    public static CommandChooser getInstance() {
        if (instance == null) {
            instance = new CommandChooser();
        }
        return instance;
    }
}
