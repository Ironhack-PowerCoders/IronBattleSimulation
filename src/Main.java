import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String[] args) {
        Character hero = null;
        Character opponent = null;
        Scanner input = new Scanner(System.in);
        //Selección del primer personaje

        System.out.println("Witch character do you want to be ? Press 1 o 2" + "\n 1. Warrior" + "\n 2. Wizard");
        String classe = input.nextLine();
        int i = Integer.parseInt(classe);
        System.out.println("Witch name will have your hero ? ");
        String name = input.nextLine();
        if (i == 1) {
            hero = new Warrior(name);
        } else {
            hero = new Wizard(name);
        }
        System.out.println(hero.toString());

        //Selección del segundo personaje.
        System.out.println("Who will be your foe ? press 1 o 2" + "\n 1. Warrior" + "\n 2. Wizard");
        classe = input.nextLine();
        i = Integer.parseInt(classe);
        System.out.println("Witch name has this bastard ? ");
        name = input.nextLine();
        if (i == 1) {
            opponent = new Warrior(name);
        } else {
            opponent = new Wizard(name);
        }
        System.out.println("And the rival will be \n" + opponent.toString());

        //Batalla y Resultado.
        int counter = 1;
        System.out.println("()xxxx[{::::::::::::::::::>  FIIIGHT! ! ! <::::::::::::::::::}]xxxx() ");

        while (hero.isAlive() && opponent.isAlive()) {
            System.out.println("()=()=()=()=()=()=()=()=()=() Round " + counter + " ()=()=()=()=()=()=()=()=()=() \n");
            ((Attacker) hero).attack(opponent);
            ((Attacker) opponent).attack(hero);
            counter++;
            System.out.println(ANSI_BLUE + "\n ====000====OOO========000====OOO========000====OOO========000====OOO========000====OOO==== \n" + ANSI_RESET);
        }
        if (!hero.isAlive())

            System.out.println(ANSI_YELLOW + opponent.getName() + " is the winner." + ANSI_RESET);
        else if (!opponent.isAlive())
            System.out.println(ANSI_YELLOW + hero.getName() + " winner, winner, chicken dinner" + ANSI_RESET);
        else
            System.out.println(ANSI_YELLOW + "BOTH DIEEEEE, EVERYONE IS HAPPY" + ANSI_RESET);
    }
}




