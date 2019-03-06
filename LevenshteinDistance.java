/**
 * Distance between 2 strings
*/
public class LevenshteinDistance {
    public static void main(String args[]) {
        String a = "satu";
        String b = "sunday";
        
        int[][] distanceMatrix = new int[b.length()+1][a.length()+1];
        
        for(int i=0;i <= a.length(); i++) {
            distanceMatrix[0][i] = i;
        }
        for(int j=0;j <= b.length(); j++) {
            distanceMatrix[j][0] = j;
        }
        
        for(int j = 1; j <= b.length(); j++) {
            for (int i = 1; i <= a.length(); i++) {
                int indicator = a.charAt(i -1) == b.charAt(j - 1) ? 0: 1;
                
                int res = Math.min(distanceMatrix[j][i-1] + 1, /*deletion*/ distanceMatrix[j - 1][i] + 1); //insertion
                res = Math.min(res, distanceMatrix[j - 1][i - 1] + indicator); //substitution
                distanceMatrix[j][i] = res;
            }
        }
        System.out.print(distanceMatrix[b.length()][a.length()]);
    }
}
