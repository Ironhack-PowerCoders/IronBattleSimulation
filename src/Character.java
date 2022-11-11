public abstract class Character {

    private String name;

    private int hp;

    private String id;

    private boolean isAlive;

    public Character(String name, int hp, String id, boolean isAlive) {
        this.name = name;
        this.hp = hp;
        this.id = id;
        this.isAlive = isAlive;
    }

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

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

}
