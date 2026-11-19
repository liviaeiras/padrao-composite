package composite;

public interface ItemSistema {
    String getNome();

    long getTamanho();

    int contarArquivos();

    String exibir(int nivel);
}
