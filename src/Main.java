import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character hero = null;
        Character opponent = null;
        Scanner input = new Scanner(System.in);

        System.out.println("Que personage quieres crear ? Marca 1 o 2" + "\n 1. Warrior" +"\n 2. Wizard");
        String classe = input.nextLine();
        int i = Integer.parseInt(classe);
        System.out.println("Que nombre tiene tu heroe ? ");
        String name = input.nextLine();
        if(i == 1){
            hero = new Warrior(name);
        }else {hero = new Wizard(name);}

        System.out.println("Contra que classe quieres que luche tu heroe ? Marca 1 o 2" + "\n 1. Warrior" +"\n 2. Wizard");
        classe = input.nextLine();
        i = Integer.parseInt(classe);
        System.out.println("Que nombre tiene tu oponente ? ");
        name = input.nextLine();
        if(i == 1){
            opponent = new Warrior(name);
        }else {opponent = new Wizard(name);}

        System.out.println("Que empieze la batalla! !");
        while(hero.isAlive() || hero.getHp() >=0|| opponent.isAlive()|| opponent.getHp() >= 0){
            ((Attacker) hero).attack(opponent);
            ((Attacker) opponent).attack(hero);
        }
    }
}