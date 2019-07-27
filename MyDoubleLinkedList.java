package cn.list;

/**
 * @ClassName MyDoubleLinkedList
 * @Description 不带头结点的双循环链表
 * @Auther danni
 * @Date 2019/7/26 10:43]
 * @Version 1.0
 **/

public class MyDoubleLinkedList {
    //头插法
    public Dnode firstAdd(Dnode dnode,int datas ){
        Dnode  d=dnode;
        Dnode temp=new Dnode(datas);
        if(d==null){
            d=temp;
        }
        else{
           d.first=temp;
           temp.last=d;
           d=temp;
        }
        return d;
    }
    //尾插法
    public Dnode lastAdd(Dnode dnode,int datas){
        Dnode  d=dnode;
        Dnode temp=new Dnode(datas);
        if(d==null){
            d=temp;
        }
        else{
            while(d.last!=null){
                d=d.last;
            }
            d.last=temp;
            temp.first=d;
        }
        return dnode;
    }
    //任意位置插入
   public  Dnode addindexDouble(Dnode dnode,int location,int data){
       if(location>this.length(dnode)){
           System.err.println("指定位置无效，无法插入，返回原链表");
           return dnode;
       }
       if(location==1){
           dnode=this.firstAdd(dnode,data);
           return dnode;
       }
       if(location==this.length(dnode)+1){
           dnode=this.lastAdd(dnode,data);
           return dnode;
       }
       Dnode temp=dnode;
       Dnode m=new Dnode(data);
       for (int i = 1; i <location-1 ; i++) {
           temp=temp.last;
       }
       m.last=temp.last;
       temp.last.first=m;
       temp.last=m;
       m.first=temp;
        return dnode;
   }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(Dnode dnode, int key){
        if(this.isEmpty(dnode)){
            System.err.println("链表为空");
            return false;
        }
        Dnode n=dnode;
        while(n!=null){
            if(n.data==key){
                return true;
            }
            else{
                n=n.last;
            }
        }
        return false;
    }
    //正向打印双向链表
    public void printDoubleLinkedList_right(Dnode dnode){
        Dnode temp=dnode;
        while(temp!=null){
            System.out.print(temp);
            temp=temp.last;
        }
        System.out.print("null");
    }
    //反向打印双向链表
    public void printDoubleLinkedList_left(Dnode dnode){
        Dnode temp=dnode;
        while(temp.last!=null){
            temp=temp.last;
        }
        while(temp!=null){
            System.out.print(temp);
            temp=temp.first;
        }
        System.out.println("null");
    }
    //判空
    public boolean isEmpty(Dnode dnode){
        if(dnode==null){
            return true;
        }
        return false;
    }
    //返回双循环链表的长度
    public  int length(Dnode dnode){
        if(this.isEmpty(dnode)){
            return 0;
        }
        Dnode temp=dnode;
        int num=0;
        while(temp!=null){
            num++;
            temp=temp.last;
        }
        return num;
    }
    public static void main(String[] args) {
        Dnode dnode=new Dnode();
        dnode=null;
        MyDoubleLinkedList dl=new MyDoubleLinkedList();
        dnode=dl.firstAdd(dnode,3);
        dnode=dl.firstAdd(dnode,4);
        dnode=dl.firstAdd(dnode,5);
        dnode=dl.firstAdd(dnode,6);
        dnode=dl.lastAdd(dnode,2);
        dnode=dl.lastAdd(dnode,1);
        dnode=dl.lastAdd(dnode,0);
        dnode=dl.addindexDouble(dnode,1,9);
        dnode=dl.addindexDouble(dnode,1,10);
        dnode=dl.addindexDouble(dnode,3,8);
        System.out.println(dl.contains(dnode,0));
        dl.printDoubleLinkedList_right(dnode);
        System.out.println();
        dl.printDoubleLinkedList_left(dnode);

    }
}
class Dnode{
    int data;
    Dnode first=null;
    Dnode last=null;

    public Dnode(int data) {
        this.data = data;
    }


    public Dnode() {
    }
    public String toString(){
        return String.format("(Node%d)->",data);
    }
}
