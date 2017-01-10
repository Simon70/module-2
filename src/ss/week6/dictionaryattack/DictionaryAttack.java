package ss.week6.dictionaryattack;

import org.apache.commons.codec.binary.Hex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


public class DictionaryAttack {
    private Map<String, String> passwordMap;
    private Map<String, String> hashDictionary;

    public DictionaryAttack() {
        passwordMap = new HashMap<>();
        hashDictionary = new HashMap<>();
    }

    public static void main(String[] args) throws IOException {
        DictionaryAttack da = new DictionaryAttack();
        da.readPasswords("./src/ss/week6/test/LeakedPasswords.txt");
        da.addToHashDictionary("./1000hashes.txt");
        da.doDictionaryAttack();
    }

    /**
     * Reads a password file. Each line of the password file has the form:
     * username: encodedpassword
     * <p>
     * After calling this method, the passwordMap class variable should be
     * filled withthe content of the file. The key for the map should be
     * the username, and the password hash should be the content.
     *
     * @param filename
     */
    public void readPasswords(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while (br.ready()) {
            String[] line = br.readLine().split(":");
            passwordMap.put(line[0].trim(), line[1].trim());
        }
        br.close();
    }

    /**
     * Given a password, return the MD5 hash of a password. The resulting
     * hash (or sometimes called digest) should be hex-encoded in a String.
     *
     * @param password
     * @return
     */
    public String getPasswordHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return Hex.encodeHexString(md.digest(password.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Checks the password for the user the password list. If the user
     * does not exist, returns false.
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
     * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
     *
     * @param filename filename of the dictionary.
     */
    public void addToHashDictionary(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while (br.ready()) {
                String line = br.readLine();
                hashDictionary.put(getPasswordHash(line), line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Do the dictionary attack.
     */
    public void doDictionaryAttack() {
        int found = 0;
        for (Map.Entry<String, String> entry : passwordMap.entrySet()) {
            if (hashDictionary.containsKey(entry.getValue())) {
                System.out.println("Password found: " + entry.getKey() + " : " + hashDictionary.get(entry.getValue()));
                found++;
            }
        }
        System.out.println("Found " + found + " out of " + passwordMap.size() + " Passwords using " +
                                   hashDictionary.size() + " Hashes.");
    }

}
