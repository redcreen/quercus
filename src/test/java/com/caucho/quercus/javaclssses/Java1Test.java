package com.caucho.quercus.javaclssses;

import com.caucho.quercus.QuercusBaseTest;
import org.junit.Test;

/**
 * User: chao.liuc
 * Date: 13-5-8
 * Time: ионГ10:43
 */
public class Java1Test extends QuercusBaseTest {

    @Test
    public void test_php() {
        String path = "javaclasses/java1.php";
        String ret = evalFile(path) ;
        System.out.println(ret);
    }
}
