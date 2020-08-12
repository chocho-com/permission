package edu.cuit.loop.titlejudge.utils;

import edu.cuit.loop.titlejudge.entity.Module;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}21:12
 */
public class AuthTree {
    public static Map<String,Object> mapArray = new LinkedHashMap<>();
    public List<Module> menuCommon;
    public List<Object> list = new ArrayList<Object>();

    public  List<Object> menuList(List<Module> menu){
        if (menu == null){
            return new ArrayList<>();
        }
        this.menuCommon = menu;
        for (Module module:menu){
            Map<String,Object> mapArr = new LinkedHashMap<>();
            if (module.getParentmoduleid().trim().equals("0")){
                mapArr.put("path",module.getModuleurl());
                mapArr.put("component",module.getModulecomponet());
                mapArr.put("name",module.getName());
                mapArr.put("redirect",module.getRedirect());
                mapArr.put("child",menuChild(module.getModuleid()));
                list.add(mapArr);
            }
        }
        return list;
    }

    public List menuChild(String code){
        List<Object> lists = new ArrayList<Object>();
        //子集查询遍历
        for (Module module:menuCommon){
            Map<String,Object> childArray = new LinkedHashMap<String,Object>();
            if (module.getParentmoduleid().equals(code)){     //如果有子节点ID = 父节点ID
                childArray.put("path",module.getModuleurl());
                childArray.put("component",module.getModulecomponet());
                childArray.put("name",module.getName());
                lists.add(childArray);
            }
        }
        return lists;
    }
}
