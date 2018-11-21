package KevinLiu;

public class TokenPass {
    public int[] board;
    public int currentPlayer;
    public TokenPass(int playerCount)
    {
        this.board = new int[playerCount];
        this.currentPlayer = (int)(Math.random()*playerCount);
        for(int i =0; i<playerCount; i++)
        {
            board[i] = (int)(Math.random()*10);
        }
    }
    public void distributeCurrentPlayerTokens()
    {
        int nextPlayer = currentPlayer;
        int numToDistribute = board[currentPlayer];
        board[currentPlayer] = 0;

        while (numToDistribute > 0)
        {
            nextPlayer = (nextPlayer + 1) % board.length;
            board[nextPlayer]++;
            numToDistribute--;
        }
    }
    public void printBoard()
    {
        for(int i = 0;i<board.length;i++ )
        {
            System.out.println("Player " + i +  ": " + board[i] + " Tokens");
        }
        System.out.println("Current Player: " + currentPlayer + "\n");
    }

    public int gameOver()
    {
        for(int i = 0;i<board.length;i++)
        {
            if(board[i] <= 0)
            {
                return i;
            }
        }
        return -1;
    }

    public void nextPlayer()
    {
        currentPlayer++;
        if(currentPlayer>=board.length)
        {
            currentPlayer = 0;
        }
    }

}
