package company.service;

import company.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO user);
    UserDTO findUserById(String username);
    List<UserDTO> findAll();
    void delete(UserDTO user);
    void deleteById(String username);
}
