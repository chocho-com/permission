package edu.cuit.loop.titlejudge.service;

import edu.cuit.loop.titlejudge.entity.Userrole;
import edu.cuit.loop.titlejudge.mapper.UserroleMapper;
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
public class UserRoleService {
    @Autowired
    UserroleMapper userroleMapper;

    public void deleteByUserID(String userid){
        userroleMapper.deleteByUserID(userid);
    }

    public void addList(List<Userrole> userroles){
        userroleMapper.insertForeach(userroles);
    }
}
