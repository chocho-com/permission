package edu.cuit.loop.titlejudge.controller;

import edu.cuit.loop.titlejudge.vo.UserWithRole;
import edu.cuit.loop.titlejudge.entity.Users;
import edu.cuit.loop.titlejudge.service.UserService;
import edu.cuit.loop.titlejudge.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

/**
 * @author VX5
 * @Title: MJC
 * @ProjectName titlejudge
 * @Description: TODO
 * @date ${DAT}10:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 模糊查询
     * @param map
     * @return
     * @throws Exception
     */
    @PostMapping("/get")
    public Msg selectByLike(@RequestBody Map<String,Object> map) throws Exception{
        return Msg.success().add("msg",userService.selectByLike(map));
    }

    /**
     * 添加用户
     * @param userWithRole
     * @return
     * @throws Exception
     */
    @PostMapping
    public Msg addUser(@RequestBody UserWithRole userWithRole) throws Exception{
        if (userService.addUser(userWithRole,userWithRole.getRoles())) {
            return Msg.success().add("msg", "添加成功");
        }else {
            return Msg.fail().add("msg","用户已存在");
        }
    }

    /**
     * 修改用户
     * @param userWithRole
     * @return
     * @throws Exception
     */
    @PutMapping
    public Msg updateUser(@RequestBody UserWithRole userWithRole) throws Exception{
        if (userService.selectById(userWithRole.getUserid())!=null) {
            userService.updateUser(userWithRole,userWithRole.getRoles());
            return Msg.success().add("msg","更新成功");
        }else {
            return Msg.fail().add("msg","更新失败");
        }
    }


    /**
     * 删除用户
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping
    public Msg deleteUser(@RequestParam String id)throws Exception{
        userService.deleteUser(id);
        return Msg.success().add("msg","删除成功");
    }


    /**
     * 用户修改密码
     * @param map
     * @return
     */
    @PutMapping("/password")
    public Msg updatePassword(@RequestBody Map<String,String> map){
       if (userService.updatePassword(map)){
           return Msg.success().add("msg","修改成功");
       }else {
           return Msg.fail().add("msg","修改失败");
       }
    }


    /**
     * **@param id
     * @return
     */
    @GetMapping("/get")
    public Msg selectByID(@RequestParam String id){
        return Msg.success().add("msg",userService.selectById(id));
    }
}
