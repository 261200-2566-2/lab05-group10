import java.util.ArrayList;
import java.util.List;

public class Lab05 {
    public static void main(String[] args) {
        Character warrior = Character.createCharacter("ตัวตึง", "Warrior", 100, 100);
        Weapon sword = Weapon.createWeapon("ดาบโง่ๆ", "Warrior", 1000, 0, 0, 15);
        Weapon armor = Weapon.createWeapon("เกราะโนเกีย","Warrior",0,500,0,20);
        Accessoryy ring = Accessoryy.createAccessory("แหวน",500,50,100,30);
        warrior.levelUp();
        List<Accessory> accessorieList = new ArrayList<>();
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(sword);
        equipmentList.add(armor);
        accessorieList.add(ring);
        warrior.equipWeapon(equipmentList);
        System.out.println("--------------------------------------------------------");
        System.out.println("ชื่อ: " + warrior.getName());
        System.out.println("อาชีพ: " + warrior.getJob());
        System.out.println("Level: " + warrior.getLevel());
        System.out.println("HP: " + warrior.getHp(warrior.getLevel()));
        System.out.println("Attack: " + warrior.getAtk(warrior.getLevel()));
        System.out.println("Defense: " + warrior.getDef(warrior.getLevel()));
        System.out.println("Mana: " + warrior.getMana(warrior.getLevel()));
        System.out.println("Run Speed: " + warrior.getRunSpeed(warrior.getLevel()));
        System.out.println("Xp: " + warrior.getXp());
        System.out.println("Max xp: " + warrior.getMaxXp());
        System.out.println("--------------------------------------------------------");
        warrior.levelUp();
        warrior.gainXp(300);
        warrior.levelUp();
        warrior.equipAccessory(accessorieList);
        System.out.println("LevelUp Test");
        System.out.println("--------------------------------------------------------");
        System.out.println("ชื่อ: " + warrior.getName());
        System.out.println("อาชีพ: " + warrior.getJob());
        System.out.println("Level: " + warrior.getLevel());
        System.out.println("HP: " + warrior.getHp(warrior.getLevel()));
        System.out.println("Attack: " + warrior.getAtk(warrior.getLevel()));
        System.out.println("Defense: " + warrior.getDef(warrior.getLevel()));
        System.out.println("Mana: " + warrior.getMana(warrior.getLevel()));
        System.out.println("Run Speed: " + warrior.getRunSpeed(warrior.getLevel()));
        System.out.println("Xp: " + warrior.getXp());
        System.out.println("Max xp: " + warrior.getMaxXp());
        System.out.println("--------------------------------------------------------");
        

        Character kiana = Character.createCharacter("Kiana", "Mage", 200, 50);
        Weapon kianagun = Weapon.createWeapon("Domain of the void","Mage",600,0,500,25);
        Weapon kianaStigma = Weapon.createWeapon("Honkai queen","Mage",0,5000,6000,0);

        List<Equipment> kianaEquipmentlist = new ArrayList<>();
        kianaEquipmentlist.add(kianaStigma);
        kianaEquipmentlist.add(kianagun);
        kiana.levelUp();
        kiana.equipWeapon(kianaEquipmentlist);
        System.out.println("--------------------------------------------------------");
        System.out.println("ชื่อ: " + kiana.getName());
        System.out.println("อาชีพ: " + kiana.getJob());
        System.out.println("Level: " + kiana.getLevel());
        System.out.println("HP: " + kiana.getHp(kiana.getLevel()));
        System.out.println("Attack: " + kiana.getAtk(kiana.getLevel()));
        System.out.println("Defense: " + kiana.getDef(kiana.getLevel()));
        System.out.println("Mana: " + kiana.getMana(kiana.getLevel()));
        System.out.println("Run Speed: " + kiana.getRunSpeed(kiana.getLevel()));
        System.out.println("Xp: " + kiana.getXp());
        System.out.println("Max xp: " + kiana.getMaxXp());
        System.out.println("--------------------------------------------------------");
        
        while (warrior.isAlive() && kiana.isAlive()) {
            warrior.attack(kiana);
            if (kiana.isAlive()) {
                kiana.attack(warrior);
            }
        }
    }
}