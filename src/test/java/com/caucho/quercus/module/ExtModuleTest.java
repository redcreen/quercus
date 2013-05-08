package com.caucho.quercus.module;

import com.caucho.quercus.QuercusBaseTest;
import junit.framework.Assert;
import org.junit.Test;

/**
 * User: chao.liuc
 * Date: 13-5-8
 * Time: обнГ12:14
 */
public class ExtModuleTest extends QuercusBaseTest{

    @Test
    public void testExtModule() {
        String ret = evalFile("module/ext.php");
        Assert.assertEquals("ext:hi", ret);
    }
}
