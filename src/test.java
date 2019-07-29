
public class test {

    public static void main(String[] args) {
        String[][] map = {{".", "*", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", "*"},
                {".", ".", "*", "*", "*", "."},
                {"*", ".", ".", ".", ".", "."}
        };
        final int HEIGHT = map.length;
        final int WIDTH = map[0].length;
        String[][] mapReport = new String[HEIGHT][WIDTH];
        for(int yOrdinate = 0; yOrdinate < HEIGHT; yOrdinate++){
            for (int xOrdinate = 0; xOrdinate< WIDTH; xOrdinate++){
                String currentCell = map[yOrdinate][xOrdinate];
                if(currentCell.equals("*")){
                    mapReport[yOrdinate][xOrdinate] = "*";
                }else{
                    final int[][] NEIBOUR_ORDINATE = {
                            {yOrdinate - 1, xOrdinate -1},{yOrdinate - 1, xOrdinate}, {yOrdinate - 1, xOrdinate + 1},
                            {yOrdinate, xOrdinate -1},{yOrdinate, xOrdinate + 1},
                            {yOrdinate + 1, xOrdinate -1},{yOrdinate + 1, xOrdinate},{yOrdinate + 1, xOrdinate + 1}
                    };
                    int mineAround = 0;
                    for(int i = 0; i < NEIBOUR_ORDINATE.length; i++){
                        int[] neibourOrdinate = NEIBOUR_ORDINATE[i];
                        int xNeibourOrdinate = neibourOrdinate[1];
                        int yNeibourOrdinate = neibourOrdinate[0];
                        boolean isOutOfMapNeibour = xNeibourOrdinate < 0 || xNeibourOrdinate == WIDTH ||
                                                    yNeibourOrdinate < 0 || yNeibourOrdinate == HEIGHT;
                        if(isOutOfMapNeibour) continue;
                        boolean isMineOwnerNeibour = map[yNeibourOrdinate][xNeibourOrdinate].equals("*");
                        if(isMineOwnerNeibour) mineAround++;
                    }
                    mapReport[yOrdinate][xOrdinate] = String.valueOf(mineAround);
                }
            }
        }
        for (int yOrdinate = 0; yOrdinate < HEIGHT ; yOrdinate ++){
            for (int xOrdinate = 0; xOrdinate < WIDTH ; xOrdinate++){
                System.out.print(mapReport[yOrdinate][xOrdinate]);
            }
            System.out.println();
        }
    }
}
