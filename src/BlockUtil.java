

public class BlockUtil {
	
	public static MyBlocks generateGensis() {	
		int index = 0;
		String prevHash = "0";
		String data = "Hello MyBlockChain";
		return new MyBlocks(index, prevHash, data);
	}
}
