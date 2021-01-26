public class Main {

 private static char [] [] gameMap;
 private static final int DOTS_TO_WIN = 3;

 private static final char EMPTY_DOT = '•';
 private static final char X_DOT = 'x';
 private static final char O_DOT = 'O';




    public static void main (String[] args){

        gameMap = new char [3] [3];
        for (int i = 0; i < gameMap.length;  i++)
            for (int j = 0; j < gameMap[i].length; j++) gameMap[i][j] = EMPTY_DOT;

    }
}
