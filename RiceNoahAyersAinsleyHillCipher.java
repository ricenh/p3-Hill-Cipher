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
        return decryptionKey;
    }

    public static int[] encrypt(int plaintext[], int encryptionKey[][]) {
        return new int[2];
    }

    public static int[] decrypt(int ciphertext[], int decryptionKey[][]) {
        return new int[2];
    }

    public static String intToString (int num) {
        return "";
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
        int[][] decryptionKey = findDecryptionKey(encryptionKey);
        System.out.println(encryptionKey[0][0]);
        System.out.println(encryptionKey[0][1]);
        System.out.println(encryptionKey[1][0]);
        System.out.println(encryptionKey[1][1]);

        System.out.println(decryptionKey[0][0]);
        System.out.println(decryptionKey[0][1]);
        System.out.println(decryptionKey[1][0]);
        System.out.println(decryptionKey[1][1]);

    }
}
