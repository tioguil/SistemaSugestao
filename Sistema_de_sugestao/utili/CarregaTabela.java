package utili;

import java.util.*;
import javax.swing.table.AbstractTableModel;

public class CarregaTabela extends AbstractTableModel {
    
    private ArrayList linhas;
    private String [] colunas;
    
    public CarregaTabela (ArrayList linhas, String[] colunas){
        this.linhas = linhas;
        this.colunas = colunas;
        
    }
    
    public ArrayList getLinhas(){
        return linhas;
        
    }
    
    public void setLinhas(ArrayList linhas){
        this.linhas = linhas;
    }
    
    public String [] getColunas(){
        return colunas;
    }
    
    public void setColunas(String[] colunas){
        this.colunas = colunas;
    }
    
    public int getColumnCount(){
        return colunas.length;
    }
    
    public int getRowCount(){
        return linhas.size();
    }
    
    public String getColunaName(int numColunas){
        return colunas[numColunas];
    }
    public Object getValueAt(int numLinhas, int numColunas){
        Object[] linhas = (Object[])getLinhas().get(numLinhas);
        return linhas[numColunas];
        
    }
}