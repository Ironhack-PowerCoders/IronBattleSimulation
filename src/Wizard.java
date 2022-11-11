import java.util.Random;

public class Wizard extends Character{

    private int mana;
    private int intelligence;
    private int hp;

    public Wizard(String name, String id, boolean isAlive) {
        super(name, id, isAlive);
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
    }

