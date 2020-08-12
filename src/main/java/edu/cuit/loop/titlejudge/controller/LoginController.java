package edu.cuit.loop.titlejudge.controller;

import edu.cuit.loop.titlejudge.entity.Module;
import edu.cuit.loop.titlejudge.entity.Users;
import edu.cuit.loop.titlejudge.service.ModuleService;
import edu.cuit.loop.titlejudge.service.RoleModuleService;
import edu.cuit.loop.titlejudge.service.UserService;
import edu.cuit.loop.titlejudge.utils.AuthTree;
import edu.cuit.loop.titlejudge.utils.BaseUtils;
import edu.cuit.loop.titlejudge.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}17:48
 */
@RestController
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    RoleModuleService roleModuleService;
    @Autowired
    ModuleService moduleService;

    @PostMapping
    public Msg verifyLogin(@RequestBody Map<String,Object> map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        if((username != null && !"".equals(username)) &&
                password != null && !"".equals(password)){
                Users users = userService.selectByUserName(username);
                if (BaseUtils.convertBase(users.getUserpassword().trim()).equals(password)){
                    if (users.getUserstatus().equals("1")) {
                        return Msg.success().add("msg", userService.selectById(users.getUserid()));
                    }else {
                        return Msg.fail().add("msg","用户已被禁用，请联系管理员");
                    }
                }else {
                    return Msg.fail().add("msg","账户或密码错误");
                }
        }
        return Msg.fail().add("msg", "账户或密码错误");
    }

    //得到动态权限
    @GetMapping("/menu")
    public Msg getMenuByLogin(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String token = request.getHeader("token");
        String loginPhone = BaseUtils.convertBase(token);
        if (loginPhone == null||loginPhone.equals("")){
            return Msg.fail().add("msg","用户信息出现异常");
        }
        //根据用户名先得到对应的角色ID
        List<String> roleids = userService.getRolesByLoginPhone(loginPhone);
        //最终的模块列表
        List<Module> modules = new ArrayList<>();
        List<String> moduleids = new ArrayList<>();
        for (String roleid:roleids){
            List<String> modules1 = roleModuleService.selectByRoles(roleid);
            for (String module:modules1){
                moduleids.add(module);
            }
        }
        Set<String> set = new HashSet<>();
        List<String> newList = new ArrayList<>();
        for (String list:moduleids){
            if (set.add(list)){
                newList.add(list);
            }
        }
        moduleids.clear();
        moduleids.addAll(newList);
        for (String moduleid:moduleids){
            Module module = moduleService.selectByID(moduleid);
            modules.add(module);
        }
        AuthTree authTree = new AuthTree();

        return Msg.success().add("msg",authTree.menuList(modules));
    }

}
