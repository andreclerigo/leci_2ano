package aula13.Plugin;

import java.lang.reflect.InvocationTargetException;

public class PluginManager {
    @SuppressWarnings("deprecation")
    public static IPlugin load(String pluginName)
            throws ClassNotFoundException, IllegalAccessException, ClassCastException, InstantiationException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<?> pluginClass = Class.forName(pluginName);
        return (IPlugin) pluginClass.getConstructor().newInstance();
    }
}
