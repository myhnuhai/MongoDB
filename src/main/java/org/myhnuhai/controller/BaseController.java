package org.myhnuhai.controller;

import org.myhnuhai.core.DefaultCustomDateEditor;
import org.myhnuhai.core.UserSession;
import org.myhnuhai.util.JsonUtil;
import org.myhnuhai.util.StringUtil;
import org.myhnuhai.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 14-1-16.
 */
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

    protected final Result result = new Result();

    protected void addAttr(String attr, Object value) {
        result.getMap().put(attr, value);
    }

    protected Object getSessionAttr(String attr) {
        HttpSession session = request.getSession();
        return session.getAttribute(attr);
    }

    protected UserSession getUserSession() {
        return (UserSession) getSessionAttr("userSession");
    }

    protected void setSessionAttr(String attrName, Object attr) {
        request.getSession().setAttribute(attrName, attr);
    }

    protected void clearSession() {
        request.getSession().invalidate();
    }

    public String getPara(String paraName){
        return request.getParameter(paraName);
    }

    public int getParaToInt(String paraName){
        String v = request.getParameter(paraName);
        if(StringUtil.isNotNull(v))
            return Integer.valueOf(request.getParameter(paraName));
        else
            return 0;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new DefaultCustomDateEditor(
                dateFormat, true));
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public String exception(Exception e){
        e.printStackTrace();
        addAttr("success", false);
        return JsonUtil.bean2Json(result);
    }
}
