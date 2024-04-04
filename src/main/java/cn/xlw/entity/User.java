package cn.xlw.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by xlw on 2024/4/4 13:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {


    private Integer id;
    private String username;
    private String password;
    private Integer status;

}
