package org.myhnuhai.core;

import org.myhnuhai.domain.User;

import java.io.Serializable;
import java.util.*;

public class UserSession implements Serializable{

	private static final long serialVersionUID = 7089581925813056601L;
	private String username;
	private String userid;
	private String password;
	
	private User user;

    public UserSession(String username, String userid, String password, User user) {
        this.username = username;
        this.userid = userid;
        this.password = password;
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
