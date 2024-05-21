public class Pedido {
  private int prazoEntrega;
  private boolean entregue;
  private int qtdeItens;
  private String endEntrega;

  public Pedido(int prazoEntrega, boolean entregue, int qtdeItens, String endEntrega) {
    this.prazoEntrega = prazoEntrega;
    this.entregue = entregue;
    this.qtdeItens = qtdeItens;
    this.endEntrega = endEntrega;
  }

  public int getPrazoEntrega() {
    return prazoEntrega;
  }

  public void setPrazoEntrega(int prazoEntrega) {
    this.prazoEntrega = prazoEntrega;
  }

  public boolean isEntregue() {
    return entregue;
  }

  public void setEntregue(boolean entregue) {
    this.entregue = entregue;
  }

  public int getQtdeItens() {
    return qtdeItens;
  }

  public void setQtdeItens(int qtdeItens) {
    this.qtdeItens = qtdeItens;
  }

  public String getEndEntrega() {
    return endEntrega;
  }

  public void setEndEntrega(String endEntrega) {
    this.endEntrega = endEntrega;
  }
}
