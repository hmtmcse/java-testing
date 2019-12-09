package com.hmtmcse.asciidoc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;

public class TestMain {

    public static void main(String[] args) {
        Field f;
        try {
            f = ClassLoader.class.getDeclaredField("classes");
            f.setAccessible(true);
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Vector<Class> classes =  (Vector<Class>) f.get(classLoader);

            for(Class cls : classes){
//                java.net.URL location = cls.getResource('/' + cls.getName().replace('.',
//                        '/') + ".class");
//                System.out.println("<p>"+location +"<p/>");
                System.out.println(cls.getName());
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

//        ExtensionLoader<MyPlugin> loader = new ExtensionLoader<MyPlugin>();
//        somePlugin = loader.LoadClass("path/to/jar/file", "com.example.pluginXYZ", MyPlugin.class);

//        URLClassLoader child = new URLClassLoader(
//                new URL[] {myJar.toURI().toURL()},
//                this.getClass().getClassLoader()
//        );
//        Class classToLoad = Class.forName("com.MyClass", true, child);
//        Method method = classToLoad.getDeclaredMethod("myMethod");
//        Object instance = classToLoad.newInstance();
//        Object result = method.invoke(instance);

    }
}