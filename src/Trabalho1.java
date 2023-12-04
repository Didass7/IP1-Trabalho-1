import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
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
                    switch (opEditarLista) {

                        //Insere um novo item à lista :D
                        case 'I':
                            System.out.println("Insira um item novo para a lista.\n");
                                String novoItem = scanner.nextLine();
                                nome [nItens]= novoItem;
                                nItens++;

                            break;

                        //Insere um item numa posição escolhida
                        case 'p':
                            for (int i = 0; i < nItens; i++) {
                                System.out.printf("%d \t %s \n", (i + 1), nome [i]);


                            }

                            break;
                        case 'A':
                            System.out.println("Apagar último item inserido na lista.");
                            break;
                        case 'n':
                            System.out.println("Apagar item na posição n da lista.");
                            break;
                        case 'a':
                            System.out.println("Apagar itens da posição m à n da lista.");
                            break;

                            //////////////////////////////////////
                            ////// SUB-SUBMENU L - Listagem //////
                            //////////////////////////////////////

                        case 'L':
                            System.out.println(listar);
                            char opLista = scanner.next().charAt(0);
                            switch (opLista) {
                                case 't':
                                    System.out.println("Listar todos os itens.");
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
        } while (op != 'S');
    }
}