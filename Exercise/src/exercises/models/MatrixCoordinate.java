/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.models;

/**
 *
 * @author jasretan
 */
public class MatrixCoordinate implements Comparable<MatrixCoordinate> {

    public int row, column;
    
    public MatrixCoordinate(int row, int column){
        this.row = row;
        this.column = column;
    }
    
    @Override
    public int compareTo(MatrixCoordinate o) {
        int cmp = this.row - o.row;
        if (cmp == 0)
            cmp = this.column - o.column;
        return cmp;
    }
    
    @Override
    public int hashCode(){        
        int hashCode = 0;
        hashCode = (hashCode * 397) ^ ((Object)this.row).hashCode();
        hashCode = (hashCode * 397) ^ ((Object)this.column).hashCode();
        return hashCode;
    }
    
    @Override
    public boolean equals(Object o){
        if (o instanceof MatrixCoordinate){
            MatrixCoordinate coord = (MatrixCoordinate)o;
            return this.row == coord.row && this.column == coord.column;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "[" + this.row + "," + this.column + "]";
    }
}
