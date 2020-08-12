package edu.cuit.loop.titlejudge.service;

import edu.cuit.loop.titlejudge.entity.Module;
import edu.cuit.loop.titlejudge.mapper.ModuleMapper;
import edu.cuit.loop.titlejudge.utils.CommonUtils;
import edu.cuit.loop.titlejudge.utils.ModelTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}10:23
 */
@Service
@Transactional
public class ModuleService {
    @Autowired
    ModuleMapper moduleMapper;

    public boolean addModule(Module module){
        if ((module.getModulename()!=null&&!module.getModulename().equals(""))
                &&(module.getModulestatus()!=null&&!module.getModulestatus().equals(""))
                &&(module.getModuleurl()!=null&&!module.getModuleurl().equals(""))){
            Integer maxSort = moduleMapper.getMaxSort(module.getParentmoduleid());//得到同级中的最大排序数
            if (module.getParentmoduleid().equals("0")){
                module.setModulecomponet("Layout");
            }
            module.setModuleid(CommonUtils.getUUID());
            if (maxSort==null) {
                module.setModuleordernum(1);
            }else {
                module.setModuleordernum(maxSort+1);
            }
            moduleMapper.insertSelective(module);
            return true;
        }else {
            return false;
        }
    }

    public boolean updateModule(Module module){
        if ((module.getModulename()!=null&&!module.getModulename().equals(""))
                &&(module.getModulestatus()!=null&&!module.getModulestatus().equals(""))
                &&(module.getModulecomponet()!=null&&!module.getModulecomponet().equals(""))
                &&(module.getModuleurl()!=null&&!module.getModuleurl().equals(""))) {
            moduleMapper.updateByPrimaryKeySelective(module);
            return true;
        }else {
            return false;
        }
    }

    public void deleteModule(String id){
        moduleMapper.deleteByPrimaryKey(id);
    }

    public List<Module> selectByName(String name){
        return moduleMapper.selectByName(name);
    }

    public List getModuleTree(){
        List<Module> modules = moduleMapper.selectAlls();
        ModelTreeUtil modelTreeUtil = new ModelTreeUtil();
        return modelTreeUtil.menuList(modules);
    }

    public List<Module> selectByParent(String partenid){
        return moduleMapper.selectByParent(partenid);
    }

    public Module selectByID(String id){
        return moduleMapper.selectByPrimaryKey(id);
    }

}
