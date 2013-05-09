package com.caucho.quercus.lib.db;

import com.caucho.quercus.QuercusBaseTest;
import org.junit.Test;

/**
 * User: chao.liuc
 * Date: 13-5-8
 * Time: ионГ10:43
 */
public class PDOTest1 extends QuercusBaseTest {

    @Test
    public void test_php() {
        String path = "lib/db/pdo1.php";
        String ret = evalFile(path) ;
        System.out.println(ret);
    }
}
