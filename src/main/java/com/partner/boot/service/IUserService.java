package com.partner.boot.service;

import com.partner.boot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 金同学
 * @since 2023-02-02
 */
public interface IUserService extends IService<User> {
    User login(User user);

    User register(User user);
}
