import java.sql.SQLOutput;
import java.util.Scanner;

public class Trabalho1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tamMax = 100;
        String[] nome = new String[tamMax];
        double[] quanto = new double[tamMax];
        double[] preco = new double[tamMax];
        boolean[] feito = new boolean[tamMax];
        int nItens = 0;

        String menuPrincipal = "(E)ditar lista.\n"
                + "(F)azer compras.\n"
                + "Fazer (c)ontas.\n"
                + "(S)air";

        String editarLista = "----------------------------------------\n"
                + "(I)nserir item no fim da lista.\n"
                + "Inserir item na (p)osição n da lista.\n"
                + "(A)pagar último item inserido na lista.\n"
                + "Apagar item na posição (n) da lista.\n"
                + "(a)pagar itens da posição m à n da lista.\n"
                + "(L)istar todos os itens.\n"
                + "(V)oltar.\n"
                + "----------------------------------------\n";

        String fazerCompras = "----------------------------------------\n"
                + "(M)arcar primeiro item por comprar.\n"
                + "(D)esmarcar primeiro item comprado.\n"
                + "Trocar estado por (n)ome.\n"
                + "Trocar estado por (p)osição.\n"
                + "(L)istar.\n"
                + "(V)oltar.\n"
                + "----------------------------------------\n";

        String listar = "----------------------------------------\n"
                + "Listar (t)odos os itens.\n"
                + "Listar itens (c)omprados.\n"
                + "Listar itens (p)or comprar.\n"
                + "----------------------------------------\n";

        String fazerContas = "Quanto custa a (l)ista?\n"
                + "Quanto já (g)astei?\n"
                + "Quanto custa o que (f)alta comprar?\n"
                + "Qual o preço (m)édio por item?"
                + "----------------------------------------\n";


        //////////////////////////////////////
        ////////////MENU PRINCIPAL////////////
        //////////////////////////////////////
        char op;

        do {
            System.out.println(menuPrincipal);
            op = scanner.next().charAt(0);
            switch (op) {

                //////////////////////////////////////
                ////// SUBMENU E - EDITAR LISTA //////
                //////////////////////////////////////

                case 'E':

                    System.out.println(editarLista);
                    char opEditarLista = scanner.next().charAt(0);
                    scanner.nextLine();
                    switch (opEditarLista) {

                        //Insere um novo item à lista :D
                        case 'I':
                            System.out.println("Insira um item novo para a lista.");
                            String novoItem = scanner.nextLine();
                            nome[nItens] = novoItem;

                            System.out.println("Insira o valor do item adicionado.");
                            double novoPreco = scanner.nextDouble();
                            preco[nItens] = novoPreco;

                            System.out.println("Insira a quatidade do item adicionado");
                            int quatidade = scanner.nextInt();
                            quanto[nItens] = quatidade;

                            nItens++;
                            System.out.println("Item adicionado com sucesso!");
                            break;

                        //Insere um item numa posição escolhida
                        case 'p':
                            for (int i = 0; i < nItens; i++) {
                                System.out.println("Lista de Itens:");
                                System.out.println("\tItem \t Quantidade \t Preço \t Comprado");
                                System.out.printf("%d \t %s \t %.2f \t\t\t %.2f \n", (i + 1),nome[i],quanto[i], preco[i]);
                            }

                            System.out.println("Insira a posição atual do item:");
                            int posAtual = scanner.nextInt() - 1;
                            System.out.println("Insira a nova posição do item:");
                            int posNova = scanner.nextInt() - 1;

                            //Verifica se a posição atual é maior é válida
                            if (posAtual < 0 || posAtual >= nItens || posNova < 0 || posNova >= nItens) {
                                System.out.println("Posição inválida!");
                            } else if (posAtual == posNova) {
                                System.out.println("O item já está nessa posição!");

                                //Variaveis temporarias para mover a posição
                            } else {
                                String item = nome[posAtual];
                                double qtd = quanto[posAtual];
                                double precoItem = preco[posAtual];
                                boolean feitoItem = feito[posAtual];

                                    /*  Se a Posição Atual for maior que a Posição nova,
                                     repete até i ser menor que a Posição Nova          */

                                if (posAtual < posNova) {
                                    for (int i = posAtual; i < posNova; i++) {
                                        nome[i] = nome[i + 1];
                                        quanto[i] = quanto[i + 1];
                                        preco[i] = preco[i + 1];
                                        feito[i] = feito[i + 1];
                                    }

                                    /*  Se a Posição Atual for menor que a Posição nova,
                                    repete até i ser maior que a Posição Nova            */

                                } else {
                                    for (int i = posAtual; i > posNova; i--) {
                                        nome[i] = nome[i - 1];
                                        quanto[i] = quanto[i - 1];
                                        preco[i] = preco[i - 1];
                                        feito[i] = feito[i - 1];
                                    }
                                }
                                //Atualiza os arrays para a nova posição
                                nome[posNova] = item;
                                quanto[posNova] = qtd;
                                preco[posNova] = precoItem;
                                feito[posNova] = feitoItem;
                                System.out.println("Item movido com sucesso!");

                            }

                            break;

                        //Apaga o ultimo item inserido na lista
                        case 'A':
                            if (nItens == 0) {
                                System.out.println("A Lista está vazia");
                            } else {
                                nItens--;
                                System.out.println("Último Item da lista removido.");
                            }
                            break;

                        //Apaga item na posição desejada da lista.
                        case 'n':
                            for (int i = 0; i < nItens; i++) {
                                System.out.println("Lista de Itens:");
                                System.out.println("\tItem \t Quantidade \t Preço \t Comprado");
                                System.out.printf("%d \t %s \t %.2f \t\t\t %.2f \n", (i + 1),nome[i],quanto[i], preco[i]);
                            }

                            if (nItens > 0) {
                                System.out.println("Digite a posição do item a ser apagado:");
                                int posicao = scanner.nextInt();

                                if (posicao >= 0 || posicao < nItens) {
                                    for (int i = posicao; i < nItens - 1; i++) {
                                        nome[i] = nome[i + 1];
                                        quanto[i] = quanto[i + 1];
                                        preco[i] = preco[i + 1];
                                        feito[i] = feito[i + 1];
                                    }
                                    nItens--;

                                    System.out.println("Item na posição " + posicao + " removido.");
                                } else {
                                    System.out.println("Posição inválida.");
                                }
                            }
                            else {
                                System.out.println("A lista está vazia. Nada a remover.");
                            }
                            break;

                        //Apaga item de uma posição à outra da lista.
                        case 'a':

                            for (int i = 0; i < nItens; i++) {
                                System.out.println("Lista de Itens:");
                                System.out.println("\tItem \t Quantidade \t Preço \t Comprado");
                                System.out.printf("%d \t %s \t %.2f \t\t\t %.2f \n", (i + 1),nome[i],quanto[i], preco[i]);
                            }

                            if (nItens>0){
                                System.out.println("Digite a posição inicial (m) dos itens a serem apagados:");
                                int pInicial = scanner.nextInt();
                                System.out.println("Digite a posição final (n) dos itens a serem apagados:");
                                int pFinal = scanner.nextInt();

                                if (pInicial>=0 || pFinal < nItens || pInicial<=pFinal){
                                    int qRemovidos = pFinal - pInicial +1;
                                    for(int i = pInicial; i < nItens - qRemovidos; i++){
                                        nome[i] = nome[i + qRemovidos];
                                        quanto[i] = quanto[i + qRemovidos];
                                        preco[i] = preco[i + qRemovidos];
                                        feito[i] = feito[i + qRemovidos];
                                    }
                                    nItens -= qRemovidos;

                                    System.out.println("Itens da posição "+pInicial+" à posição "+pFinal+" removidos.");
                                }else{
                                    System.out.println("Posições inválidas.");
                                }
                            }else {
                                System.out.println("A lista está vazia.");
                            }
                            break;

                        //////////////////////////////////////
                        ////// SUB-SUBMENU L - Listagem //////
                        //////////////////////////////////////

                        case 'L':
                            System.out.println(listar);
                            char opLista = scanner.next().charAt(0);
                            switch (opLista) {
                                case 't':
                                    System.out.println("Aqui tem a Lista com todos os seus Itens:");
                                    System.out.println("\tItem \t\t\t\t Quantidade \t Preço \t Comprado");
                                    for (int i = 0; i < nItens; i++) {
                                        System.out.printf("%d \t %s \t\t\t\t %.2f \t\t\t %.2f \n", (i + 1),nome[i],quanto[i], preco[i]);
                                    }
                                    break;
                                case 'c':
                                    System.out.println("Listar itens comprados");
                                    break;
                                case 'p':
                                    System.out.println("Listar itens por comprar");
                                    break;
                            }
                            break;
                        case 'V':
                            break;
                        default:
                            System.out.println("Opção Inválida.");
                    }
                    break;


                //////////////////////////////////////
                ///// SUBMENU F - FAZER COMPRAS //////
                //////////////////////////////////////

                case 'F':

                    System.out.println(fazerCompras);
                    char opFazerCompras = scanner.next().charAt(0);
                    switch (opFazerCompras) {
                        case 'M':
                            System.out.println("Marcar primeiro item por comprar.");
                            break;
                        case 'D':
                            System.out.println("Desmarcar primeiro item comprado.");
                            break;
                        case 'n':
                            System.out.println("Trocar estado por nomes");
                            break;
                        case 'p':
                            System.out.println("Trocar estado por posição");
                            break;
                        case 'L':
                            System.out.println("Listar");
                            break;
                        case 'V':
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                    break;

                //////////////////////////////////////
                ////// SUBMENU c - FAZER CONTAS //////
                //////////////////////////////////////

                case 'c':

                    System.out.println(fazerContas);
                    char opFazerContas = scanner.next().charAt(0);
                    switch (opFazerContas) {
                        case 'l':
                            System.out.println("Quanto custa a lista?");
                            break;
                        case 'g':
                            System.out.println("Quanto já gastei?");
                            break;
                        case 'f':
                            System.out.println("Quanto custa o que falta comprar?");
                            break;
                        case 'm':
                            System.out.println("Qual o preço médio por item?");
                            break;
                        default:
                            System.out.println("Opção Inválida");
                    }
                    break;

                //////////////////////////////////////
                //// SUBMENU S - FECHAR PROGRAMA /////
                //////////////////////////////////////

                case 'S':

                    System.out.println("Saiu do Programa.");
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }
        }
        while (op != 'S');
    }
}