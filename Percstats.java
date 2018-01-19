
import java.util.*;

public class Percstats 
{
 int times,size;
 public Percstats(int size) 
 {
  this.size=size;
 }
 
 public int check(int size)
 {
  Percolation grid=new Percolation(size);
  
  boolean x=false;
  int a,b,k=0;
  while(x==false)
  {
	  Random rand=new Random();
   a=rand.nextInt(size);
   b=rand.nextInt(size);
   if(!grid.isOpen(a,b))
   {
   grid.open(a,b);
   x=grid.percolates();
   k++;
   }
  }
  
  return grid.counter;
 }
 
 
 
 public static void main(String[] args)
 {
  Scanner sc=new Scanner(System.in);
  System.out.println("enter the number of simluations to run and the size of the grid");
  
  int n=sc.nextInt();
  int size=sc.nextInt();
  int[] num=new int[n];
  
  Percstats[] sim=new Percstats[n];
  int i=0;
  for(i=0;i<n;i++)
  {
   sim[i]=new Percstats(size);
   num[i]=sim[i].check(size);
   System.out.println(num[i]);
  }
  float sum=0;
  
  i=0;
  
  while(i!=n)
  {
      sum+=num[i];
      i++;
  }
  System.out.print("average value of percolation is"+sum/(size*size*n));
  
  sc.close();
    
  return;
 }
}
