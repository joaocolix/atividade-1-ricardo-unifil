public class ListaDinamica implements ListaOperacoes {

    private No inicio;
    private int tamanho;

    public void exibir() {

        No atual = inicio;

        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }

        System.out.println();
    }

    public void adicionarElemento(String elemento) {

        No novo = new No(elemento);

        if (inicio == null) {
            inicio = novo;
        } else {

            No atual = inicio;

            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = novo;
        }

        tamanho++;
    }

    public boolean removerElemento(String elemento) {

        No atual = inicio;
        No anterior = null;

        while (atual != null) {

            if (atual.valor.equals(elemento)) {

                if (anterior == null)
                    inicio = atual.proximo;
                else
                    anterior.proximo = atual.proximo;

                tamanho--;
                return true;
            }

            anterior = atual;
            atual = atual.proximo;
        }

        return false;
    }

    @Override
    public int removerTodas(String elemento) {

        int removidos = 0;

        while (removerElemento(elemento)) {
            removidos++;
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
            adicionarElemento(e);
            adicionados++;
        }

        return adicionados;
    }

    @Override
    public String obter(int indice) {

        if (indice < 0 || indice >= tamanho)
            return null;

        No atual = inicio;

        for (int i = 0; i < indice; i++) {
            atual = atual.proximo;
        }

        return atual.valor;
    }

    @Override
    public boolean inserir(int indice, String elemento) {

        if (indice < 0 || indice > tamanho)
            return false;

        No novo = new No(elemento);

        if (indice == 0) {
            novo.proximo = inicio;
            inicio = novo;
        } else {

            No atual = inicio;

            for (int i = 0; i < indice - 1; i++) {
                atual = atual.proximo;
            }

            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }

        tamanho++;
        return true;
    }

    @Override
    public String removerPorIndice(int indice) {

        if (indice < 0 || indice >= tamanho)
            return null;

        No atual = inicio;

        if (indice == 0) {

            inicio = inicio.proximo;
            tamanho--;
            return atual.valor;
        }

        for (int i = 0; i < indice - 1; i++) {
            atual = atual.proximo;
        }

        String removido = atual.proximo.valor;

        atual.proximo = atual.proximo.proximo;

        tamanho--;

        return removido;
    }

    @Override
    public void limpar() {

        inicio = null;
        tamanho = 0;
    }

    @Override
    public int ultimoIndiceDe(String elemento) {

        int indice = 0;
        int ultimo = -1;

        No atual = inicio;

        while (atual != null) {

            if (atual.valor.equals(elemento))
                ultimo = indice;

            indice++;
            atual = atual.proximo;
        }

        return ultimo;
    }

    @Override
    public int contarOcorrencias(String elemento) {

        int cont = 0;

        No atual = inicio;

        while (atual != null) {

            if (atual.valor.equals(elemento))
                cont++;

            atual = atual.proximo;
        }

        return cont;
    }

    @Override
    public int substituir(String antigo, String novo) {

        int cont = 0;

        No atual = inicio;

        while (atual != null) {

            if (atual.valor.equals(antigo)) {
                atual.valor = novo;
                cont++;
            }

            atual = atual.proximo;
        }

        return cont;
    }
}