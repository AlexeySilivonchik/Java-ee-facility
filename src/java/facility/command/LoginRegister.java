package facility.command;

import facility.dao.mysql.MySQLUserDAO;
import facility.entity.User;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

class LoginRegister implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String vers = request.getParameter("v");
        if (vers.equals("1")) {
        }
        if (vers.equals("2")) {
            try {
                MySQLUserDAO dao = new MySQLUserDAO();
                request.setCharacterEncoding("UTF-8");
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                User user = dao.getUser(login, password);
                if (user == null) {
                    request.setAttribute("error", "   Неверное имя пользователя или пароль");
                } else {
                    return MAIN_PAGE;
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(LoginRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (vers.equals("3")) {
            try {
                MySQLUserDAO dao = new MySQLUserDAO();
                request.setCharacterEncoding("UTF-8");
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                
                if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
                    dao.addUser(login, password);
                } else {
                    request.setAttribute("error", "Все поля формы обязательны для заполнения");
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(LoginRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return LOGIN_REGISTER;
    }
}
