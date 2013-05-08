package com.caucho.quercus;

import com.caucho.quercus.env.Env;
import com.caucho.quercus.page.InterpretedPage;
import com.caucho.quercus.parser.QuercusParser;
import com.caucho.quercus.program.QuercusProgram;
import com.caucho.vfs.Path;
import com.caucho.vfs.Vfs;
import com.caucho.vfs.WriteStream;
import junit.framework.Assert;
import org.junit.Before;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.SimpleBindings;
import javax.script.SimpleScriptContext;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Map;

import static org.junit.Assert.fail;

/**
 * User: chao.liuc
 * Date: 13-5-8
 * Time: ÉÏÎç10:11
 */
public abstract class QuercusBaseTest {
    protected Quercus quercus;
    protected Env env;
    protected int timeout;
    protected Path path;
    protected String encode = "GBK";

    @Before
    public void setUp() throws Exception {
        quercus = new Quercus();
        if (timeout >0) {
            quercus.setIni("max_execution_time", String.valueOf(timeout));
        }
        quercus.setUnicodeSemantics(true);
        quercus.init();
        quercus.start();
    }

    protected String eval(InputStream in, Map<String, Object> context)  {
        try {
            QuercusProgram program = QuercusParser.parse(quercus, path, Vfs.openRead(new InputStreamReader(in, encode)));
            Writer writer = new StringWriter();
            WriteStream writerStream = Vfs.openWrite(writer) ;
            writerStream.setEncoding(encode);
            env = new Env(quercus, new InterpretedPage(program), writerStream, null, null);
            SimpleScriptContext simpleScriptContext = new SimpleScriptContext();
            Bindings bindings = new SimpleBindings();
            if (context != null ) {
                for (Map.Entry<String, Object> entry : context.entrySet()) {
                    bindings.put(entry.getKey(), entry.getValue());
                }
            }
            simpleScriptContext.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
            env.setScriptContext(simpleScriptContext);
            program.execute(env);
            writerStream.flushBuffer();
            writerStream.free();
            return writer.toString();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String eval(InputStream in) {
        return eval(in, null) ;
    }

    protected String evalString(String php) {
        try {
            return eval(new ByteArrayInputStream(php.getBytes(encode)), null) ;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    protected String evalFile(String path, Map<String, Object> context) {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(path);
        return eval(in, context);
    }

    protected String evalFile(String path) {
        return evalFile(path, null) ;
    }

    protected void assertFile(String path) {
        String expacted = executeFile(path) ;
        expacted = expacted.replaceAll("\r\n", "\n");
        String real = evalFile(path);
        real = real.replaceAll("\r\n", "\n") + "\n";
        Assert.assertEquals(expacted, real);
    }

    private String executeFile(String path) {
        File testFile = null;
        try {
            testFile = new File(this.getClass().getClassLoader().getResource(path).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            fail();

        }
        String cmd = "php " + testFile.getAbsolutePath();
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            throw new IllegalStateException("please check php in path env", e);
        }
        try {
            process.getOutputStream().close();
            process.getErrorStream().close();
            BufferedReader ir =new BufferedReader(new InputStreamReader(process.getInputStream())) ;
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = ir.readLine()) != null) {
                sb.append(line).append("\n");
            }
            process.waitFor();
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e) ;
        }
    }

}
