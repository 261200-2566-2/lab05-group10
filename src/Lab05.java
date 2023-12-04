import java.util.ArrayList;
import java.util.List;

public class Lab05 {
    public static void main(String[] args) {
        //from 2 base types : Warrior , Mage
        //from 2 base types : Ring , Necklace
        Warrior warrior = new Warrior("ตัวตึง", "Warrior", 100, 100);
        Sword sword = new Sword("ดาบโง่ๆ", "Warrior", 1000, 0, 0, 15);
        Armor armor = new Armor("เกราะโนเกีย","Warrior",0,500,0,20);
        Ring ring = new Ring("แหวน",500,50,100,30);
        warrior.levelUp();
        List<Accessory> accessorieList = new ArrayList<>();
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(sword);
        equipmentList.add(armor);
        accessorieList.add(ring);
        warrior.equipWeapon(equipmentList);
        warrior.levelUp();
        warrior.gainXp(300);
        warrior.levelUp();
        warrior.equipAccessory(accessorieList);
        System.out.println("LevelUp Test");
        Warrior.Display(warrior);
//-----------------------------------------------------------------------------------------------------------------------------------------------
        Mage kiana = new Mage("Kiana", "Mage", 200, 50);
        Weapon kianagun = Weapon.createWeapon("Domain of the void","Mage",600,0,500,25);
        Weapon kianaStigma = Weapon.createWeapon("Honkai queen","Mage",0,1000,6000,0);
        Necklace nl = new Necklace("สร้อยคอ",100,100,50,25);
        List<Equipment> kianaEquipmentlist = new ArrayList<>();
        List<Accessory> kianaaccessorieList = new ArrayList<>();
        kianaEquipmentlist.add(kianaStigma);
        kianaEquipmentlist.add(kianagun);
        kianaaccessorieList.add(nl);
        kiana.levelUp();
        kiana.equipWeapon(kianaEquipmentlist);
        Mage.Display(kiana);
//-----------------------------------------------------------------------------------------------------------------------------------------------
        //Battle
        while (warrior.isAlive() && kiana.isAlive()) {
            warrior.attack(kiana);
            if (kiana.isAlive()) {
                kiana.attack(warrior);
            }
        }
    }
}