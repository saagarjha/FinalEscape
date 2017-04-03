import java.awt.Color;

public class Coder extends Character {

	public Coder(Map map, int x, int y) {
		super(map, x, y, "Coder", 5);
		setColor(Color.BLUE);
	}

	@Override
	public boolean canMoveHere(int x, int y) {
		MapComponent componentThere = getMap().get(x, y);
		Inventory inventory = getInventory();

		if (componentThere == null)
			return true;
		else if (componentThere instanceof ItemComponent) {
			if (inventory.size() < inventory.capacity())
				inventory.add(((ItemComponent)componentThere).getItem());
			else if (componentThere.getName().equals("Laptop"))
				inventory.set(inventory.getSelectedItemIndex(),
					((ItemComponent)componentThere).getItem());
			return true;
		} else return !componentThere.isSolid();
	}

	@Override
	public void destroy() {
		System.out.println("Game over!");
		System.exit(0);
	}
}