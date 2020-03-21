package Controller;

import model.DAO.GestoreUtenzaDAO;
public class LoginController {
	
		public String login(String username,String password) {
			return new GestoreUtenzaDAO().login(username, password);
		}		
}
