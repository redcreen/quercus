package com.caucho.quercus;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User: chao.liuc
 * Date: 13-5-8
 * Time: ионГ10:43
 */
public class BindingTest extends QuercusBaseTest {

    @Test
    public void testEcho () {
        String php = "<?php echo $cdate->toString() ?>";
        Map<String, Object> contexts = new HashMap<String, Object>();
        contexts.put("cdate", new Date());
        String ret = evalString(php, contexts);

        System.out.println(ret);
    }
}
