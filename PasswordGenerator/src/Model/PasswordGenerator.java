package Model;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Controller.PasswordGeneratorController;

/**
 * Klasse zum Erzeugen eines Passworts.
 * 
 * @author Dirk
 *
 */
public class PasswordGenerator {
	
	static Logger LOG = LoggerFactory.getLogger(PasswordGenerator.class);

	PasswordGeneratorController controller;

	private static String sonderzeichen = "!,§,$,%,&,/,(,),{,},[,],.,;,-,#,*";

	private static String nummern = "1,2,3,4,5,6,7,8,9,0";

	private static String buchstaben = "a,A,b,B,c,C,d,D,e,E,f,F,g,G,h,H,i,I,j,J,k,K,l,L,m,M,n,N,o,O,p,P,q,Q,r,R,s,S,t,T,u,U,v,V,w,W,x,X,y,Y,z,Z";

	private int Max = 20;
	private int Min = 30;
	
	/**
	 * Erzeugt ein Passwort.
	 * 
	 * @return Das Passwort.
	 */
	public String generatePassword() {
		Max = controller.getMaxPasswordLength();
		Min = controller.getMinPasswordLength();
		
		
		String[] sonderzeichenArray = setUpArray(sonderzeichen);
		String[] nummerArray = setUpArray(nummern);
		String[] buchstabenArray = setUpArray(buchstaben);
		String password = "";
		
		int passwordLength = generatePasswordLength();
		for(int i = 0; i < passwordLength; i++){
			int randomArray = 0 + (int)(Math.random() * ((2 - 0)+ 1));
			if(randomArray == 0){
				int randSonder = getRand(sonderzeichenArray.length-1);
				password += sonderzeichenArray[randSonder];
			}else if(randomArray == 1){
				int randNum = getRand(nummerArray.length-1);
				password += nummerArray[randNum];
			}else if (randomArray == 2){
				int randBuchst = getRand(buchstabenArray.length-1);
				password += buchstabenArray[randBuchst];
			}
		}
		return password;
	}
	
	public int generatePasswordLength(){
		if(Min < Max){
			int length = Min + (int)(Math.random() * ((Max - Min) + 1));
			return length;
		}else{
			System.out.println("Min war größer als Max");
			return (10 + (int)(Math.random()) * ((30 - 20) + 1));
		}
	}

	private String[] setUpArray(String string) {
		String[] splittedString = string.split(",");
		return splittedString;
	}
	
	private int getRand(int max){
		return (0 + (int)(Math.random() * ((max - 0) + 1)));
	}

	public PasswordGeneratorController getController() {
		return controller;
	}

	public void setController(PasswordGeneratorController controller) {
		this.controller = controller;
	}
	
	public static void copy(String text) {
		Clipboard clipboard = getSystemClipboard();

		clipboard.setContents(new StringSelection(text), null);
	}

	private static Clipboard getSystemClipboard() {
		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
		Clipboard systemClipboard = defaultToolkit.getSystemClipboard();

		return systemClipboard;
	}

}
