import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    private static Map<String, String> mimeTypeByExt = new HashMap<String, String>();
    private static List<String> fileNames = new ArrayList<String>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        in.nextLine();
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        in.nextLine();
        
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            mimeTypeByExt.put(EXT.toLowerCase(), MT);
            in.nextLine();
        }
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine();
            fileNames.add(FNAME);
        }
        
        for (String file : fileNames) {
            System.out.println(getMimeType(file));
        }

    }
    
    public static String getMimeType(String fileName) {
        String extension = getFileExtension(fileName);
        
        String mimeType = null;
        if (extension != null) {
            mimeType = mimeTypeByExt.get(extension);
        }
        
        if (mimeType != null) {
            return mimeType;
        } else {
            return "UNKNOWN";
        }
    }
    
    public static String getFileExtension(String fileName) {
        String extension = null;
        
        int indexDot = fileName.lastIndexOf(".");
        if (indexDot > 0) {
            extension = fileName.substring(indexDot + 1).toLowerCase();
        }
        
        return extension;
    }
}