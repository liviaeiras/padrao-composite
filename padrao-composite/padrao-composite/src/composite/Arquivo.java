package composite;

public class Arquivo implements ItemSistema {
    private final String nome;
    private final long tamanho;

    public Arquivo(String nome, long tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public long getTamanho() {
        return tamanho;
    }

    @Override
    public int contarArquivos() {
        return 1;
    }

    @Override
    public String exibir(int nivel) {
        return "  ".repeat(nivel) + "- " + nome + " (" + tamanho + " bytes)\n";
    }
}
