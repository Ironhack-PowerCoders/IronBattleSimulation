import java.util.Random;

class Warrior extends Character implements Attacker{
private int stamina;
private int strength;
private int hp;
private String name;
private int staminaCounter;

    public Warrior(String name) {
        super(name);
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
    public void setHp() {
        double randomHP = Math.random()*((200-100)+100)+100;
        this.hp = (int) Math.round(randomHP);
        super.setHp();
    }
    @Override
    public void attack(Character defender) {
        Random random = new Random();
        int attack = random.nextInt(2-1+1)+1;

        if(attack == 1 && (getStaminaCounter()-5) > 0){
            setStaminaCounter(getStaminaCounter()-5);
            if(defender.getHp()-getStrength() > 0){
                defender.reduceHp(defender.getHp() - getStrength());
            }else{
                defender.reduceHp(defender.getHp() - getStrength());
                defender.setAlive(false);
                System.out.println(defender.getName() + " DIED ! ! ! ");
            }
        }else{
            setStaminaCounter(getStaminaCounter()+1);
            if(defender.getHp()-(getStrength()/2) > 0){
                defender.reduceHp(defender.getHp() - (getStrength()/2));
            } else{
                defender.reduceHp(defender.getHp() - (getStrength()/2));
                setAlive(false);
                System.out.println(defender.getName() + " DIED ! ! ! ");
            }
        }
    }
}
