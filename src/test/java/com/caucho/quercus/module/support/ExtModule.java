package com.caucho.quercus.module.support;

import com.caucho.quercus.env.Env;
import com.caucho.quercus.module.AbstractQuercusModule;

import javax.servlet.http.HttpServletRequest;

/**
 * User: chao.liuc
 * Date: 13-5-8
 * Time: обнГ12:13
 */
public class ExtModule extends AbstractQuercusModule {
    public static String  fun_ext (Env env, String in) {
        HttpServletRequest request = env.getRequest();
        return "ext:" + in;
    }
}
