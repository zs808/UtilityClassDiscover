package org.codediscover;


import org.apache.commons.io.FileUtils;
import org.codediscover.bean.ClassMethodDeclareBean;
import org.codediscover.bean.MethodInsnDeclareBean;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UtilityClassDiscoverTest {

    @Test
    public void analysisClassMethodDependencies() throws IOException {

        Map<ClassMethodDeclareBean, Set<MethodInsnDeclareBean>> dependencies = UtilityClassDiscover.analysisClassMethodDependencies(FileUtils.readFileToByteArray(new File(
                "G:\\GIT\\UtilityClassDiscover\\src\\test\\resources\\commons-io-2.6\\org\\apache\\commons\\io\\CopyUtils.class")));
        System.out.println(dependencies);
    }
}
