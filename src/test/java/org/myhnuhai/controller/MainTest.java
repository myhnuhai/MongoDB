package org.myhnuhai.controller;

import org.junit.Test;
import org.myhnuhai.domain.User;

/**
 * Created by Administrator on 11-3-28.
 */
public class MainTest {

    @Test
    public void TestBean(){
        User u = new User();
        u.setId("myhnuhai");
        System.out.println(u.getClass().getName());
    }
}
