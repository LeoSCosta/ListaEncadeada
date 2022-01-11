package one.digitalInnovation;

public class ListaEncadeada <T>{

    No<T> refenciaEntrada;



    public ListaEncadeada(){
        this.refenciaEntrada = null;
    }


    //________________________________________________________________________
    private No<T> getNo(int index){ //O getNo retorna um nó apatir de seu indice

        validaIndice(index); // primeiro ocorre uma validação para o indice
        No<T> aux = refenciaEntrada;
        No<T> retorno= null;
        for (int i = 0; i <= index; i++){//atraves do for ele percorre a lista até encontrar o nó.
            retorno = aux;
            aux = aux.getProxNo();
        }

        return retorno;
    }
    public T get(int index){//O get retorna o conteudo de um nó apatir de seu indice
        return getNo(index).getConteudo();
    }

    //___________________________________________________________________________________
    public T remove(int index){ //O remove remove um nó apartir de seu indice
        No<T> remove = getNo(index);
        if(index == 0){
            refenciaEntrada = remove.getProxNo();
            //Se o nó nao tem outro nó apontando para ele, o nó a que esse aponta se torna o nó de referencia(ultimo nó da lista)
            return remove.getConteudo();
        }
        No<T> noAnterior = getNo(index-1);
        noAnterior.setProxNo(remove.getProxNo());
        //Caso haja um nó apontando para o nó, esse nó que aponta, vai passar a apontar para o nó que nó aponta.
        return remove.getConteudo();
    }

    //___________________________________________________________________________________
    private void validaIndice(int index) {
        if(index>=size()){
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice" + index + "dessa lista.");
        }
    }

    //___________________________________________________________________________________
    public void add(T conteudo){ //adiciona um nó ao inicio da lista.
        No<T> novoNo = new No<>(conteudo);
        if(isEmpty()){
            refenciaEntrada = novoNo;
            return;
        }
        No<T> aux = refenciaEntrada;
        for (int i = 0; i < this.size() - 1; i++){
            aux = aux.getProxNo();
        }
        aux.setProxNo(novoNo);
    }
    //___________________________________________________________________________________
    public int size(){ //calcula o tamanho da lista
        int tamanhoLista = 0;
        No<T> aux = refenciaEntrada;
        while(true){
            if(aux!=null){
                tamanhoLista++;
                if (aux.getProxNo()!=null){
                    aux = aux.getProxNo();
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return tamanhoLista;
    }
    //___________________________________________________________________________________
    public boolean isEmpty(){
        return refenciaEntrada == null;
    }

    @Override
    public String toString() {
        String strRetorno ="";
        No<T> aux = refenciaEntrada;
        for (int i = 0; i < size(); i++){
            strRetorno += "[No{conteudo = "+aux.getConteudo() + "}] -----> ";
            aux = aux.getProxNo();
        }
        strRetorno += "null";

        return strRetorno;
    }
}
