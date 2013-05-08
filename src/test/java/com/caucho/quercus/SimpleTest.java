package com.caucho.quercus;

import junit.framework.Assert;
import org.junit.Test;

/**
 * User: chao.liuc
 * Date: 13-5-8
 * Time: ионГ10:43
 */
public class SimpleTest extends QuercusBaseTest {

    @Test
    public void testEcho () {
        String php = "<?php echo 'hello' ?>";
        Assert.assertEquals("hello", evalString(php));
    }

    @Test
    public void testEchoStatement() {
        String path = "statement/echo.php";
        String ret = evalFile(path);
        Assert.assertEquals("hello", ret);
    }
}
