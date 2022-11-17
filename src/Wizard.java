import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    private int manaCounter;

    public Wizard(String name) {
        super(name, new Random().nextInt(100 - 50 + 1) + 50);
        setMana();
        setIntelligence();
    }

    public int getMana() {
        return mana;
    }

    public void setMana() {
        Random random = new Random();
        this.mana = random.nextInt(50 - 10 + 1) + 10;

        this.manaCounter = this.mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence() {
        Random random = new Random();
        this.intelligence = random.nextInt(50 - 1 + 1) + 1;

    }
    public int getManaCounter() {
        return manaCounter;
    }

    public void setManaCounter(int manaCounter) {
        this.manaCounter = manaCounter;
    }

    @Override
    public void attack(Character defender) {
        Random random = new Random();
        int attack = random.nextInt(2 - 1 + 1) + 1;

        //ataque poderoso, bola de fuego de 4d6
        if (attack == 1 && (getManaCounter() - 5) > 0) {
            setManaCounter(getManaCounter() - 5);
            if (defender.getHp() - getIntelligence() > 0) {
                defender.reduceHp(defender.getHp() - getIntelligence());
                System.out.println(Main.ANSI_PURPLE +"༼つಠ益ಠ༽つ ─=≡ΣO))"+ Main.ANSI_RESET);
                System.out.println(Main.ANSI_PURPLE + getName()+ " cast an impressive Fireball dealing "
                        + getIntelligence() + ". "+ defender.getName() + " is alive with "+ defender.getHp()+".\n"+ Main.ANSI_RESET);

            } else {
                defender.setAlive(false);
                System.out.println(defender.getName() + " DIED ! ! ! ");
            }
        //descanso y a beber poti
        } else if (getManaCounter() == 0) {
            setManaCounter(getManaCounter() + 2);
            System.out.println(Main.ANSI_PURPLE +"(ᕗ ͠° ਊ ͠° )ᕗ"+ Main.ANSI_RESET);
            System.out.println(Main.ANSI_PURPLE +"sip of water for " + getName()+".\n"+ Main.ANSI_RESET);
        //ataque de bastón
        } else {
            setManaCounter(getManaCounter() + 1);
            if (defender.getHp() - (getIntelligence() / 2) > 0) {
                defender.reduceHp(defender.getHp() - (getIntelligence() / 2));
                System.out.println(Main.ANSI_PURPLE +"(ง •̀_•́)ง"+ Main.ANSI_RESET);
                System.out.println(Main.ANSI_PURPLE +"What a shameful hit from " +getName()+ ". The defender is alive with " +defender.getHp()+".\n"+ Main.ANSI_RESET);
            } else {
                defender.setAlive(false);
                System.out.println(defender.getName() + " DIED ! ! ! ");
            }
        }
    }

    @Override
    public String toString() {
        return Main.ANSI_CYAN+"Wizard called " + getName() + "\n"
                + "graded in WinterHold with the grade of " + intelligence + "\n" +
                "and a mana pool of " + mana + "\n"
                + "with a hp of " + super.getHp() + Main.ANSI_RESET;


    }
}

