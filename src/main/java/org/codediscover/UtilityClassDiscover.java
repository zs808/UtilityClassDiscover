package org.codediscover;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.objectweb.asm.Opcodes.ASM6;

public class UtilityClassDiscover {

    public static Map<String, List<String>> analysisClassMethodDependencies(byte[] classContent) {
        ClassReader classReader = new ClassReader(classContent);
        final Map<String, List<String>> dependencies = new HashMap<String, List<String>>();
        classReader.accept(new ClassVisitor(ASM6) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                String methodKey = desc + "#" + name;
                final List<String> finalCurrentMethodDependencies = dependencies.computeIfAbsent(methodKey, k -> new ArrayList<String>());
                return new MethodVisitor(Opcodes.ASM6) {
                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                        finalCurrentMethodDependencies.add(desc + "#" + name);
                    }
                };
            }
        }, 0);

        return dependencies;
    }

}
