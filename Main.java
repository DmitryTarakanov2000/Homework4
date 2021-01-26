import com.sun.media.sound.SoftAudioBuffer;
import com.sun.org.apache.bcel.internal.classfile.SourceFile;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static char[][] gameMap;
    public static Scanner sc = new Scanner(System.in);

    private static final int DOTS_TO_WIN = 3;

    private static final char EMPOTY_DOT = '•';
    private static final char X_DOT = 'X';
    private static final char O_DOT = 'O';





    public static void main(String[] args) {

        initGameMap( 3,3);
        paintGameMap();
        int count = 0;
        while (true){
            humanTurn();
            count++;
            paintGameMap();
            if (chekWin(X_DOT)){
                System.out.println("ПОБЕДА");
                break;
            }
            if(count== 9){
                System.out.println("Ничья");
            }
            compTurn();
            count++;
            paintGameMap();
            if (chekWin(O_DOT)){
                System.out.println("КОМПЬЮТЕР ПОБЕДИЛ");
            }

        }

    }

    private static boolean chekWin(char c) {
        for (int i = 0; i < 3; i++)
            if ((gameMap[i][0] == c && gameMap[i][1] == c &&
                    gameMap[i][2] == c) ||
                    (gameMap[0][i] == c && gameMap[1][i] == c &&
                            gameMap[2][i] == c))
                return true;
        if ((gameMap[0][0] == c && gameMap[1][1] == c &&
                gameMap[2][2] == c) ||
                (gameMap[2][0] == c && gameMap[1][1] == c &&
                        gameMap[0][2] == c))
            return true;
        return false;
    }

    private static void compTurn() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {

        }
        int x, y;
        boolean checkCell;
        Random random = new Random();
        do{
            x = random.nextInt(gameMap.length);
            y = random.nextInt(gameMap.length);
            checkCell = isValidCell(x, y);

        }while (!checkCell);
        gameMap[x][y] = O_DOT ;
    }

    private static void humanTurn() {
        int x = -1;
        int y = -1;
        boolean checkCell;
        do {
            System.out.println("Введите кординаты в форме x y ");
            if (sc.hasNextInt()){
                x = sc.nextInt() - 1;
            }
            if (sc.hasNextInt()){
                y = sc.nextInt() - 1;
            }
             checkCell = isValidCell(x , y);
            sc.nextLine();
        } while (!checkCell);
        gameMap[x][y] = X_DOT;
    }

    private static boolean isValidCell(int x, int y){
        if (x < 0|| y < 0|| x > gameMap.length || y > gameMap.length){
            return false;
        }
        return gameMap[x][y] == EMPOTY_DOT;
    }

    private static void paintGameMap() {
        for (int i = 0; i < gameMap.length; i++){
            for (int j = 0; j < gameMap[i].length; j++){
                System.out.print(gameMap[i][j] +"");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initGameMap(int length, int width) {
        if (length < 3 || width < 3){
            System.out.println("You stipid man");
            System.exit(0);
        }
        gameMap = new char[length][width];
        for (int i = 0; i < gameMap.length; i++){
            for (int j = 0; j < gameMap[i].length; j++){
                gameMap[i][j] = EMPOTY_DOT;
            }
        }
    }
}

