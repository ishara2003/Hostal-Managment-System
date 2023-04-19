package lk.sankalpa.hms.service.custom;

import lk.sankalpa.hms.dao.custom.UserDao;
import lk.sankalpa.hms.dto.Userdto;
import lk.sankalpa.hms.service.SuperService;
import org.hibernate.Session;

import java.util.List;

public interface UserService extends SuperService {

    Userdto saveUser(Userdto userdto);

    Userdto searchUser(String NIC);

    List<Userdto>allUsers(Session session);


    Userdto updateUser(Userdto userdto);

}
