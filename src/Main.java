import java.util.*;
class products{
    char c;
    int amount;
    int number_of_products;
    products(char c,int amount,int number_of_products){
        this.c=c;
        this.amount=amount;
        this.number_of_products=number_of_products;
    }
}class customers{
    int balance;
    int id;
    char[] items;
    int no_of_items;
    customers(int id,int balance,char[] items,int no_of_items){items=new char[no_of_items];
        this.id=id;
        this.balance=balance;
        for(int i=0;i<no_of_items;i++)
        this.items[i]=items[i];
        this.no_of_items=no_of_items;
    }
}
public class Main {
    public static void sol(List<products> p,List<customers> c){
        for(int i=0;i<c.size();i++){
            for(int j=0;j<c.get(i).no_of_items;i++){
                for(int k=0;k<5;k++){
                    if(c.get(i).balance>=0){
                        if(c.get(i).items[j]==k && c.get(i).balance-p.get(k).amount>=0 && p.get(k).number_of_products>0)
                        {
                            p.get(k).number_of_products--;
                            c.get(i).balance=c.get(i).balance-p.get(k).amount;
                        }
                    }
                }
            }
        }
    }
    //for amazon remaining prodects;
    public static HashMap<Character,Integer> cbalance(List<products> p){
        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0;i<5;i++){
            h.put(p.get(i).c,p.get(i).number_of_products);
        }
        return h;
    }
    //for customer balance;
    public static int pbalance(int id,List<customers> p){
        for(int i=0;i<p.size();i++){
            if(p.get(i).id==id)
                return p.get(i).balance;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        List<products> p=new ArrayList<>();
        p.add(new products('a',500,8));
        p.add(new products('b',600,7));
        p.add(new products('c',700,8));
        p.add(new products('d',800,28));
        p.add(new products('e',900,18));
        List<customers> c=new ArrayList<>();
        for(int i=0;i<t;i++){
            int id=sc.nextInt();
            int balance= sc.nextInt();
            int no_of_items= sc.nextInt();
            char[] items=new char[no_of_items];
            for(int j=0;j<no_of_items;j++)
            items[j]= sc.next().charAt(0);
            c.add(new customers(id,balance,items,no_of_items));
        }
        sol(p,c);
        int queries= sc.nextInt();
        for(int i=0;i<queries;i++){
            int x= sc.nextInt();
            if(x==0)
                System.out.println(cbalance(p));
            else{
                int id= sc.nextInt();

                    System.out.println(pbalance(id,c));
            }
        }
    }
}