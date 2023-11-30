//import java.util.ArrayList;
//import java.util.List;
//
//public class Warrior {
//    private String name , Job;
//    private int level , Exp , Max_Exp , Hp , Max_Hp = 100, Atk , Def , mana , Max_mana = 100 , runSpeed;
//    private List<Equipment> Equipments;
//
//    public Warrior(String name, String Job) {
//        this.name = name;
//        this.Job = Job;
//        this.level = 1;
//        this.Exp = 200;
//        this.Max_Exp = 100;
//        this.Hp = this.Max_Hp;
//        this.Atk = 20;
//        this.Def = 25;
//        this.mana = this.Max_mana;
//        this.runSpeed = 10;
//        this.Equipments = new ArrayList<>();
//    }
//    public void equipAccessory(List<Equipment> equipmentList) {
//        for (Equipment equipment : equipmentList){
//            if (equipment.getJob() == null || !equipment.getJob().equals(this.Job)) {
//                System.out.println(this.name + " Can't equip " + equipment.getName());
//            } else {
//                this.Equipments.add(equipment);
//                System.out.println(this.name + " Can put " + equipment.getName());
//            }
//        }
//    }
//
//    public void display(String name , String job){
//        Warrior warrior = new Warrior(name,job);
//        System.out.println("-------------------------------------------");
//        System.out.println("Warrior Stats:");
//        System.out.println("-------------------------------------------");
//        System.out.println("HP: " + warrior.getHp(warrior.getLevel()));
//        System.out.println("ATK: " + warrior.getAtk(warrior.getLevel()));
//        System.out.println("DEF: " + warrior.getDef(warrior.getLevel()));
//        System.out.println("Mana: " + warrior.getMana(warrior.getLevel()));
//        System.out.println("Run Speed: " + warrior.getRunSpeed(warrior.getLevel()));
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
//        return Hp + (10 * level);
//    }
//
//    public int getLevel() {
//        return level;
//    }
//
//    public int getDef(int level) {
//        int accessoryDef = Equipments.stream().mapToInt(Equipment::getDefense).sum();
//        return accessoryDef + (10 * level) + Def;
//    }
//
//    public int getAtk(int level) {
//        int accessoryAtk = Equipments.stream().mapToInt(Equipment::getDamage).sum();
//        return accessoryAtk + (10 * level) + Atk;
//    }
//
//    public int getMana(int level) {
//        int accessoryMana = Equipments.stream().mapToInt(Equipment::getMana).sum();
//        return accessoryMana + (2 * level) + mana;
//    }
//
//    public int getRunSpeed(int level) {
//        int accessorySpeed = Equipments.stream().mapToInt(Equipment::getSpeed).sum();
//        return (level) + runSpeed - (accessorySpeed);
//    }
//}