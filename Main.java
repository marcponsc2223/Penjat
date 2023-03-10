hola hola
package sample;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        //Creamos matriz de String con 30 valores que se especifican en la funcion introduceParaula.
        String[] paraules = new String[30];
        Scanner lletra = new Scanner(System.in);
        menu();
        introduceParaula(paraules, lletra);
    }
    //FUNCION menu.
    private static void menu() {
        System.out.println("ESTO ESTA HECHO CON GIT");
        System.out.println("ESTO ESTA HECHO CON GIT");
        System.out.println("ESTO ESTA HECHO CON GIT");
        System.out.println("ESTO ESTA HECHO CON GIT");
        System.out.println("ESTO ESTA HECHO CON GIT");
	System.out.println("HECHO CON GIT");
        System.out.println("Benvilgut a EL PENJAT");
        System.out.println("El joc consisteix en que tens que endevinar una paraula, tendrás que escriure lletres fins tindre la paraula completa, però cura, no és tan facil, si falles s'anirà creant el penjat, i si es crea del tot, perderes, tens 6 fallades, bona sort!!");
        System.out.println("Aqui tens un exemple del penjat acabat: ");
        System.out.println(" +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " / \\  |\n" +
                "      |\n" +
                "=========");
        System.out.println("Comença la partida...");
    }
    //FUNCION introduceParaula.
    private static void introduceParaula(String[] paraules, Scanner lletra) {
        //Creamos la matriz de Strings con 30 palabras.
        String[] paraules2 = {"palometas", "llegums", "persona", "taula", "cadira", "pilota", "sabates", "sol", "lluna", "videojoc", "gos", "gat", "conill", "formatge", "ratoli", "samarreta", "pantalons", "escombreries", "treballador", "professor", "mare", "pare", "amic", "amiga", "germa", "germana", "dona", "home", "comida", "finestra"};
        //Creamos el randomizer con la variable palabraAleatoria.
        Random palabraAleatoria = new Random();
        //Indicamos que queremos que eliga un numero del 1 al 29.
        int paraula = palabraAleatoria.nextInt(29 - 1) + 1;
        //Llamamos a la funcion adivinarParaula.
        adivinarParaula(paraules2, lletra, paraula);
    }
    //FUNCION adivinarParaula.
    private static void adivinarParaula(String[] paraules2, Scanner lletra, int paraula) {
        //Creamos una matriz de letras que el tamaño es igual que la longitud de la palabra.
        Character[] matriz =new Character[paraules2[paraula].length()];
        //Creamos y inicializamos variables.
        int exit = 0;
        int errorCount = 0;
        char letter;
        int aciertos = 0;
        int salir=0;
        //Rellenar matriz con -.
        for (int j = 0; j < paraules2[paraula].length(); j++) {
            matriz[j]='_';
        }
        //Bucle principal.
        do {
            //Mostrar la matriz.
            for (int z = 0; z < paraules2[paraula].length(); z++) {
                System.out.print(matriz[z]);
            }
            //Pedir la letra.
            System.out.print("\nEscriu una lletra de la paraula: ");
            letter = lletra.next().toLowerCase().charAt(0);
            //Bucle para buscar la letra en la palabra y modificar la matriz.
            for (int j = 0; j < paraules2[paraula].length(); j++) {
                //He colocado alguna letra o no?.
                if (paraules2[paraula].charAt(j)==letter) {
                    matriz[j]=letter;
                    aciertos++;
                    salir=j;
                }
            }
            //No he colocado la letra, con los mensajes de error.
            if(!(paraules2[paraula].charAt(salir)==letter)){
                switch (errorCount) {
                    case 0:
                        System.out.println("+---+\n" +
                                "  |   |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "=========");
                        exit++;
                        break;
                    case 1:
                        System.out.println(" +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "=========");
                        exit++;
                        break;
                    case 2:
                        System.out.println(" +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                "  |   |\n" +
                                "      |\n" +
                                "      |\n" +
                                "=========");
                        exit++;
                        break;
                    case 3:
                        System.out.println("+---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|   |\n" +
                                "      |\n" +
                                "      |\n" +
                                "=========");
                        exit++;
                        break;
                    case 4:
                        System.out.println("+---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|\\  |\n" +
                                "      |\n" +
                                "      |\n" +
                                "=========");
                        exit++;
                        break;
                    case 5:
                        System.out.println(" +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|\\  |\n" +
                                " /    |\n" +
                                "      |\n" +
                                "=========");
                        exit++;
                        break;
                    case 6:
                        System.out.println(" +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|\\  |\n" +
                                " / \\  |\n" +
                                "      |\n" +
                                "=========");
                        exit++;
                        break;
                }
                System.out.println("Tens "+exit+"/6 errors");
                errorCount++;
            }
        } while (aciertos<paraules2[paraula].length()&&exit != 6) ;
        if (!(aciertos < paraules2[paraula].length())) {
            System.out.println("\033[0;1m" + "    Felicitats, has guanyat el joc :) !!!" + "\033[0m");
            win();
            System.out.println("Has tingut un total de " + exit + "/6" + " errors");
            System.out.println("La paraula era: "+"\033[0;1m"+paraules2[paraula]+ "\033[0m");
        } else {
            System.out.println("No has guanyat pero ánim, que segur que si tornes a intentar-ho guanyes:) ...");
            loose();
            System.out.println("La paraula era: "+"\033[0;1m"+paraules2[paraula]+ "\033[0m");
        }

    }
    //FUNCION win.
    private static void win() {
        String win="⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                 ⠀⠀                       ⣠⡿⠛⢶⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣦⠀⣠⡾⠛⠙⠛⠋⠀⠀⠀⠈⠉⠛⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢾⡇⠙⠛⠋⢀⣤⣀⠀⣀⣤⣤⡀⠀⠀⠀⠈⠻⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣧⡀⢀⡤⠋⠀⠈⠉⠉⠀⠉⠳⠤⠤⠴⢦⡄⠸⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣀⡿⠿⠾⠀⠀⠀⠀⠀⢴⣦⡀⠀⠀⠀⣠⠟⠀⢹⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⡟⠀⣴⡄⠀⢀⡄⠀⠀⣦⡈⠃⠀⠀⡾⣳⣄⠀⣼⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⠀⠀⠀⠀⠀⣠⡶⠟⠻⠶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⠀⠀⠿⠁⢀⡞⠁⠀⠀⣿⠗⠀⠀⠀⣟⢮⣿⣆⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⠀⠀⠀⠀⢸⠏⠀⠀⠀⣰⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⡇⠀⠀⠀⠰⣯⡀⠀⠀⠀⠀⠀⠀⠀⠀⠪⣳⡵⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⠀⠀⠀⠀⢸⡀⠀⠀⢰⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣇⠀⣦⣀⠀⠈⠉⢀⣀⣰⣦⡀⠀⠀⠀⠀⠈⠉⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⠀⠀⠀⠀⠘⣷⠀⠀⠘⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡆⠻⠦⣌⣉⣉⣁⡤⠔⠻⡇⠀⠀⠀⣀⣠⣼⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⢠⡾⠛⠉⠙⠛⠲⢦⣄⠀⠙⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣄⠀⠀⠲⠇⠀⠀⠀⠀⠀⠀⢀⣴⢏⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⢸⣇⣀⣀⣀⡀⠀⠀⠈⣧⠀⠈⣿⣦⣄⡀⠀⠀⠀⠀⠀⠀⢀⣻⣦⣄⠀⠀⠀⠀⠀⠀⡠⠔⣿⠓⢶⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                    ⢸⠟⠁⠀⠈⠉⠙⠳⢴⡏⠀⠀⣿⡇⠈⠙⠻⠶⠤⠴⠶⠛⠋⠹⡀⠈⠻⣶⣤⠤⠄⣀⣠⠞⠁⠀⢸⠀⠈⠙⠳⢦⣄⠀⠀⠀⠀⠀⠀\n" +
                "                    ⠸⣧⣤⣤⣤⣤⣀⡀⠀⣷⢀⣼⠃⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢦⣀⠀⠉⠉⠉⠉⠀⠀⢀⣴⠏⠀⠀⠀⠀⠀⠉⠻⣦⣄⠀⠀⠀\n" +
                "                    ⢰⡏⠀⢠⠀⠀⠈⠉⢺⠁⢈⡞⢀⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠒⢦⠀⠀⠀⢸⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⡄⠀⠀\n" +
                "                    ⠀⠻⣦⣈⠙⠶⠤⠴⢞⣠⠞⢀⡞⠀⠀⠀⠀⠀⠀⠀⠀⢀⣦⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠈⡆⠀⠀⠀⢰⠀⠀⠀⠀⠀⠀⠀⠈⠻⣆⠀\n";
        System.out.println(win);
    }
    //FUNCION loose.
    private static void loose() {
        String loose="⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                 ⠀⠀                                            ⣠⡿⠛⢶⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
                "                                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣦⠀⣠⡾⠛⠙⠛⠋⠀⠀⠀⠈⠉⠛⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢾⡇⠙⠛⠋⢀⣤⣀⠀⣀⣤⣤⡀⠀⠀⠀⠈⠻⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣧⡀⢀⡤⠋⠀⠈⠉⠉⠀⠉⠳⠤⠤⠴⢦⡄⠸⣷⠀⠀⠀⠀⠀⠀⠀\n" +
                "                                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣀⡿⠿⠾⠀⠀⠀⠀⠀⢴⣦⡀⠀⠀⠀⣠⠟⠀⢹⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⡟⠀⣴⡄⠀⢀⡄⠀⠀  ⠀⠀⡾⣳⣄⠀⣼⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                                        ⠀⠀⠀⠀⠀      ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⠀⠀⠿⠁⢀⡞⠁⠀⠀--⠀⠀⠀⣟⢮⣿⣆⣿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                                        ⠀⠀⠀⠀        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⡇⠀⠀⠀⠰⣯⡀⠀⠀⠀⠀⠀⠀⠀⠀⠪⣳⡵⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                                        ⠀⠀⠀⠀       ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣇⠀⣦⣀⠀⠈⠉⢀⣀⣰⣦⡀⠀⠀⠀⠀⠈⠉⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                                        ⠀⠀⠀⠀        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡆⠻⠦⣌⣉⣉⣁⡤⠔⠻⡇⠀⠀⠀⣀⣠⣼⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                                                      ⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣄⠀⠀⠲⠇⠀⠀⠀⠀⠀⠀⢀⣴⢏⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                                                        ⠀⠀⠀⠀⠀⠀⢀⣻⣦⣄⠀⠀⠀⠀⠀⠀⡠⠔⣿⠓⢶⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
        System.out.println(loose);
    }
}

