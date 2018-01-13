import java.util.ArrayList;

public class BlockConfiguration {
	
	protected ArrayList<Block> blocks = new ArrayList<Block>();
	
	public BlockConfiguration(String config) {
		
		if(config.equals("6X3")) {
			sixByThree();
		}
	}

	
	private void sixByThree() {
		int space = 0;
		
		for(int x = 0; x < 7; x++) {
			Block block = new Block(85 + space, 65);
			blocks.add(block);
			block = new Block(85 + space, 110);
			blocks.add(block);
			block = new Block(85 + space, 155);
			blocks.add(block);
			
			space += 45;
		}
		
	}
}
