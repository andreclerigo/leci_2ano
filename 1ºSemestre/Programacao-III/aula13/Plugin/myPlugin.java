package aula13.Plugin;

public class myPlugin implements IPlugin {
    @Override
    public void doSomething() {
        System.out.println((new Object(){}).getClass().getEnclosingMethod());
    }
}
