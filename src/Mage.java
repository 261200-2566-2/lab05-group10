//import java.util.ArrayList;
//import java.util.List;
//
//public class Mage {
//    private String name , Job;
//    private int level , Hp , Exp , Max_Exp , Max_Hp = 100 , Atk , Def , mana , Max_Mana = 200 , runSpeed;
//    private List<Equipment> Equipments;
//
//    public Mage(String name, String Job) {
//        this.name = name;
//        this.Job = Job;
//        this.level = 1;
//        this.Exp = 0;
//        this.Max_Exp = 100;
//        this.Hp = Max_Hp;
//        this.Atk = 10;
//        this.Def = 5;
//        this.mana = Max_Mana;
//        this.runSpeed = 10;
//        this.Equipments = new ArrayList<>();
//    }
//    public void equipAccessory(List<Equipment> equipmentList) {
//        for (Equipment equipment : equipmentList) {
//            if (equipment.getJob() == null || !equipment.getJob().equals(this.Job)) {
//                System.out.println(this.name + " Can't equip " + equipment.getName());
//            } else {
//                this.Equipments.add(equipment);
//                System.out.println(this.name + " Can put " + equipment.getName());
//            }
//        }
//    }
//
//    public void display(String name ,String job ){
//        Mage mage = new Mage(name,job);
//        System.out.println("-------------------------------------------");
//        System.out.println("Mage Stats:");
//        System.out.println("-------------------------------------------");
//        System.out.println("HP: " + mage.getHp(mage.getLevel()));
//        System.out.println("ATK: " + mage.getAtk(mage.getLevel()));
//        System.out.println("DEF: " + mage.getDef(mage.getLevel()));
//        System.out.println("Mana: " + mage.getMana(mage.getLevel()));
//        System.out.println("Run Speed: " + mage.getRunSpeed(mage.getLevel()));
//        System.out.println("-------------------------------------------");
//    }
//
//    public void UpLevel(){
//        while (this.Exp >= this.Max_Exp){
//            this.level++;
//            this.Exp = this.Exp-this.Max_Exp;
//            this.Max_Hp = (int) (this.Max_Exp*1.2);
//        }
//    }
//
//    public int getHp(int level) {
//        return Hp + (5 * level);
//    }
//
//    public int getLevel() {
//        return level;
//    }
//
//    public int getDef(int level) {
//        int accessoryDef = Equipments.stream().mapToInt(Equipment::getDefense).sum();
//        return accessoryDef + (5 * level) + Def;
//    }
//
//    public int getAtk(int level) {
//        int accessoryAtk = Equipments.stream().mapToInt(Equipment::getDamage).sum();
//        return accessoryAtk + (15 * level) + Atk;
//    }
//
//    public int getMana(int level) {
//        int accessoryMana = Equipments.stream().mapToInt(Equipment::getMana).sum();
//        return accessoryMana + (10 * level) + mana;
//    }
//
//    public int getRunSpeed(int level) {
//        int accessorySpeed = Equipments.stream().mapToInt(Equipment::getSpeed).sum();
//        return (level) + runSpeed - accessorySpeed;
//    }
//}