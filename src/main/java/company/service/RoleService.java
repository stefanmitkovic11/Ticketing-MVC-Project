package company.service;

import company.dto.RoleDTO;

import java.util.List;

public interface RoleService {

//    save, findById, delete, findAll
    RoleDTO save(RoleDTO role);
    RoleDTO findById(Long id);
    List<RoleDTO> findAll();
    void delete(RoleDTO role);
    void deleteById(Long id);

}
