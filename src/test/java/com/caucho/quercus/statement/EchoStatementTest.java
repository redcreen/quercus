package com.caucho.quercus.statement;

import com.caucho.quercus.QuercusBaseTest;
import org.junit.Test;

/**
 * User: chao.liuc
 * Date: 13-5-8
 * Time: ионГ10:43
 */
public class EchoStatementTest extends QuercusBaseTest {

    @Test
    public void testEcho_php() {
        String path = "statement/echo.php";
        assertFile(path);
    }
}
