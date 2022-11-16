import java.util.Random;

public class Wizard extends Character implements Attacker{
    private int mana;
    private int intelligence;
    private int hp;
    private int manaCounter;

    public Wizard(String name) {
        super(name);
        setMana();
        setIntelligence();
        setHp();
    }

    public int getMana() {
        return mana;
    }

    public void setMana() {
        Random random = new Random();
        this.mana = random.nextInt(50-10+1)+10;
        System.out.println("mana "+this.mana);
        this.manaCounter = this.mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence() {
        Random random = new Random();
        this.intelligence = random.nextInt(50-1+1)+1;
        System.out.println("intelligence "+this.intelligence);
    }

    public void setHp() {
        Random random = new Random();
        this.hp = random.nextInt(100-50+1)+50;
        System.out.println("hp "+this.hp);
    }

    public int getHp() {
        return hp;
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
        int attack = random.nextInt(2-1+1)+1;

        if(attack == 1 && (getManaCounter() -5) > 0){
            setManaCounter(getManaCounter()-5);
            if(defender.getHp() - getIntelligence() > 0){
                defender.reduceHp(defender.getHp() - getIntelligence());
            }else{
                defender.reduceHp(defender.getHp() - getIntelligence());
                defender.setAlive(false);
                System.out.println(defender.getName() + " DIED ! ! ! ");
            }
        }else{
            setManaCounter(getManaCounter()+1);
            if(defender.getHp()-(getIntelligence()/2) > 0){
                defender.reduceHp(defender.getHp() - (getIntelligence()/2));
            } else{
                defender.reduceHp(defender.getHp() - (getIntelligence()/2));
                defender.setAlive(false);
                System.out.println(defender.getName() + " DIED ! ! ! ");
            }
        }
    }
}

