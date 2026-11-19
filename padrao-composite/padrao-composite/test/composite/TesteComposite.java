package composite;

public class TesteComposite {
    public static void main(String[] args) {
        testeArquivoIsolado();
        testePastaVazia();
        testePastaSomaTamanhos();
        testePastaAninhada();
        testeRemoverItem();
        testeContarArquivos();
        testeExibirArvore();
        System.out.println("Todos os testes passaram");
    }

    private static Pasta montarArvore() {
        Pasta raiz = new Pasta("raiz");
        raiz.adicionar(new Arquivo("a.txt", 100));
        raiz.adicionar(new Arquivo("b.txt", 50));
        Pasta imagens = new Pasta("imagens");
        imagens.adicionar(new Arquivo("foto.png", 300));
        raiz.adicionar(imagens);
        return raiz;
    }

    private static void testeArquivoIsolado() {
        Arquivo arquivo = new Arquivo("a.txt", 100);
        verificar(arquivo.getTamanho() == 100 && arquivo.contarArquivos() == 1, "arquivo informa tamanho e conta como um arquivo");
    }

    private static void testePastaVazia() {
        Pasta pasta = new Pasta("vazia");
        verificar(pasta.getTamanho() == 0 && pasta.contarArquivos() == 0, "pasta vazia tem tamanho zero e nenhum arquivo");
    }

    private static void testePastaSomaTamanhos() {
        Pasta pasta = new Pasta("docs");
        pasta.adicionar(new Arquivo("a.txt", 100));
        pasta.adicionar(new Arquivo("b.txt", 50));
        verificar(pasta.getTamanho() == 150, "pasta soma o tamanho dos filhos");
    }

    private static void testePastaAninhada() {
        verificar(montarArvore().getTamanho() == 450, "pasta soma recursivamente o tamanho das subpastas");
    }

    private static void testeRemoverItem() {
        Pasta pasta = new Pasta("docs");
        Arquivo a = new Arquivo("a.txt", 100);
        pasta.adicionar(a);
        pasta.adicionar(new Arquivo("b.txt", 50));
        pasta.remover(a);
        verificar(pasta.getTamanho() == 50 && pasta.contarArquivos() == 1, "remover item atualiza tamanho e contagem");
    }

    private static void testeContarArquivos() {
        verificar(montarArvore().contarArquivos() == 3, "contagem de arquivos e recursiva");
    }

    private static void testeExibirArvore() {
        String esperado = "+ raiz (450 bytes)\n"
                + "  - a.txt (100 bytes)\n"
                + "  - b.txt (50 bytes)\n"
                + "  + imagens (300 bytes)\n"
                + "    - foto.png (300 bytes)\n";
        verificar(esperado.equals(montarArvore().exibir(0)), "exibir mostra a arvore com indentacao");
    }

    private static void verificar(boolean condicao, String descricao) {
        if (!condicao) {
            throw new AssertionError("FALHOU: " + descricao);
        }
        System.out.println("OK - " + descricao);
    }

    private static boolean iguais(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }
}
