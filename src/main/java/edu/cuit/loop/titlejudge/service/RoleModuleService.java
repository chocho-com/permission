package edu.cuit.loop.titlejudge.service;

import edu.cuit.loop.titlejudge.entity.Rolemodule;
import edu.cuit.loop.titlejudge.mapper.RolemoduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}10:26
 */
@Service
@Transactional
public class RoleModuleService {
    @Autowired
    RolemoduleMapper rolemoduleMapper;

    public void insertForeach(List<Rolemodule> list){
        rolemoduleMapper.insertForeach(list);
    }

    public List<String> selectByRoles(String roleid){
        return rolemoduleMapper.selectByRoles(roleid);
    }
}
