/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Xo 
{   
    static int[][] arr=new int [3][3];
    static int player=1;
    static int row=0;
    static int column=0;
    static int winner=0;
    static int finallsum=0;
    
    
    static void display()
    {   
        int y=0;
        System.out.print("\t");
        for(int x=0;x<=2;x++)
        {   
            System.out.print("["+x+"]\t");
        }
        System.out.println("\n");
       
        for(int i=0;i<=2;i++)
        {   
            System.out.print("["+y+"]\t");

            for(int j=0;j<=2;j++)
            {  
                if(arr[i][j]==10)            
                {
                    System.out.print("x\t");
                }
                else if(arr[i][j]==1)
                {
                    System.out.print("O\t");
                }
                else if(arr[i][j]==0)
                {
                    System.out.print("--\t");
                }
            }
            System.out.println("\n");
            y++;
        }
    }
    
       static void input()//1-voroodi begire 2-range check kone 3-khali boodan check kone
    {   
        Scanner obj=new Scanner(System.in);
        
        boolean itsok=false;
        
        while(itsok==false)
        {   
            boolean stop=false;
            boolean stop2=false; 
            while(stop==false)
            {
                System.out.println("player"+player+"\n enter row");
                row=obj.nextInt();
                if(row>=0 && row<=2)
                {
                    stop=true;
                }
            }//satr ha check shod
            
            while(stop2==false)
            {
                System.out.println("enter column");
                column=obj.nextInt();
                if(column>=0 && column<=2)
                {
                    stop2=true;
                }
           
            }//sotoon ha check shod
            if(arr[row][column]==0)
            {
                itsok=true;
            }
            
        }  //check kardam khalie ya na  
        
    }
    
    static void setarray()//be araye meghdar dadam
    {
        if(player==1)
        {
            arr[row][column]=10;
        }
        else
        {
            arr[row][column]=1;
        }
    }//be araye meghdar dadam    
    
    static boolean checkwin()
    {
        boolean win=false;
        
        for(int k=0;k<=2;k++)//check kardane satr ha
        {          
            int sum=0;
            for(int m=0;m<=2;m++)
            {
                sum=sum+arr[k][m];
            }
            if(sum==30 || sum==3)
            {
                win=true;
                finallsum=sum;
                return win;
            }
            
        }
        
        
            
            for(int n=0;n<=2;n++)//sotoon ha check shod
            {
                int sum2=0;
                for(int p=0;p<=2;p++)
                {
                    sum2=sum2+arr[p][n];
                }
                if(sum2==30 || sum2==3)
                {
                    win=true;
                    finallsum=sum2;
                    return win;
                }
            }
            //ghotr ha
            int sum3=0;
            for(int q=0;q<=2;q++)
            {
                sum3=sum3+arr[q][q];
            }
                if(sum3==30 ||sum3==3)
                {
                    win=true;
                    finallsum=sum3;
                    return win;
                }
                
            int sum4=arr[0][2]+arr[1][1]+arr[2][0];
            if(sum4==30 || sum4==3)
                {
                    win=true;
                    finallsum=sum4;
                    return win;
                }
               
            
    return win;    
    }
    
    static void changeplayer()
    {
        if(player==1)
        {
            player=2;
        }
        else
        {
            player=1;
        }
    }
    
    static void printresult()
    
    {
        if(finallsum==30)
        {
            System.out.println("winner is player1***");
        }
        else if(finallsum==3)
        {
            System.out.println("winner is player2****");
            
        }
        else if(finallsum==0)
        {
            System.out.println("we dont have winner :(");
        }
    }
    
    public static void main(String[] args)
    {
        int counter=1;
        boolean winner=false;
        
        while(counter<=9 && winner==false)
        { 
            display();
            input();
            setarray();
            winner=checkwin();
            changeplayer();
            counter++;
        }
        
        printresult();
        
    }
    
}
