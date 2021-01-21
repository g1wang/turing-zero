package com.stars.userdataservice.dao;

import com.stars.userdataservice.domain.User;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * 批操作
 */
public class UserProvider {

    /**
     * 批量插入
     * @param map
     * @return
     */
    public String insertUsers(Map<String,List<User>> map) {
        List<User> list = map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into user_info ");
        sb.append("(user_id,username,mail,phone) ");
        sb.append("values ");
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].userID},#'{'list[{0}].username},#'{'list[{0}].mail},#'{'list[{0}].phone})");
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }



}
