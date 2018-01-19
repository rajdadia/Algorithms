
public class Percolation 
{
  //class declaration
  int n,counter;
  
  int[] open;
  
  WeightedQuickUnionUF grid;
 
  //constructor
  public Percolation(int n)  
 {
     counter=0;
     
     this.n=n;
     
     grid=new WeightedQuickUnionUF(n*n+2);
     
     open=new int[n*n+2];
     
     
     
     for(int i=0;i<n*n;i++)
     {
          open[i]=0;
     }
     
     open[n*n]=open[n*n+1]=1;
 }
 
  
  //open a site
  public void open(int row, int col)
 {
     int ele;
     ele=row*n+col;
     
     open[ele]=1;
     
     ele=flow(row,col);
     
     counter+=1;       
      if(row==0)
     {
      grid.union(ele,n*n);
     }
 }   

  
  //check if the site is open
  public boolean isOpen(int row, int col) 
 {
     if(open[row*n+col]==1)
     {
         return true;
     }
     else
         return false;
 }
 
  
  //method flow for is full(joins all the neighbors of the element which are open under one component)
  public int flow(int row,int col)
 {
   int x;
   int ele;
   
     ele=row*n+col;
     
     
     //if not open then return -1
     if(!isOpen(row,col)) return -1;
     
     if (!(col-1<0))
     if(isOpen(row,col-1)) 
     {
      if(!grid.connected(ele,ele-1))
      {
       grid.union(ele, ele-1);
       x=flow(row,col-1);
      }
                              
     }
        
     if (!(col+1>n-1))
     if(isOpen(row,col+1)) 
     {
      if(!grid.connected(ele,ele+1))
      {
       grid.union(ele, ele+1);
       x=flow(row,col+1);  
      }//right
     }
       
     if (!(row-1<0))
     if(isOpen(row-1,col)) 
     {
      if(!grid.connected(ele-n,ele))
      {
       grid.union(ele-n, ele);
             x=flow(row-1,col);
      }
                           
     }
     
     if (!(row+1>n-1))
     if(isOpen(row+1,col)) 
     {
      if(!grid.connected(ele+n,ele))
      {
       grid.union(ele+n, ele);
       x=flow(row+1,col);
      }
                              
     }
     
     return ele;
 }
 
 
 
 public boolean isFull(int row, int col)  
 {
     int ele=row*n+col;
     
     for(int i=0;i<n;i++)
     {
      if(isOpen(0,i) && isOpen(row,col))
      {
       if(grid.find(i)==grid.find(ele))
       {
        return true;
       }
      }    
     }
     return false;
 }
 

 public     int numberOfOpenSites()     
 {
     return counter;
 }
 
 
 public boolean percolates()

 {
    boolean x;
    
     for(int i=0;i<n;i++)
     {
         x=isFull(n-1,i);
         if(x==true)
         {
             return true;
         }
     }
     return false;
 }
 
 public static void main(String args[])
 {
     int n=5;
     
     Percolation grid=new Percolation(n);
     
     grid.open(0,0);
     grid.open(0,1);
     grid.open(1,1);
     grid.open(4,4);
     grid.open(2,1);
     grid.open(3,0);
     grid.open(3,2);
     grid.open(3,3);
     grid.open(2,2);
     //grid.open(1,0);
     //grid.open(2,0);
     grid.open(3,4);
     grid.open(4,1);
     
     boolean x=grid.percolates();
     if(x==true)
      System.out.println("percolates");
     else
      System.out.println(" no percolates");
 }
}
  
