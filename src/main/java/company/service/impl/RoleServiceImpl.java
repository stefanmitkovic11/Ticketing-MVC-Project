package company.service.impl;

import company.dto.RoleDTO;
import company.service.RoleService;

import java.util.List;


public class RoleServiceImpl extends AbstractMapService<RoleDTO,Long> implements RoleService {

    @Override
    public RoleDTO save(RoleDTO object) {
       return super.save(object.getId(),object);
    }

    @Override
    public RoleDTO findUserById(Long id) {
        return super.findUserById(id);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
