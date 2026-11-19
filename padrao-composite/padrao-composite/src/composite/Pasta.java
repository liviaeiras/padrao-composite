package composite;

import java.util.ArrayList;
import java.util.List;

public class Pasta implements ItemSistema {
    private final String nome;
    private final List<ItemSistema> filhos = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionar(ItemSistema item) {
        filhos.add(item);
    }

    public void remover(ItemSistema item) {
        filhos.remove(item);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public long getTamanho() {
        long total = 0;
        for (ItemSistema filho : filhos) {
            total += filho.getTamanho();
        }
        return total;
    }

    @Override
    public int contarArquivos() {
        int total = 0;
        for (ItemSistema filho : filhos) {
            total += filho.contarArquivos();
        }
        return total;
    }

    @Override
    public String exibir(int nivel) {
        StringBuilder texto = new StringBuilder();
        texto.append("  ".repeat(nivel)).append("+ ").append(nome).append(" (").append(getTamanho()).append(" bytes)\n");
        for (ItemSistema filho : filhos) {
            texto.append(filho.exibir(nivel + 1));
        }
        return texto.toString();
    }
}
