package company.service.impl;

import company.dto.UserDTO;
import company.service.UserService;

import java.util.List;


public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {
    @Override
    public UserDTO save(UserDTO object) {
        super.save(object.getUserName(),object);
        return object;
    }

    @Override
    public UserDTO findUserById(String id) {
        return super.findUserById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }
}
