package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.Hex;

import ss.week6.WrongArgumentException;

public class DictionaryAttack {

	private Map<String, String>	passwordMap		= new HashMap<String, String>();
	private Map<String, String>	hashDictionary	= new HashMap<String, String>();

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be the
	 * username, and the password hash should be the content.
	 * 
	 * @param filename
	 * @throws WrongArgumentException
	 */
	public void readPasswords(String filename) throws IOException {
		if (filename == null || filename.isEmpty() || !filename.contains(".")) {
			return;
			//throw new WrongArgumentException(filename);
		}

		BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

		String line = "";
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			String[] data = line.split(": ");
			if (data.length <= 1) {
				continue;
			}

			passwordMap.put(data[0].trim(), data[1].trim());
		}
		bufferedReader.close();
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting hash
	 * (or sometimes called digest) should be hex-encoded in a String.
	 * 
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			return Hex.encodeHexString(md.digest(password.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Checks the password for the user the password list. If the user does not
	 * exist, returns false.
	 * 
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
		return passwordMap.containsKey(user) && passwordMap.get(user).equals(getPasswordHash(password));
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to the
	 * original password.
	 * 
	 * @param filename
	 *            filename of the dictionary.
	 * @throws IOException
	 */
	public void addToHashDictionary(String filename) throws IOException {
		if (filename == null || filename.isEmpty() || !filename.contains(".")) {
			return;
			//throw new WrongArgumentException(filename);
		}

		BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

		String line = "";
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine().trim();

			hashDictionary.put(getPasswordHash(line), line);
		}
		bufferedReader.close();
	}

	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		int count = 0;
		//Entry: username,password
		for (Entry<String, String> entry : passwordMap.entrySet()) {
			//hasdic: hashpassword, readable password
			if (hashDictionary.containsKey(entry.getValue())) {
				System.out.println("Found: " + entry.getKey() + " has password " + hashDictionary.get(entry.getValue()));
				count++;
			}
		}
		System.out.println(count+"/"+passwordMap.size());
	}

	public static void main(String[] args) throws IOException {
		DictionaryAttack da = new DictionaryAttack();
		da.readPasswords("./src/ss/week6/test/Leakedpasswords.txt");
		da.addToHashDictionary("./src/ss/week6/dictionaryattack/passwordList.txt");
		da.doDictionaryAttack();
	}

}
