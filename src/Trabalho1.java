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
                + "Qual o preço (m)édio por item?\n"
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

                            System.out.println("Insira o preço do item adicionado.");
                            double novoPreco = scanner.nextDouble();
                            preco[nItens] = novoPreco;

                            System.out.println("Insira a quatidade do item adicionado");
                            int quatidade = scanner.nextInt();
                            quanto[nItens] = quatidade;

                            boolean comprado = false;
                            feito[nItens] = comprado;

                            nItens++;
                            System.out.println("Item adicionado com sucesso!");
                            break;

                        //Insere um item numa posição escolhida
                        case 'p':
                            System.out.println("Aqui tem a Lista com todos os seus Itens:");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
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
                            System.out.println("Aqui tem a Lista com todos os seus Itens:");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }

                            if (nItens > 0) {
                                System.out.println("Digite a posição do item a ser apagado:");
                                int posicao = scanner.nextInt();

                                if (posicao >= 1 && posicao <= nItens) {
                                    for (int i = posicao - 1; i < nItens - 1; i++) {
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
                            } else {
                                System.out.println("A lista está vazia. Nada a remover.");
                            }
                            break;


                        //Apaga item de uma posição à outra da lista.
                        case 'a':
                            System.out.println("Aqui tem a Lista com todos os seus Itens:");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }

                            if (nItens > 0) {
                                System.out.println("Digite a posição inicial (m) dos itens a serem apagados:");
                                int pInicial = scanner.nextInt();
                                System.out.println("Digite a posição final (n) dos itens a serem apagados:");
                                int pFinal = scanner.nextInt();

                                if (pInicial >= 0 && pFinal < nItens && pInicial <= pFinal) {
                                    int qRemovidos = pFinal - pInicial + 1;
                                    for (int i = 0; i < nItens - qRemovidos; i++) {
                                        if (i < pInicial) {
                                            continue;
                                        }
                                        nome[i] = nome[i + qRemovidos];
                                        quanto[i] = quanto[i + qRemovidos];
                                        preco[i] = preco[i + qRemovidos];
                                        feito[i] = feito[i + qRemovidos];
                                    }
                                    nItens -= qRemovidos;

                                    System.out.println("Itens da posição " + pInicial + " à posição " + pFinal + " removidos.");
                                } else {
                                    System.out.println("Posições inválidas.");
                                }
                            } else {
                                System.out.println("A lista está vazia.");
                            }
                            break;

                        case 'L':
                            //Lista com todos os itens
                            System.out.println("Aqui tem a Lista com todos os seus Itens:");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            break;
                        case 'V': //Voltar
                            break;
                        default:
                            System.out.println("Opção Inválida."); //Opções inválidas
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
                            if (nItens > 0) {
                                for (int i = 0; i < nItens; i++) {
                                    if (!feito[i]) {
                                        feito[i] = true;
                                        System.out.println(nome[i] + " está marcado como comprado!");
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("A lista está vazia.");
                            }
                            break;

                        //Desmarca o primeiro item comprado
                        case 'D':
                            boolean primeiroItemMarcado = false;
                            for (int i = 0; i < nItens; i++) {
                                if (feito[i]) {
                                    feito[i] = false;
                                    System.out.println(nome[i] + " foi desmarcado.");
                                    primeiroItemMarcado = true;
                                    break;
                                }
                                if (!primeiroItemMarcado) {
                                    System.out.println("Nenhum item está marcado como comprado!");
                                }
                                break;
                            }
                            break;

                        //Troca de estado usando os nomes na lista
                        case 'n':
                            System.out.println("Aqui tem a Lista com todos os seus Itens:");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }

                            System.out.println("Insira o nome do item para trocar o estado");
                            String nomeItem = scanner.next();
                            boolean encontrado = false;

                            for (int i = 0; i < nItens; i++) {
                                if (nome[i].length() > 0 && nome[i].charAt(0) == nomeItem.charAt(0)) {
                                    feito[i] = !feito[i];
                                    String estado = feito[i] ? "comprado" : "por comprar";
                                    System.out.println(nome[i] + " está agora " + estado + "!");
                                    encontrado = true;
                                    break;
                                }
                            }

                            if (!encontrado) {
                                System.out.println("Item não encontrado na lista.");
                            }
                            break;

                        //Troca de estado usando numero na lista
                        case 'p':
                            System.out.println("Aqui tem a Lista com todos os seus Itens:");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }

                            System.out.println("Qual é a posição do item a ser marcado/desmarcado? ");
                            int posicao = scanner.nextInt();
                            if (posicao < 0 && posicao >= nItens) {
                                System.out.println("Posição Inválida!");
                            } else {
                                feito[posicao] = !feito[posicao];
                                String estado = feito[posicao] ? "comprado" : "por comprar";
                                System.out.println(nome[posicao] + " está agora " + estado + "!");
                            }
                            break;

                        //////////////////////////////////////
                        ////// SUB-SUBMENU L - Listagem //////
                        //////////////////////////////////////

                        case 'L':
                            System.out.println(listar);
                            char opLista = scanner.next().charAt(0);
                            switch (opLista) {
                                //Lista com todos os itens
                                case 't':
                                    System.out.println("Aqui tem a Lista com todos os seus Itens:");
                                    System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                                    for (int i = 0; i < nItens; i++) {
                                        char marcado = feito[i] ? 'x' : ' ';
                                        System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                    }
                                    break;

                                //Lista com todos os itens selecionados como comprados
                                case 'c':
                                    System.out.println("Aqui tem a Lista com todos os Itens comprados:");
                                    System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                                    for (int i = 0; i < nItens; i++) {
                                        char marcado = feito[i] ? 'x' : ' ';
                                        if (feito[i]) {
                                            System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                        }
                                    }
                                    break;

                                //Lista com todos os Itens que não foram comprados
                                case 'p':
                                    System.out.println("Aqui tem a Lista com todos os Itens por comprar:");
                                    System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                                    for (int i = 0; i < nItens; i++) {
                                        char marcado = feito[i] ? 'x' : ' ';
                                        if (!feito[i]) {
                                            System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                        }
                                    }
                                    break;
                            }
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
                    double total = 0.0;
                    for(int i = 0; i < nItens; i++){
                        total += preco[i]*quanto[i];
                    }
                    switch (opFazerContas)
                    {

                        //Faz a operação para calcular o total da lista
                        case 'l':
                            System.out.println("O valor total da lista é: "+ total +" €.");
                            break;

                        //Faz a operação para calcular o valor gasto
                        case 'g':
                            double gasto = 0.0;

                            for (int i = 0; i < nItens; i++) {
                                if (feito[i]) {
                                    gasto += quanto[i] * preco[i];
                                }
                            }
                            System.out.printf("O valor total gasto é: %.2f\n", gasto);
                            break;

                        //Faz a operação para calcular quanto custa o que ainda não foi comprado
                        case 'f':
                            double falta = 0.0;

                            for (int i = 0; i < nItens; i++) {
                                if (!feito[i]) {
                                    falta += quanto[i] * preco[i];
                                }
                            }
                            System.out.printf("O valor total do que falta comprar é: %.2f\n", falta);
                            break;

                        //Faz a operação para calcular o preço médio por item
                        case 'm':
                            if (nItens > 0) {
                                double precoMedio = total / nItens;
                                System.out.printf("O preço médio por item é: %.2f\n", precoMedio);
                            } else {
                                System.out.println("A lista está vazia. Não é possível calcular o preço médio.");
                            }
                            break;

                        default:
                            System.out.println("Opção Inválida");
                            break;
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