package com.caucho.quercus.module.support;

import com.caucho.quercus.module.AbstractQuercusModule;

/**
 * User: chao.liuc
 * Date: 13-5-8
 * Time: обнГ12:13
 */
public class ExtModule extends AbstractQuercusModule {
    public static String  fun_ext (String in) {
        return "ext:" + in;
    }
}
