package qqcommon;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/30 16:40
 * 表示一个用户信息
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userId;
    private String passwd;

    public User() {
    }

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
