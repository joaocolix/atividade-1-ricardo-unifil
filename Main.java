public class Main {

    public static void main(String[] args) {

        ListaSimples lista = new ListaSimples(10);

        lista.adicionarElemento("Ana");
        lista.adicionarElemento("Carlos");
        lista.adicionarElemento("Ana");

        lista.exibir();

        lista.substituir("Ana", "Maria");

        lista.exibir();

        System.out.println("Total: " + lista.contar());
    }
}