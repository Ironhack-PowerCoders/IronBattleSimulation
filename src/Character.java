public abstract class Character {
    private String name;
    private int hp;
    private String id;
    private boolean isAlive;
    private static Integer counter = 0;

    public Character(String name) {
        this.name = name;
        setHp();
        setId();
        this.isAlive = true;
    }
    /*public Character() {
        setName();
        setHp();
        setId();
        this.isAlive = true;
    }*/

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public String getId() {
        return id;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp() {
        this.hp = hp;
    }

    public void setId() {
        this.id = counter.toString();
        counter++;
    }

    protected void reduceHp(int hp) {
        this.hp = hp;
    }

}
