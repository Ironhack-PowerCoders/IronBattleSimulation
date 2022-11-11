import java.math.BigInteger;
import java.util.Random;

class Warrior extends Character{

private int stamina;
private int randomStamina;
private int strenght;
private int randomStrenght;

private int hp;
private String name;


    public Warrior(String name) {
        super(name);
        setStamina();
        setStrenght();
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina() {
        double randomStamina = Math.random()*((50-10)+1)+10;

        this.stamina = (int) Math.round(randomStamina);
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght() {
        double randomStrenght = Math.random()*((10-1)+1)+1;
        this.strenght = (int) Math.round(randomStrenght);

    }

    @Override
    public void setHp() {
        double randomHP = Math.random()*((200-100)+100)+100;
        this.hp = (int) Math.round(randomHP);
        super.setHp();
    }
}
