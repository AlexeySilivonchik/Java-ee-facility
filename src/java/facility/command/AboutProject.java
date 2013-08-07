package facility.command;

import javax.servlet.http.HttpServletRequest;

class AboutProject implements Command {

    public AboutProject() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        return ABOUT_PROJECT;
    }
    
}
