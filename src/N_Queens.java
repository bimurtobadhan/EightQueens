/*
 * @author soneya
 */
import java.util.Scanner; 
public class N_Queens {

    int[] numOfQueen;
    int N;
    int [][] array;
    public N_Queens(int Q) {
        
        numOfQueen = new int[Q];
        array= new int [Q][Q];
        N=Q;
        initialize_array();
        
        
   }
 
    
    
 private void initialize_array()
 {
     for (int i = 0; i < N; i++) 
     {
        numOfQueen[i]=-1;
        for (int j = 0; j < N; j++) 
        {
          array[i][j]=0; 
        }

     }
                 
 }
 
 public void print_numOfQueen()
 {
     for (int i = 0; i < N; i++) {
                System.out.println(numOfQueen[i]);

        
            }
                 
 }
 
 public void print_array()
 { 
     
     for (int i = 0; i < N; i++) 
     {
            
            for (int j = 0; j < N; j++) 
            {
                System.out.print(array[i][j]+" ");

            }
            System.out.println(" ");
     }
                 
 }
  
 
 
    public void printQueens(int[] x) {
        int n = x.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
 //...........................................................................//
 
 

   public void PlaceNQueens()
   {
       boolean flag;
       
       if (noMoreRow(numOfQueen)) {
           printQueens(numOfQueen);
           
       }
       int row=SelectRowMRV();
       
       for (int j=0; j<N ; j++)
       {
           numOfQueen[row]=j;
           
           flag= forwardCheck(row,j);
           
           if (flag==false)
           {
               continue;
           }
           forward(row,j);
           System.out.println("complete 1 row");
           print_array();
           print_numOfQueen();
           PlaceNQueens();
           
       }
     
            
   }
//.......................................................................................................
   
    public boolean CheckConstraint(int[] X, int N, int r) 
    {
        for (int i=0; i<r-1;i++)
        {
           if(X[i]==X[r]) {
                return false;
            }
           else if (X[r]-(r-1)==X[i]) {
                return false;
            }
           else if (X[r]+(r-i)==X[i]) {
                return false;
            }
        }

           return true;
        
    }
  //...........................................................................
    
   public int SelectRowMRV()
   {
     int min_row = 0 ;
     int infinity=10000000;
     
     for (int i=0;i<N;i++)
     { 
        if(numOfQueen[i]==-1)
        {
            int count=0;
            for(int j=0;j<N;j++)
            {
                if(array[i][j]==0) 
                {
                     count++;
                }

            }
            if(count<infinity) 
            {
                infinity=count;
                min_row=i;
            }
        }
       
         
     }
     return min_row;
   }
   
  //............................................................................ 
   
    public void placeNQueensAndFCandMRV()
    {
        boolean flag;
        
        if(noMoreRow(numOfQueen))
        {
           printQueens(numOfQueen);
          
        }
        
       int i= SelectRowMRV();
        
       for (int j=0; j<N ; j++)
       {
           numOfQueen[i]=j;
           
           flag= forwardCheck(i,j);
           
           if (flag==false)
           {
               continue;
           }
           forward(i,j);
           System.out.println("complete 1 row");
           print_array();
           print_numOfQueen();
            
           PlaceNQueens();
           
       }
      
        
   }
   //...........................................................................
    
    private boolean noMoreRow(int X[]) { 
        
        for (int i=0; i<N; i++)
        {
            if (X[i]==0) 
            {
                return false;
            }
        }
        return true;
    }
//.............................................................................  
    public void forward(int row,int col)
    {
        int column0=col-1;
        int column1=col-1;
        
        int column2=col+1;
        int column3=col+1;
        System.out.println("row"+row);
        System.out.println("column"+col);
        for (int i=0;i<N;i++) // setting the column value to 1    //row 1 col 2
        {
           array[i][col]=1;
           System.out.println("problem"+i+","+col);
               
        }
        //.............................................................................
        for (int i= row+1;i<N;i++)
        {
           if(column1>=0)
           {
               System.out.println("--problem"+i+","+column1);
               array[i][column1--]=1;
               
           }
           if(column2<N)
           {
               System.out.println("++problem"+i+","+column2);
               array[i][column2++]=1;
          
           }
           
           
        }
        //...................................................................
        for (int i=row-1;i>=0;i--)
        {  //row =0
           
            if(column3<N)
            {
               System.out.println("..problem"+i+","+column3);
                array[i][column3++]=1;
            }
            if(column0>=0)
            {
                System.out.println(",,problem"+i+","+column0);
                array[i][column0--]=1;
            }
         
        }
        
        
    }
    
    //.........................................................................
    
    private boolean forwardCheck(int row,int col) { 
        if(array[row][col]==1) {
            return false;
        }
        return true;
    }
   
    
    
    
    //.............................start........................................
    
    
    public void start(N_Queens Q)
    { 
        
       System.out.println("in start functiion");
       print_numOfQueen();
       print_array();
       placeNQueensAndFCandMRV();
    }
    
    
    
    //........................main function.....................................
    
    public static void main(String args[]) 
    {
        Scanner in = new Scanner(System.in); 
        System.out.println("enter # of Queens:");
        int input;
        input = in.nextInt(); 
        System.out.println("N="+input);
        N_Queens Q = new N_Queens(input);
        System.out.println("in start functiion");
        Q.print_numOfQueen();
        Q.print_array();
        Q.placeNQueensAndFCandMRV();
        
    }

    
}


