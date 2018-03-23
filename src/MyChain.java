import java.util.ArrayList;
import java.util.Random;

public class MyChain {

	public static ArrayList<MyBlocks> myBlockChain = new ArrayList<MyBlocks>();
	private static int difficulty;

	public static void main(String[] args) {

	}

	public static Boolean validateChain() {
		MyBlocks currentBlock;
		MyBlocks previousBlock;
		Random rand = new Random();
		difficulty = rand.nextInt(50) + 1;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');

		for (int i = 1; i < myBlockChain.size(); i++) {
			currentBlock = myBlockChain.get(i);
			previousBlock = myBlockChain.get(i - 1);
			// compare registered hash and calculated hash:
			if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
				System.out.println("Current Hashes not equal");
				return false;
			}
			// compare previous hash and registered previous hash
			if (!previousBlock.getHash().equals(currentBlock.getPrevHash())) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			// check if hash is solved
			if (!currentBlock.getHash().substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}

		}
		return true;
	}
}
