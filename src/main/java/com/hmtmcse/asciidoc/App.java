package com.hmtmcse.asciidoc;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class App{

    public static List getClasseNames(String jarName) {
        ArrayList classes = new ArrayList();
        try {
            JarInputStream jarFile = new JarInputStream(new FileInputStream(
                    jarName));
            JarEntry jarEntry;

            while (true) {
                jarEntry = jarFile.getNextJarEntry();
                if (jarEntry == null) {
                    break;
                }
                System.out.println(jarEntry.getName());
                if (jarEntry.getName().endsWith(".class")) {
                        System.out.println("Found "
                                + jarEntry.getName().replaceAll("/", "\\."));
                    classes.add(jarEntry.getName().replaceAll("/", "\\."));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    public void kireVai(File myJar){
        try {
            URLClassLoader child = new URLClassLoader(
                    new URL[] {myJar.toURI().toURL()},
                    this.getClass().getClassLoader()
            );
            System.out.println("xyz");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        App ap = new App();
        ap.kireVai(new File("G:\\java_shell_v3\\binary\\java-console-table-1.0.jar"));


        getClasseNames("G:\\java_shell_v3\\binary\\java-console-table-1.0.jar");
        System.exit(0);
        try{

            File file = new File("G:\\java_shell_v3\\binary\\java-console-table-1.0.jar");

            //convert the file to URL format
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};

            ClassLoader loader = URLClassLoader.newInstance(
                    urls,
                    Thread.currentThread().getContextClassLoader()
            );




            //load this folder into Class loader
            ClassLoader cl = new URLClassLoader(urls);
            Field field = ClassLoader.class.getDeclaredField("classes");
            field.setAccessible(true);
            Vector<Class> classes =  (Vector<Class>) field.get(loader);
            for(Class cls : classes){
                System.out.println(cls.getName());
            }

            //load the Address class in 'c:\\other_classes\\'
            Class  cls = cl.loadClass("com.mkyong.io.Address");
//
//            //print the location from where this class was loaded
//            ProtectionDomain pDomain = cls.getProtectionDomain();
//            CodeSource cSource = pDomain.getCodeSource();
//            URL urlfrom = cSource.getLocation();
//            System.out.println(urlfrom.getFile());

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
