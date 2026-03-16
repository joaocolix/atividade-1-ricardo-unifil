public class ListaSimples implements ListaOperacoes {

    private String[] dados;
    private int tamanho;

    public ListaSimples(int capacidade) {
        dados = new String[capacidade];
        tamanho = 0;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(dados[i] + " ");
        }
        System.out.println();
    }

    public boolean adicionarElemento(String elemento) {
        if (tamanho == dados.length)
            return false;
        dados[tamanho++] = elemento;
        return true;
    }

    public boolean removerElemento(String elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (dados[i].equals(elemento)) {
                for (int j = i; j < tamanho - 1; j++) {
                    dados[j] = dados[j + 1];
                }
                tamanho--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;

        for (int i = 0; i < tamanho; i++) {
            if (dados[i].equals(elemento)) {

                for (int j = i; j < tamanho - 1; j++) {
                    dados[j] = dados[j + 1];
                }

                tamanho--;
                removidos++;
                i--;
            }
        }

        return removidos;
    }

    @Override
    public int contar() {
        return tamanho;
    }

    @Override
    public int adicionarVarios(String[] elementos) {

        int adicionados = 0;

        for (String e : elementos) {
            if (tamanho == dados.length)
                break;

            dados[tamanho++] = e;
            adicionados++;
        }

        return adicionados;
    }

    @Override
    public String obter(int indice) {

        if (indice < 0 || indice >= tamanho)
            return null;

        return dados[indice];
    }

    @Override
    public boolean inserir(int indice, String elemento) {

        if (indice < 0 || indice > tamanho || tamanho == dados.length)
            return false;

        for (int i = tamanho; i > indice; i--) {
            dados[i] = dados[i - 1];
        }

        dados[indice] = elemento;
        tamanho++;

        return true;
    }

    @Override
    public String removerPorIndice(int indice) {

        if (indice < 0 || indice >= tamanho)
            return null;

        String removido = dados[indice];

        for (int i = indice; i < tamanho - 1; i++) {
            dados[i] = dados[i + 1];
        }

        tamanho--;

        return removido;
    }

    @Override
    public void limpar() {
        tamanho = 0;
    }

    @Override
    public int ultimoIndiceDe(String elemento) {

        for (int i = tamanho - 1; i >= 0; i--) {
            if (dados[i].equals(elemento))
                return i;
        }

        return -1;
    }

    @Override
    public int contarOcorrencias(String elemento) {

        int cont = 0;

        for (int i = 0; i < tamanho; i++) {
            if (dados[i].equals(elemento))
                cont++;
        }

        return cont;
    }

    @Override
    public int substituir(String antigo, String novo) {

        int substituidos = 0;

        for (int i = 0; i < tamanho; i++) {

            if (dados[i].equals(antigo)) {
                dados[i] = novo;
                substituidos++;
            }
        }

        return substituidos;
    }
}