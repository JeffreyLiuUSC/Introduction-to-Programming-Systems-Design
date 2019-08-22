/**
 * Tester of MineField Class
 * 1. type change of boolean[][] mineField in MineFiled from private to public is
 * required before apply this tester.
 * 2. comment marks should be delete whiling testing corresponded constructors and accessors.
 */

public class MineFieldTester {
    static boolean[][] mineData = {
            {false, true, true},
            {true, true, true},
            {false, false, false}};

    public static void main(String arg[]) {
        //One argument tests
        MineField mineField = new MineField(mineData);
        System.out.println(mineField.numMines());
        System.out.println(mineField.numAdjacentMines(0, 0));
        System.out.println(mineField.inRange(1, 1));
        System.out.println(mineField.numRows());
        System.out.println(mineField.numCols());
        System.out.println(mineField.hasMine(2, 2));
        System.out.println(mineField.numMines());
        System.out.println(mineField.hasMine(0, 1));
        mineField.resetEmpty();
        System.out.println();
        System.out.println();
        System.out.println();
        /*
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.println(mineField.mineField[i][j]);
            }
        }
        */
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(mineField.hasMine(0, 1));
        System.out.println();
        System.out.println();
        System.out.println();
        mineField.populateMineField(1, 1);
        System.out.println();
        System.out.println();
        System.out.println();
        /*
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.println(mineField.mineField[i][j]);
            }
        }
        */
        System.out.println(mineField.hasMine(0, 0));
        System.out.println(mineField.hasMine(0, 1));
        System.out.println("-----------------------------------");
        //Three arguments tests
        MineField mineField1 = new MineField(4, 4, 4);
        /*
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.println(mineField1.mineField[i][j]);
            }
        }
        */
        System.out.println(mineField1.numMines());
        mineField1.populateMineField(1, 1);
        /*
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.println(mineField1.mineField[i][j]);
            }
        }
        */
    }
}
