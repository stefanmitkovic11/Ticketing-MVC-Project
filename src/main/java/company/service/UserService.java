package company.service;


import company.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO, String> {
    List<UserDTO> findManagers();
}
