package controller.jsp.mvc;

import java.util.List;
import controller.jsp.mvc.UserModel;

public interface UserService {
public String insertUser(UserModel um);
 public List<UserModel> ViewUser();
public UserModel viewOneUser(Integer id);
public String updateUser(UserModel um);
public String deleteUser(UserModel um);

}
