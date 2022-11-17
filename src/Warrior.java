import java.util.Random;

class Warrior extends Character implements Attacker{
private int stamina;
private int strength;


private String name;
private int staminaCounter;

    public Warrior(String name) {
        super(name, (int) Math.round(Math.random() * ((200 - 100) + 100) + 100));
        setStamina();
        setStrength();
    }

    public int getStamina() {
        return stamina;
    }


    public void setStamina() {
        double randomStamina = Math.random()*((50-10)+1)+10;
        this.stamina = (int) Math.round(randomStamina);
        this.staminaCounter = this.stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength() {
        double randomStrength = Math.random()*((10-1)+1)+1;
        this.strength = (int) Math.round(randomStrength);
    }

    public int getStaminaCounter() {
        return staminaCounter;
    }

    public void setStaminaCounter(int staminaCounter) {
        this.staminaCounter = staminaCounter;
    }



    @Override
    public void attack(Character defender) {
        //randomizar que ataque saldra, heavy o light.
        Random random = new Random();
        int attack = random.nextInt(2-1+1)+1;

        //si el ataque es poderoso...
        if(attack == 1 && (getStaminaCounter()-5) >= 0){
            setStaminaCounter(getStaminaCounter()-5);
            if(defender.getHp()-getStrength() > 0){
                defender.reduceHp(defender.getHp() - getStrength());
                System.out.println(Main.ANSI_RED+"ᕕ(╭ರ╭ ͟ʖ╮•́)⊃¤=(————-"+Main.ANSI_RESET);
                System.out.println(Main.ANSI_RED+"The damage was vicious from "+ getName()+ ". " + defender.getName() + " is still alive with " + defender.getHp()+".\n"+Main.ANSI_RESET);
            }else{
                defender.setAlive(false);
                System.out.println(defender.getName() + " DIED ! ! ! ");
            }
        //descansa porque no tiene stamina
        }else if (getStaminaCounter() == 0){
            setStaminaCounter(getStaminaCounter() + 2);
            System.out.println(Main.ANSI_RED+"(ᕗ ͠° ਊ ͠° )ᕗ"+Main.ANSI_RESET);
            System.out.println(Main.ANSI_RED+getName()+ " eat a piece of fresh flesh.\n"+Main.ANSI_RESET);
        //ataque debil porque tiene menos de 5 y mas que 0
        }else {
            setStaminaCounter(getStaminaCounter() + 1);
            if(defender.getHp()-(getStrength()/2) > 0){
                defender.reduceHp(defender.getHp() - (getStrength()/2));
                System.out.println(Main.ANSI_RED+"¯ºº|(°_o)/¯"+Main.ANSI_RESET);
                System.out.println(Main.ANSI_RED+"The damage was ridiculous. " + defender.getName() + " is still alive with " + defender.getHp()+".\n"+Main.ANSI_RESET);
            } else{
                setAlive(false);
                System.out.println(defender.getName() + " DIED ! ! ! ");
            }
        }
    }

    @Override
    public String toString() {
        return Main.ANSI_CYAN +"Warrior called " + getName() + "\n"
        +"with a strength of " + strength + "\n" +
                "and a stamina to move mountains of " + stamina +"\n"
                +"with a hp of " + super.getHp() + Main.ANSI_RESET;



    }
}
