package com.caucho.quercus.statement;

import com.caucho.quercus.QuercusBaseTest;
import org.junit.Test;

/**
 * User: chao.liuc
 * Date: 13-5-8
 * Time: ионГ10:43
 */
public class ForStatementTest extends QuercusBaseTest {

    @Test
    public void test_php() {
        String path = "statement/for.php";
        assertFile(path);
    }
}
