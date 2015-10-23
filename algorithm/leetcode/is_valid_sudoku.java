/*Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.*/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set set = new HashSet<String>();
        for(int i=0;i<9;++i){
            for(int j=0;j<9;++j){
                if(board[i][j] != '.'){
                    String tmp = "("+board[i][j]+")";
                    if(!set.add(tmp+i) || !set.add(j+tmp) || !set.add(j/3+tmp+i/3))
                        return false;
                }
                    
            }
        }
        return true;
    }
}