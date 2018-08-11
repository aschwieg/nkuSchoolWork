/* Alex Schwiegeraht
 * Description: Extension of NumberFormatException that works specifically with hex values.
 */

public class HexFormatException extends NumberFormatException{
	private String hex;
	public static final long serialVersionUID = 1L;
	public HexFormatException(String hex){
		super("Invalid String: " + hex);
		this.hex=hex;
	}
	
	public String getHex(){
		return hex;
	}
	

}
