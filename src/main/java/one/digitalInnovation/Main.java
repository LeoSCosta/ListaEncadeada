package one.digitalInnovation;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<String> minhaLista = new ListaEncadeada<>();
        minhaLista.add("primeiro");
        minhaLista.add("segundo");
        minhaLista.add("terceiro");
        minhaLista.add("quarto");
        minhaLista.add("quinto");
        System.out.println(minhaLista.get(1));
        System.out.println(minhaLista);

        System.out.println(minhaLista.remove(3));
        System.out.println(minhaLista);
    }
}
