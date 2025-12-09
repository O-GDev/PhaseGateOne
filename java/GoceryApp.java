import java.util.Arrays;
import java.util.Scanner;
public class GoceryApp{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String welcomeMessage = """
_____________Welcome to Ebano_____________________

1.  Add Item
2.  Remove Item
3.  Show all available items
0.  Exit()
""";
    int toDo=4;
    String[] itemList = {};
    while(toDo!=0){
    System.out.println(welcomeMessage);
    System.out.println("What would you like to do? ");
    toDo = input.nextInt();
    if(toDo==1){
       itemList = addItem();      
    }else if(toDo == 2){
       itemList = removeItem(itemList);
    }else if(toDo ==3){
        for(int count=0;count<itemList.length;count++){
            System.out.println(itemList[count]);
        }
        }
}
    
//        String[] item = new String[numberOfItem];
//        System.out.println(Arrays.toString(item));
    }

    public static String[] addItem(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many item are you adding?: ");
        int numberOfItem = input.nextInt();
        String[] itemArray = new String[numberOfItem];
        for(int count=0; count<numberOfItem;count++){
            System.out.println("What is the name of item to add?: ");
            String itemName = input.nextLine();
            itemArray[count]=itemName;
        }
        return itemArray;
    }

    public static String[] removeItem(String[] items){
        Scanner input = new Scanner(System.in);
        System.out.println("What item are you removing?: ");
        String itemName = input.nextLine();
        int newCount = 0;
        String[] newItems = new String[items.length-1];
        for(int count=0; count<items.length;count++){
            if(items[count] == itemName){
            newItems[newCount] = items[count];
            newCount++;
            }
        }
        return newItems;
    }

    
}
