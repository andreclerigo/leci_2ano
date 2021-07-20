package aula13.Plugin;

import java.util.*;
import java.io.*;

public class TestPlugin {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) System.exit(0);
        File proxyList = new File(args[0]);
        List<IPlugin> plugins = new ArrayList<>();

        for (String s : Objects.requireNonNull(proxyList.list())) {
            try {
                //System.out.println("./aula13.Plugin." + s.substring(0, s.lastIndexOf('.')));
                plugins.add(PluginManager.load("aula13.Plugin." + s.substring(0, s.lastIndexOf('.'))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (IPlugin plugin : plugins)
            plugin.doSomething();
    }
}
