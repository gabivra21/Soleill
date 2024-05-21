public class Pagamento {
    private String metodo;
    private int data;
    private String status;

    public Pagamento (String metodo, int data, String status) {
        this.metodo = metodo;
        this.data = data;
        this.status = status;
    }

    public void aprovarPagamento() {

    }

    public void recusarPagamento() {

    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
