public interface Fight {
    void attack(Fight opponent);
    void takeDamage(int damage);
    boolean isAlive();
    String getName();
}
