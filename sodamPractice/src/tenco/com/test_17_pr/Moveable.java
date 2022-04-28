package tenco.com.test_17_pr;

public interface Moveable {
void left();
void right();
public abstract void up();
default public void down() {}; // ** 구현해도 안해도되고
}
