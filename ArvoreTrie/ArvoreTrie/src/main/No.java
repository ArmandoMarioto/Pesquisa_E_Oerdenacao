/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Armando
 */
public class No 
{
    private char vInfo[];
    private No vLig[];
    private String FinalPalavra;

    public No() 
    {
        vInfo = new char[26];
        vLig = new No[26];
        FinalPalavra = "";
    }

    public No(char info)
    {
        this();
        vInfo[info-'a'] = info;
    }

    public char getvInfo(int p) 
    {
        return vInfo[p];
    }

    public void setvInfo(int p,char vInfo) 
    {
        this.vInfo[p] = vInfo;
    }

    public No getvLig(int p) 
    {
        return vLig[p];
    }

    public void setvLig(int pos,No vLig) 
    {
        this.vLig[pos] = vLig;
    }

    public String getFinalPalavra() 
    {
        return FinalPalavra;
    }

    public void setFinalPalavra(String FinalPalavra) 
    {
        this.FinalPalavra = FinalPalavra;
    }
    
    
}
