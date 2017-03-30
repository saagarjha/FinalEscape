import java.awt.Color;

public class Coder extends Character {

	private Inventory inventory;

	public Coder(Map map, int x, int y) {
		super(map, x, y, "Coder");
		inventory = new Inventory();
		setColor(Color.BLUE);
	}
}