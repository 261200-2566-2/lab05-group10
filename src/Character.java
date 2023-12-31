import java.util.ArrayList;
import java.util.List;

public class Character implements RPGcharactor, Fight {
    private String name, job;
    private int level, hp, maxHp = 1000, atk, def, mana, maxMana = 100, runSpeed;
    private int xp = 0, maxXp = 1000;
    private List<Equipment> equipments;
    private List<Accessory> accessories;

    public Character(String name, String job, int atk, int def) {
        this.name = name;
        this.job = job;
        this.level = 1;
        this.hp = maxHp;
        this.atk = atk;
        this.def = def;
        this.mana = maxMana;
        this.runSpeed = 50;
        this.equipments = new ArrayList<>();
        this.accessories = new ArrayList<>();
    }

    public void equipWeapon(List<Equipment> equipmentList) {
        for (Equipment equipment : equipmentList) {
            if (equipment.getJob() == null || !equipment.getJob().equals(this.job)) {
                System.out.println(this.name + " cannot equip " + equipment.getName());
            } else {
                this.equipments.add(equipment);
                System.out.println(this.name + " equipped " + equipment.getName());
            }
        }
    }

    public void equipAccessory(List<Accessory> accessoryList) {
        this.accessories.addAll(accessoryList);
        accessoryList.forEach(accessory -> System.out.println(this.name + " equipped " + accessory.getName()));
    }

    public void levelUp() {
        this.maxXp = 1000 * level;
        while (this.xp >= this.maxXp) {
            this.level++;
            this.xp = this.xp - this.maxXp;
            this.maxXp = 1000 * (2 * level);
        }
    }

    public int getHp(int level) {
        int accessoryHp = accessories.stream().mapToInt(Accessory::getHp).sum();
        hp =  hp + (10 * level) + accessoryHp;
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public int getDef(int level) {
        int accessoryDef = accessories.stream().mapToInt(Accessory::getDefense).sum();
        int equipmentDef = equipments.stream().mapToInt(Equipment::getDefense).sum();
        def = accessoryDef + equipmentDef + (10 * level) + def;
        return def;
    }

    public int getAtk(int level) {
        int accessoryAtk = equipments.stream().mapToInt(Equipment::getDamage).sum();
        atk = accessoryAtk + (10 * level) + atk;
        return atk;
    }

    public int getMana(int level) {
        int accessoryMana = accessories.stream().mapToInt(Accessory::getMana).sum();
        int equipmentMana = equipments.stream().mapToInt(Equipment::getMana).sum();
        mana = accessoryMana + equipmentMana + (2 * level) + mana;
        return mana;
    }

    public int getRunSpeed(int level) {
        int speedPlus = accessories.stream().mapToInt(Accessory::getSpeed).sum();
        int speedMinus = equipments.stream().mapToInt(Equipment::getSpeed).sum();
        runSpeed = (level) + speedPlus + runSpeed - (speedMinus);
        return runSpeed;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getXp() {
        return xp;
    }

    public int getMaxXp() {
        return maxXp;
    }

    public void gainXp(int n) {
        xp += n;
        levelUp();
    }

    public static Character createCharacter(String name, String job, int atk, int def) {
        return new Character(name, job, atk, def);
    }

    public void attack(Fight opponent) {
        System.out.println(this.name + " attacks " + opponent.getName() + "!");
        opponent.takeDamage(this.getAtk(this.level));
    }

    public void takeDamage(int damage) {
        if (isAlive()) {
            int effectiveDamage = Math.max(0, damage - getDef(this.level));
            hp -= effectiveDamage;

            System.out.println(name + " takes " + effectiveDamage + " damage.");
            System.out.println("Remaining HP: " + hp);
            System.out.println("---------------------------------------");

            if (!isAlive()) {
                System.out.println(name + " has been defeated!");
            }
        }
    }

    public boolean isAlive() {
        return hp > 0;
    }
    public static void Display(Character character){
        System.out.println("--------------------------------------------------------");
        System.out.println("ชื่อ: " + character.getName());
        System.out.println("อาชีพ: " + character.getJob());
        System.out.println("Level: " + character.getLevel());
        System.out.println("HP: " + character.getHp(character.getLevel()));
        System.out.println("Attack: " + character.getAtk(character.getLevel()));
        System.out.println("Defense: " + character.getDef(character.getLevel()));
        System.out.println("Mana: " + character.getMana(character.getLevel()));
        System.out.println("Run Speed: " + character.getRunSpeed(character.getLevel()));
        System.out.println("Xp: " + character.getXp());
        System.out.println("Max xp: " + character.getMaxXp());
        System.out.println("--------------------------------------------------------");
    }
}