package com.pkslow.basic;

import com.pkslow.basic.cglib.Animal;
import com.pkslow.basic.cglib.CGLibProxy;
import net.sf.cglib.core.DebuggingClassWriter;

public class CGLibDynamicProxy {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/larry/IdeaProjects/pkslow-samples/java-basic/jdk-cglib-proxy/target/cglib_proxy_classes");
        CGLibProxy<Animal> cgLibProxy = new CGLibProxy<>();
        Animal animal = cgLibProxy.getInstance(new Animal());
        animal.talk("Hi, pkslow");
    }
}
