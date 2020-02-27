package com.fr.learn;

public class Learner4Debug {

    public static void main(String... args) {
        try {
            Class.forName("com.fr.start.MainDesigner");
            org.swingexplorer.Launcher.main(new String[]{"com.fr.start.MainDesigner"});
        } catch (ClassNotFoundException e) {
            // MainDesigner找不到，走以前的Designer
            org.swingexplorer.Launcher.main(new String[]{"com.fr.start.Designer"});
        }
    }
}
