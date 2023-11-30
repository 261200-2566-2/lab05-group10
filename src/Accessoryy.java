public class Accessoryy implements Accessory {
    private String name;
    private int Hp;
    private int DefUp;
    private int Max_manaUp;
    private int speed;

    public Accessoryy(String name, int Hp, int DefUp, int Max_manaUp, int speed) {
        this.name = name;
        this.Hp = Hp;
        this.DefUp = DefUp;
        this.Max_manaUp = Max_manaUp;
        this.speed = speed;
    }

    @Override
    public int getHp() {
        return Hp;
    }

    @Override
    public int getDefense() {
        return DefUp;
    }

    @Override
    public int getMana() {
        return Max_manaUp;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getName() {
        return name;
    }

    public static Accessoryy createAccessory(String name, int Hp, int DefUp, int Max_manaUp, int speed) {
        return new Accessoryy(name, Hp, DefUp, Max_manaUp, speed);
    }
}