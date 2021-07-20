package aula5;
import java.io.File;
import java.io.IOException;

public interface AgendaHandler {
    public Pessoa[] readAgenda(File[] files) throws IOException;
    public void writeAgenda(Pessoa[] agenda) throws IOException;
}