import java.io.IOException;
import java.util.List;

public interface ClienteAdapter {
    void saveClients(List<Cliente> clients) throws IOException;
    List<Cliente> loadClients() throws IOException;
}
