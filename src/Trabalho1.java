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
        boolean fechar = false;

        while(!fechar) {
            System.out.println(menuPrincipal);
            op = scanner.next().charAt(0);
            scanner.nextLine();
            switch (op) {
                case 'E':
                    System.out.println(editarLista);
                    break;
                case 'F':
                    System.out.println(fazerCompras);
                    break;
                case 'c':
                    System.out.println(fazerContas);
                    break;
                case 'S':
                    fechar = true;
                    System.out.println("Saiu do Programa");
            }
        }


        //////////////////////////////////////
        //////// MENU (E)DITAR LISTA /////////
        //////////////////////////////////////

        char opEditarLista;
        do {
            System.out.println(editarLista);
            opEditarLista = scanner.next().charAt(0);

            switch (opEditarLista) {
                case 'I':
                    System.out.println(editarLista);
                    break;
                case 'p':
                    System.out.println(fazerCompras);
                    break;
                case 'A':
                    System.out.println(fazerContas);
                    break;
                case 'n':
                    System.out.println(editarLista);
                    break;
                case 'a':
                    System.out.println(fazerCompras);
                    break;
                case 'L':
                    System.out.println(fazerContas);
                    break;
                case 'V':
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }
        } while (opEditarLista != 'V' && op!='S');
    }
}
