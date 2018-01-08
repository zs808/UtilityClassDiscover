package org.codediscover;

import org.codediscover.bean.ClassMethodDeclareBean;
import org.codediscover.bean.MethodInsnDeclareBean;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.*;

import static org.objectweb.asm.Opcodes.ASM6;

public class UtilityClassDiscover {

    private static Set<String> convertExceptions2Set(String[] exceptions) {
        if (exceptions == null || exceptions.length == 0) {
            return Collections.emptySet();
        } else {
            Set<String> exceptionSet = new HashSet<>();
            for (String exception : exceptions) {
                exceptionSet.add(exception.intern());
            }
            return exceptionSet;
        }
    }

    public static Map<ClassMethodDeclareBean, Set<MethodInsnDeclareBean>> analysisClassMethodDependencies(byte[] classContent) {
        ClassReader classReader = new ClassReader(classContent);
        final Map<ClassMethodDeclareBean, Set<MethodInsnDeclareBean>> dependencies = new HashMap<>();
        classReader.accept(new ClassVisitor(ASM6) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                ClassMethodDeclareBean classMethodDeclareBean = new ClassMethodDeclareBean();
                classMethodDeclareBean.setAccess(access);
                classMethodDeclareBean.setName(name.intern());
                classMethodDeclareBean.setDesc(desc.intern());
                classMethodDeclareBean.setSignature(signature);
                classMethodDeclareBean.setExceptions(convertExceptions2Set(exceptions));
                final Set<MethodInsnDeclareBean> finalCurrentMethodDependencies =
                        dependencies.computeIfAbsent(classMethodDeclareBean, k -> new HashSet<>());
                return new MethodVisitor(Opcodes.ASM6) {
                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                        MethodInsnDeclareBean methodInsnDeclareBean = new MethodInsnDeclareBean();
                        methodInsnDeclareBean.setOpcode(opcode);
                        methodInsnDeclareBean.setOwner(owner.intern());
                        methodInsnDeclareBean.setName(name.intern());
                        methodInsnDeclareBean.setDesc(desc.intern());
                        methodInsnDeclareBean.setItf(itf);
                        finalCurrentMethodDependencies.add(methodInsnDeclareBean);
                    }
                };
            }
        }, 0);

        return dependencies;
    }

}
