package facility.command;

import javax.servlet.http.HttpServletRequest;

class MainPage implements Command {

    public MainPage() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        return MAIN_PAGE;
    }
    
}
