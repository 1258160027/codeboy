package com.yang.codeboy.proxydemo;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-10-28
 */
public class Proxy {

    public static void main(String[] args) throws Exception {
        Flyable flyable = (Flyable) Proxy.newProxyInstance(Flyable.class, new MyInvocationHandler(new Bird()));
        flyable.fly();
    }

    public static Object newProxyInstance(Class inf, InvocationHandler handler) throws Exception {
        //构建class的名称和实现的接口
        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("TimeProxy")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(inf);
        //类的属性
        FieldSpec fieldSpec = FieldSpec.builder(InvocationHandler.class,"handler", Modifier.PRIVATE).build();
        typeSpecBuilder.addField(fieldSpec);
        //构造方法
        MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(InvocationHandler.class,"handler")
                .addStatement("this.handler = handler")
                .build();
        typeSpecBuilder.addMethod(constructorMethodSpec);
        //类里面所有的方法
        Method[] methods = inf.getDeclaredMethods();
        for (Method method : methods) {
            //方法的构成
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addCode("try {\n")
                    .addStatement("\t$T method = "+inf.getName()+".class.getMethod(\""+method.getName()+"\")",Method.class)
                    .addStatement("\tthis.handler.invoke(this,method,null)")
                    .addCode("}catch(Throwable e){\n")
                    .addCode("\te.printStackTrace();\n")
                    .addCode("}\n")
                    .build();
            typeSpecBuilder.addMethod(methodSpec);
        }
        //生成源文件.java
        JavaFile javaFile = JavaFile.builder("com.yang.codeboy.proxydemo",typeSpecBuilder.build()).build();
        //写在d盘文件中
        String sourcePath = "D:/proxycode";
        javaFile.writeTo(new File(sourcePath));
        //编译.java -> .class
        JavaCompiler.compiler(new File(sourcePath+"/com/yang/codeboy/proxydemo/TimeProxy.java"));
        //使用反射load到内存
        URL[] urls = new URL[]{new URL("file:"+sourcePath)};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class clazz = classLoader.loadClass("com.yang.codeboy.proxydemo.TimeProxy");
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
        Object obj = constructor.newInstance(handler);
        return obj;
    }
}
