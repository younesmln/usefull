public class Find{
    
    public int[][] find(int n,int h[]){
        
        int [][]a=new int[n][2];
        for(int i=0;i<n;i++)
        {
            a[i][0]=this.max_pos_l(i,h);
            a[i][1]=this.max_pos_r(i,h);
        }
        return a;
    }
    
    public int max_pos_r(int pos,int tab[])
    {
        int max=pos;
        if(pos >= tab.length) return -1;
        for(int i=pos+1;i<tab.length;++i)
        {
            if(tab[pos]<tab[i]) max=i;
        }
        if(max==pos) return -1;
        else return max+1;
        
    }
    
    public int max_pos_l(int pos,int tab[])
    {
        int max=pos;
        if(pos >= tab.length) return -1;
        for(int i=pos-1;i>=0;--i)
        {
            if(tab[pos]<tab[i]) max=i; 
        }
        if(max==pos) return -1;
        else return max+1;   
    }
    
    public void show(int h[][])
    {
        for(int i=0;i<h.length;++i)
        {
            for(int j=0;j<h[i].length;++j)
            {
                System.out.print(h[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String args[]){
        Find t=new Find();
        int a[]=new int[]{172,169,171};
        int res[][]=t.find(3,a);
        t.show(res);
    }
}
