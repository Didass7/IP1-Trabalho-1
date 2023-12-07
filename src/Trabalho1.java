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

                        //Insere um novo item à lista//
                        case 'I':
                            System.out.println("Insira um item novo para a lista:");
                            String novoItem = scanner.nextLine();
                            nome[nItens] = novoItem;

                            System.out.println("Insira o preço do item adicionado:");
                            double novoPreco = scanner.nextDouble();
                            preco[nItens] = novoPreco;

                            System.out.println("Insira a quantidade do item adicionado:");
                            int quatidade = scanner.nextInt();
                            quanto[nItens] = quatidade;

                            boolean comprado = false;
                            feito[nItens] = comprado;

                            //Adiciona +1 à variavel nItens sempre que um item novo é adicionado
                            nItens++;

                            System.out.println( "┏--------------------------------------┒\n"
                                    +   "|      Item adicionado com sucesso!    |\n"
                                    +   "┗--------------------------------------┛\n");
                            break;


                        //Insere um novo item numa posição escolhida
                        case 'p':
                            //Mostra a Lista para o usuario ter uma referência
                            System.out.println("Aqui tem a Lista com todos os seus Itens:");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }

                            System.out.println("Insira a posição onde deseja inserir o novo item:");
                            int posicaoEscolhida = scanner.nextInt();
                            scanner.nextLine();

                            // Verifica se a posição inserida é válida
                            if (posicaoEscolhida < 0 || posicaoEscolhida > nItens) {
                                System.out.println("Posição inválida!");
                                break;
                            }

                            // Desloca os itens para abrir espaço para o novo item na posição escolhida
                            for (int i = nItens - 1; i >= posicaoEscolhida; i--) {
                                nome[i+1] = nome[i];
                                quanto[i+1] = quanto[i];
                                preco[i+1] = preco[i];
                                feito[i+1] = feito[i];
                            }

                            //Solicita detalhes sobre um novo item
                            System.out.println("Insira o nome do novo item:");
                            String nomeNovoItem = scanner.nextLine();
                            nome[posicaoEscolhida] = nomeNovoItem;

                            System.out.println("Insira o preço do novo item:");
                            double precoNovoItem = scanner.nextDouble();
                            preco[posicaoEscolhida] = precoNovoItem;

                            System.out.println("Insira a quantidade do novo item:");
                            double quantidadeNovoItem = scanner.nextDouble();
                            quanto[posicaoEscolhida] = quantidadeNovoItem;

                            boolean novoItemComprado = false;
                            feito[posicaoEscolhida] = novoItemComprado;

                            nItens++;

                            System.out.println( "┏--------------------------------------┒\n"
                                    +   "|      Item adicionado com sucesso!    |\n"
                                    +   "┗--------------------------------------┛\n");



                            System.out.println("Aqui tem a sua lista atualizada! ");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            System.out.println("\n---------------------------------------------------------------\n");

                            break;


                        //Apaga o ultimo item inserido na lista
                        case 'A':
                            if (nItens == 0) {
                                System.out.println( "┏--------------------------------------┒\n"
                                        +   "|          A Lista está vazia!         |\n"
                                        +   "┗--------------------------------------┛\n");

                                //Como o último item é o nItens mais alto, basta remover -1 à variavel
                            } else {
                                nItens--;
                                System.out.println( "┏--------------------------------------┒\n"
                                        +   "|   Último Item removido com sucesso!  |\n"
                                        +   "┗--------------------------------------┛\n");

                                //Lista atualizada com todas as mudanças
                                System.out.println("Aqui tem a sua lista atualizada! ");
                                System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                                for (int i = 0; i < nItens; i++) {
                                    char marcado = feito[i] ? 'x' : ' ';
                                    System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                                }
                                System.out.println("\n---------------------------------------------------------------\n");
                            }
                            break;

                        //Apaga item na posição desejada da lista.
                        case 'n':

                            //Mostra a Lista para o usuario ter uma referência
                            System.out.println("Aqui tem a Lista com todos os seus Itens:");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }

                            if (nItens > 0) {
                                System.out.println("Digite a posição do item a ser apagado:");
                                int posicao = scanner.nextInt();

                                if (posicao >= 0 && posicao < nItens) {
                                    // Remove o item na posição especificada e reorganiza a lista
                                    for (int i = posicao; i < nItens - 1; i++) {
                                        nome[i] = nome[i + 1];
                                        quanto[i] = quanto[i + 1];
                                        preco[i] = preco[i + 1];
                                        feito[i] = feito[i + 1];
                                    }
                                    nItens--;
                                    System.out.println( "┏------------------------------------------┒\n"
                                            +   "  Item na posição " + posicao + " removido com sucesso!  \n"
                                            +   "┗------------------------------------------┛\n");

                                } else {
                                    System.out.println( "┏--------------------------------------┒\n"
                                            +   "|            Posição inválida          |\n"
                                            +   "┗--------------------------------------┛\n");
                                }
                            } else {
                                System.out.println( "┏--------------------------------------┒\n"
                                        +   "|  A lista está vazia! Nada a remover. |\n"
                                        +   "┗--------------------------------------┛\n");
                            }

                            //Lista atualizada com todas as mudanças
                            System.out.println("Aqui tem a sua lista atualizada! ");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            System.out.println("\n---------------------------------------------------------------\n");
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

                                //Verifica se as posições são válidas e calcula as posições que foram removidas
                                if (pInicial >= 0 && pFinal < nItens && pInicial <= pFinal) {
                                    int qRemovidos = pFinal - pInicial + 1;

                                    //Remove os itens da lista e desloca os outros para preencher os espaços vazios
                                    for (int i = 0; i < nItens - qRemovidos; i++) {
                                        if (i < pInicial) {
                                            continue;
                                        }
                                        nome[i] = nome[i + qRemovidos];
                                        quanto[i] = quanto[i + qRemovidos];
                                        preco[i] = preco[i + qRemovidos];
                                        feito[i] = feito[i + qRemovidos];
                                    }
                                    //Atualiza o número de itens
                                    nItens -= qRemovidos;

                                    System.out.println( "┏--------------------------------------------------┒\n"
                                            +   "  Itens da posição " + pInicial + " à posição " +pFinal + " foram removidos.  \n"
                                            +   "┗--------------------------------------------------┛\n");

                                } else {
                                    System.out.println( "┏--------------------------------------┒\n"
                                            +   "|         Posições inválidas.          |\n"
                                            +   "┗--------------------------------------┛\n");
                                }
                            } else {
                                System.out.println( "┏--------------------------------------┒\n"
                                        +   "|         A lista está vazia.          |\n"
                                        +   "┗--------------------------------------┛\n");
                            }

                            //Lista atualizada com todas as mudanças
                            System.out.println("Aqui tem a sua lista atualizada! ");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            System.out.println("\n---------------------------------------------------------------\n");

                            break;

                        case 'L':
                            //Lista com todos os itens
                            System.out.println("Aqui tem a Lista com todos os seus Itens:");
                            System.out.printf("%s   %-25s  %-10s  %-8s  %-8s\n", " ", "Item", "Quantidade", "Preço", "Comprado");
                            for (int i = 0; i < nItens; i++) {
                                char marcado = feito[i] ? 'x' : ' ';
                                System.out.printf("%d:  %-25s  %-10.2f  %-8.2f  %-8c\n", i, nome[i], quanto[i], preco[i], marcado);
                            }
                            System.out.println("\n---------------------------------------------------------------\n");
                            break;
                        case 'V': //Voltar
                            break;
                        default:
                            System.out.println( "┏------------------------------------------┒\n"
                                    +   "|              Opção Inválida!             |\n"
                                    +   "┗------------------------------------------┛\n");
                    }
                    break;


                //////////////////////////////////////
                ///// SUBMENU F - FAZER COMPRAS //////
                //////////////////////////////////////

                case 'F':

                    System.out.println(fazerCompras);
                    char opFazerCompras = scanner.next().charAt(0);
                    switch (opFazerCompras) {

                        //Marcar o primeiro item como "comprado"
                        case 'M':
                            //Verifica se há itens na lista
                            if (nItens > 0) {
                                //Percorre a lista de itens e verifica se o item já está marcado como comprado
                                for (int i = 0; i < nItens; i++) {
                                    if (!feito[i]) {
                                        feito[i] = true;
                                        System.out.println( "┏--------------------------------------------------┒\n"
                                                +   "    "+ nome[i] + " está marcado como comprado!  \n"
                                                +   "┗--------------------------------------------------┛\n");
                                        break;
                                    }
                                }
                            } else {
                                System.out.println( "┏--------------------------------------┒\n"
                                        +   "|          A lista está vazia!         |\n"
                                        +   "┗--------------------------------------┛\n");
                            }
                            break;

                        //Desmarca o primeiro item comprado
                        case 'D':
                            boolean primeiroItemMarcado = false;
                            for (int i = 0; i < nItens; i++) {

                                //Verifica se o item está marcado como comprado
                                if (feito[i]) {
                                    feito[i] = false;

                                    System.out.println( "┏----------------------------------------┒\n"
                                            +   "        "+ nome[i] + " foi desmarcado.  \n"
                                            +   "┗----------------------------------------┛\n");
                                    primeiroItemMarcado = true;
                                    break;
                                }
                                if (!primeiroItemMarcado) {
                                    System.out.println( "┏------------------------------------------┒\n"
                                            +   "|  Nenhum item está marcado como comprado! |\n"
                                            +   "┗------------------------------------------┛\n");
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

                            //faz um ciclo para encontrar o item correspondente ao nome fornecido
                            for (int i = 0; i < nItens; i++) {
                                if (nome[i].length() > 0 && nome[i].charAt(0) == nomeItem.charAt(0)) {
                                    //altera o estado do item entre "comprado" e "por comprar"
                                    feito[i] = !feito[i];
                                    String estado = feito[i] ? "comprado" : "por comprar";
                                    System.out.println( "┏--------------------------------------------------┒\n"
                                            +   "     "+nome[i] + " está agora " + estado + "!\n"
                                            +   "┗--------------------------------------------------┛\n");
                                    encontrado = true;
                                    break;
                                }
                            }

                            if (!encontrado) {
                                System.out.println( "┏------------------------------------------┒\n"
                                        +   "|       Item não encontrado na lista!      |\n"
                                        +   "┗------------------------------------------┛\n");
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

                            // Verifica se a posição fornecida é válida
                            if (posicao < 0 && posicao >= nItens) {
                                System.out.println( "┏------------------------------------------┒\n"
                                        +   "|            Posição Inválida!             |\n"
                                        +   "┗------------------------------------------┛\n");
                            } else {

                                // Marca ou desmarca o item na posição especificada
                                feito[posicao] = !feito[posicao];
                                String estado = feito[posicao] ? "comprado" : "por comprar";
                                System.out.println( "┏-----------------------------------------┒\n"
                                                +   "  "+nome[posicao] + " está agora " + estado + "!\n"
                                                +   "┗-----------------------------------------┛\n");
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
                                    System.out.println("\n---------------------------------------------------------------\n");
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
                                    System.out.println("\n---------------------------------------------------------------\n");
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
                                    System.out.println("\n---------------------------------------------------------------\n");
                                    break;
                            }
                            break;
                        case 'V':
                            break;
                        default:
                            System.out.println( "┏------------------------------------------┒\n"
                                    +   "|              Opção Inválida!             |\n"
                                    +   "┗------------------------------------------┛\n");
                    }
                    break;

                //////////////////////////////////////
                ////// SUBMENU c - FAZER CONTAS //////
                //////////////////////////////////////

                case 'c':

                    System.out.println(fazerContas);
                    char opFazerContas = scanner.next().charAt(0);
                    double total = 0.0;
                    //Faz a operação para calcular o total da lista
                    for(int i = 0; i < nItens; i++){
                        total += preco[i]*quanto[i];
                    }
                    switch (opFazerContas)
                    {

                        //Imprime o calculo feito para o total na linha 493
                        case 'l':

                            System.out.println( "┏----------------------------------------------┒\n"
                                    +   "       O valor total da lista é:  "+ total +" €.   \n"
                                    +   "┗---------------------------------------------┛\n");
                            break;

                        //Faz a operação para calcular o valor gasto
                        // Calcula o valor total gasto somando a quantidade multiplicada pelo preço de cada item marcado como comprado
                        case 'g':
                            double gasto = 0.0;

                            for (int i = 0; i < nItens; i++) {
                                if (feito[i]) {
                                    gasto += quanto[i] * preco[i];
                                }
                            }
                            System.out.println( "┏----------------------------------------------┒");
                            System.out.printf("        O valor total gasto é: %.2f€\n", gasto);
                            System.out.println( "┗----------------------------------------------┛\n");

                            break;

                        //Faz a operação para calcular quanto custa o que ainda não foi comprado
                        case 'f':
                            double falta = 0.0;

                            //Calcula o valor total do que falta comprar somando a quantidade multiplicada pelo preço de cada item não marcado como comprado
                            for (int i = 0; i < nItens; i++) {
                                if (!feito[i]) {
                                    falta += quanto[i] * preco[i];
                                }
                            }
                            System.out.println( "┏------------------------------------------------------┒");
                            System.out.printf("   O valor total do que falta comprar é: %.2f\n", falta);
                            System.out.println( "┗------------------------------------------------------┛\n");
                            break;

                        //Faz a operação para calcular o preço médio por item
                        case 'm':
                            if (nItens > 0) {
                                double precoMedio = total / nItens;

                                System.out.println( "┏-------------------------------------------------┒");
                                System.out.printf("      O preço médio por item é: %.2f\n", precoMedio);
                                System.out.println( "┗-------------------------------------------------┛\n");
                            } else {
                                System.out.println( "┏-----------------------------------------------------------┒\n"
                                        +   "| A lista está vazia. Não é possível calcular o preço médio.|\n"
                                        +   "┗-----------------------------------------------------------┛\n");
                            }
                            break;

                        default:
                            System.out.println( "┏------------------------------------------┒\n"
                                    +   "|              Opção Inválida!             |\n"
                                    +   "┗------------------------------------------┛\n");
                            break;
                    }
                    break;

                //////////////////////////////////////
                //// SUBMENU S - FECHAR PROGRAMA /////
                //////////////////////////////////////

                case 'S':
                    System.out.println( "┏------------------------------------------┒\n"
                            +   "|             Saiu do Programa.            |\n"
                            +   "┗------------------------------------------┛\n");
                    break;
                default:
                    System.out.println( "┏------------------------------------------┒\n"
                                    +   "|              Opção Inválida.             |\n"
                                    +   "┗------------------------------------------┛\n");
            }
        }
        while (op != 'S');
    }
}