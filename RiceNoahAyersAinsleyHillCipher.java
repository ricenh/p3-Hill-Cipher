package p3_cs327;

public class RiceNoahAyersAinsleyHillCipher {

    public static int[][] findDecryptionKey(int encryptionKey[][]) { 
        int determinant = encryptionKey[0][0] * encryptionKey[1][1] - encryptionKey[0][1] * encryptionKey[1][0];
        int gcd = xgcd(determinant, 26);
        int[][] decryptionKey = new int[2][2];
        decryptionKey[0][0] = gcd * encryptionKey[1][1] % 26;
        decryptionKey[0][1] = gcd * -1 * encryptionKey[0][1] % 26;
        decryptionKey[1][0] = gcd * -1 * encryptionKey[1][0] % 26;
        decryptionKey[1][1] = gcd * encryptionKey[0][0] % 26;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (decryptionKey[i][j] < 0) {
                    decryptionKey[i][j] += 26;
                }
            }
        }
        return decryptionKey;
    }

    public static int[] encrypt(int plaintext[], int encryptionKey[][]) {
        int[] encrypt= new int[2];
        encrypt[0] = (encryptionKey[0][0] * plaintext[0] + encryptionKey[0][1] * plaintext[1]) % 26;
        encrypt[1] = (encryptionKey[1][0] * plaintext[0] + encryptionKey[1][1] * plaintext[1]) % 26;
        return encrypt;
    }

    public static int[] decrypt(int ciphertext[], int decryptionKey[][]) {
        return new int[2];
    }

    public static String intToString(int num) {
        char character = (char) (num + 'A'); 
        return String.valueOf(character); 
    }

    public static int stringToInt(String cipher) {
        return 0;
    }

    public static int xgcd (int inE, int inZ) {

		// Must implement the extended Euclidean algorithm
		// NO brute-forcing; violation will lead to zero points
		// NO recursion; violation will lead to zero points
		// Initialize variables
        int oldR = inE, r = inZ; 
        int oldS = 1, s = 0;     
        int oldT = 0, t = 1;     

        while (r != 0) {
            int q = oldR / r;

            int tempR = r;
            r = oldR - q * r;
            oldR = tempR;

            int tempS = s;
            s = oldS - q * s;
            oldS = tempS;

            int tempT = t;
            t = oldT - q * t;
            oldT = tempT;
        }

        if (oldR == 1) {
            return (oldS % inZ + inZ) % inZ;
        } else {
            return 0;
        }
	}
    
    public static void main (String[] args) {
        int[][] encryptionKey = new int[2][2];
        encryptionKey[0][0] = 16;
        encryptionKey[0][1] = 7;
        encryptionKey[1][0] = 9;
        encryptionKey[1][1] = 14;
        System.out.println("Encyption Key:");
        System.out.printf("%s %s\n", encryptionKey[0][0], encryptionKey[0][1]);
        System.out.printf("%s %s\n", encryptionKey[1][0], encryptionKey[1][1]);
        
        int[][] decryptionKey = findDecryptionKey(encryptionKey);
        System.out.println("Decyption Key:");
        System.out.printf("%s %s\n", decryptionKey[0][0], decryptionKey[0][1]);
        System.out.printf("%s %s\n", decryptionKey[1][0], decryptionKey[1][1]);

        int[][] plaintexts = {
            {9, 12},
            {20, 2},
            {18, 8},
            {18, 2},
            {14, 14},
            {11, 25}
        };
        
        String[] encryptedStrings = new String[plaintexts.length * 2];
        for (int i = 0; i < plaintexts.length; i++) {
            int[] ciphertext = encrypt(plaintexts[i], encryptionKey);
            encryptedStrings[i * 2] = intToString(ciphertext[0]);
            encryptedStrings[i * 2 + 1] = intToString(ciphertext[1]);
        }
        
        System.out.println("Encryption of JMUCSISCOOL:");
        System.out.printf("%s%s %s%s %s%s %s%s %s%s %s%s\n",
            encryptedStrings[0], encryptedStrings[1],
            encryptedStrings[2], encryptedStrings[3],
            encryptedStrings[4], encryptedStrings[5],
            encryptedStrings[6], encryptedStrings[7],
            encryptedStrings[8], encryptedStrings[9],
            encryptedStrings[10], encryptedStrings[11]);
    }
}
