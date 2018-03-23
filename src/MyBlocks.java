import java.util.Date;

public class MyBlocks {
	private String hash;
	private String prevHash;
	private Date date;
	private int index;
	private String data;
	private int nonce;

	public MyBlocks(int index, String prevHash, String data) {
		this.index = index;
		this.prevHash = prevHash;
		date = new Date();
		this.data = data;
		this.hash = calculateHash();
	}

	public String calculateHash() {
		return ShaUtil.applySha256(index + prevHash + date.toString() + data);
	}

	public String getHash() {
		return hash;
	}

	public String getPrevHash() {
		return prevHash;
	}

	public String getDate() {
		return date.toString();
	}

	public int getIndex() {
		return index;
	}

	public String getData() {
		return data;
	}
	
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setPrevHash(String prevHash) {
		this.prevHash = prevHash;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
}

}
