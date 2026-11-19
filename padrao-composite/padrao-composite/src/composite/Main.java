package composite;

public class Main {
    public static void main(String[] args) {
        Pasta raiz = new Pasta("raiz");
        raiz.adicionar(new Arquivo("a.txt", 100));
        raiz.adicionar(new Arquivo("b.txt", 50));

        Pasta imagens = new Pasta("imagens");
        imagens.adicionar(new Arquivo("foto.png", 300));
        imagens.adicionar(new Arquivo("logo.png", 120));
        raiz.adicionar(imagens);

        System.out.print(raiz.exibir(0));
        System.out.println("Total de arquivos: " + raiz.contarArquivos());
        System.out.println("Tamanho total: " + raiz.getTamanho() + " bytes");
    }
}
