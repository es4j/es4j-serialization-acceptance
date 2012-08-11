package org.es4j.serlization.acceptance;

import org.es4j.util.CommandLineArguments;



public class Es4jCli {

    private static Launcher launcher = new Launcher();

    static void setLauncher(Launcher launcher) {
        Es4jCli.launcher = launcher;
    }

    public static void main(String[] args) {
        launcher.run(args);
    }
}
