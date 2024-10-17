import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileClienteAdapter implements ClienteAdapter {
    private String filename;

    public FileClienteAdapter(String filename) {
        this.filename = filename;
    }

    @Override
    public void saveClients(List<Cliente> clients) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Cliente cliente : clients) {
                writer.println(cliente.toFileString());
            }
        }
    }

    @Override
    public ArrayList<Cliente> loadClients() throws IOException {
    	ArrayList<Cliente> clients = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Nenhum arquivo de clientes encontrado. Um novo arquivo será criado.");
            return clients;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Cliente cliente = Cliente.fromFileString(line);
                clients.add(cliente);
            }
        }
        return clients;
    }
}

