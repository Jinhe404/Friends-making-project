package com.partner.boot.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.partner.boot.common.Result;
import com.partner.boot.entity.User;
import com.partner.boot.service.IUserService;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 金同学
 * @since 2022-12-02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody User user){
        if (user.getId() == null){

        }else {

        }
        userService.saveOrUpdate(user);
        return Result.success();
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        userService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public  Result deleteBatch(@RequestBody List<Integer> ids){
        userService.removeByIds(ids);
        return Result.success();
    }
    @GetMapping
    public Result findAll(){
        return  Result.success(userService.list());
    }
    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id){
        return Result.success(userService.getById(id));
    }
    @GetMapping("/page")
    public Result findPage(@RequestParam(defaultValue = "") String name,
                           @RequestParam Integer pageNum,
                           @RequestParam Integer pageSize){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().orderByDesc("id");
        queryWrapper.like(!"".equals(name),"name",name);
        return Result.success(userService.page((new Page<>(pageNum,pageSize),queryWrapper)))
    }

    /*
    * 导出接口
    * */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception{
        // 从数据库查询所有的数据
        List<User> list = userService.list()
         // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性list内的对象到excel,使用默认样式，强制输出标题
        writer.write(list,true);
    }
    // 设置浏览器响应的格式






}
