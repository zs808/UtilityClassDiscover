package org.codediscover;


import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UtilityClassDiscoverTest {

    @Test
    public void analysisClassMethodDependencies() throws IOException {

        Map<String, List<String>> dependencies =  UtilityClassDiscover.analysisClassMethodDependencies(FileUtils.readFileToByteArray(new File(
                "G:\\GIT\\UtilityClassDiscover\\src\\test\\resources\\commons-io-2.2\\org\\apache\\commons\\io\\CopyUtils.class")));
        System.out.println(dependencies);
    }
}
