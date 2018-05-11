public abstract class BasePlayer {
    final int SIZE_OF_FIELD = 10;
    int X;
    int Y;
    int Count = 20;
    protected int[][] OwnField = new int[SIZE_OF_FIELD][SIZE_OF_FIELD];
    protected int[][] OpponentField = new int[SIZE_OF_FIELD][SIZE_OF_FIELD];

    void SetShip(int PosX, int PosY, int Size, boolean Horizontal) {
        int i;
        if (Horizontal) {
            for (i = 0; i < Size; i++) {
                OwnField[PosX][PosY + i] = 1;
            }
        }
        else {
            for (i = 0; i < Size; i++) {
                OwnField[PosX + i][PosY] = 1;
            }
        }
    }

    boolean CanSetShip(int PosX, int PosY, int Size, boolean Horizontal) {
        int i;
        int j;
        int UpperBoundX;
        int UnderBoundX;
        int UpperBoundY;
        int UnderBoundY;
        if (Horizontal) {
            if (PosY + Size - 1 > SIZE_OF_FIELD) {
                return false;
            }

            UnderBoundX = (PosX - 1 < 0) ? PosX : PosX - 1;
            UnderBoundY = (PosY - 1 < 0) ? PosY : PosY - 1;
            UpperBoundX = (PosX + 1 > SIZE_OF_FIELD - 1) ? PosX  : PosX + 1;
            UpperBoundY = (PosY + Size > SIZE_OF_FIELD - 1) ? PosY + Size - 1 : PosY + Size;

            for (i = UnderBoundX; i <= UpperBoundX; i++) {
                for (j = UnderBoundY; j <= UpperBoundY; j++) {
                    if (OwnField[i][j] == 1) {
                        return false;
                    }
                }
            }
        }
        else {
            if (PosX + Size - 1 > SIZE_OF_FIELD) {
                return false;
            }

            UnderBoundX = (PosX - 1 < 0) ? PosX : PosX - 1;
            UnderBoundY = (PosY - 1 < 0) ? PosY : PosY - 1;
            UpperBoundX = (PosX + Size > SIZE_OF_FIELD - 1) ? PosX + Size - 1 : PosX + Size;
            UpperBoundY = (PosY + 1 > SIZE_OF_FIELD - 1) ? PosY : PosY + 1;

            for (i = UnderBoundX; i <= UpperBoundX; i++) {
                for (j = UnderBoundY; j <= UpperBoundY; j++) {
                    if (OwnField[i][j] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    void Result(boolean Res, int PosX, int PosY) {
        if (Res) {
            Count--;
            OpponentField[PosX][PosY] = 2;
        }
        else {
            if (OpponentField[PosX][PosY] == 0) {
                OpponentField[PosX][PosY] = 3;
            }
        }

    }

     public boolean Hit(int PosX, int PosY) {
        if (OwnField[PosX][PosY] == 1) {
            OwnField[PosX][PosY] = 2;
            return true;
        }
        else {
            if (OwnField[PosX][PosY] == 2 || OwnField[PosX][PosY] == 3) {
                return false;
            }
            else {
                OwnField[PosX][PosY] = 3;
                return false;
            }

        }
    }

}
