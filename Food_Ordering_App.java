import java.util.ArrayList;
import java.util.Scanner;

public class Food_Ordering_App 
{
    public ArrayList<String> cart = new ArrayList<>();
    public ArrayList<Integer> cart_item_number = new ArrayList<>();
    public ArrayList<Double> cart_item_price = new ArrayList<>();
    public double total;
    public boolean finished;
    
    public int[] id_array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    public String[] name_array = {"Burger", "Pizza", "Pasta", "Salad", "Sushi", "Fries", "Hotdog", "Sandwich", "Steak", "Chicken", "Fish", "Tacos", "Burrito", "Soup", "Ice Cream"};
    public double[] price_array = {5.99, 8.99, 7.99, 4.99, 12.99, 3.49, 4.49, 6.99, 14.99, 10.99, 9.99, 2.99, 3.99, 5.49, 3.99};
    
    public void view_menu() 
    {
        System.out.println("Menu:");
        for (int i = 0; i < id_array.length; i++) 
        {
            System.out.println(id_array[i] + ". " + name_array[i] + " - $" + price_array[i]);
        }
    }

    public void add_item(int item) 
    {
        // check item range must be between 1 and 15
        if (item > 15 || item < 1) {
            System.out.println("Invalid item number");
        } 
        else 
        {
            // add id to cart_item_number
            cart_item_number.add(item);
            // add name to cart
            cart.add(name_array[item - 1]);
            // add price to price array
            cart_item_price.add(price_array[item - 1]);
            //add price to total
            total += price_array[item - 1];
            System.out.println(name_array[item - 1] + " added to the cart.");
        }
    }

    public void view_cart() 
    {
        //check if there is anything in the cart
        if (cart_item_number.size() == 0) 
        {
            System.out.println("There are no items in the cart");
        } 
        else 
        {
            // iterate and print all items
            System.out.println("Your Cart:");
            for (int i = 0; i < cart.size(); i++) 
            {
                System.out.println(cart_item_number.get(i) + ". " + cart.get(i) + " - $" + cart_item_price.get(i));
            }
            System.out.println("Total: $" + total);
        }
    }

    public void remove_item(int input) 
    {
        // check if cart is empty
        if (cart_item_number.size() == 0) {
            System.out.println("There are no items in the cart");
        } 
        else 
        {
            // remove item if valid
            int index = cart_item_number.indexOf(input);
            if (index != -1) {
                System.out.println(cart.get(index) + " removed from the cart.");
                total -= cart_item_price.get(index);
                cart.remove(index);
                cart_item_number.remove(index);
                cart_item_price.remove(index);
            } 
            else 
            {
                System.out.println("Item not found in the cart");
            }
        }
    }

    public void place_order() 
    {
        // check if there any items in the cart
        if (cart_item_number.size() == 0) {
            System.out.println("There are no items in the cart");
        } 
        else 
        // if there are print total and recipt
        {
            System.out.println("Order placed successfully!");
            System.out.println("Total: $" + total);
        }
    }

    public static void main(String[] args) 
    {
        Food_Ordering_App app = new Food_Ordering_App();
        app.finished = false;
        Scanner scan = new Scanner(System.in);
        
        app.view_menu();

        while (!app.finished) 
        {
            int input = 0;
            System.out.println("Enter 1 to add an item\nEnter 2 to remove an item\nEnter 3 to view the cart\nEnter 4 to finalize order");
            
            try 
            {
                input = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
                scan.next(); 
                continue;
            }
            
            if (input == 1) 
            {
                System.out.print("What item number would you like to add? ");
                try 
                {
                    input = scan.nextInt();
                    app.add_item(input);
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    scan.next(); 
                }
            } 
            else if (input == 2) 
            {
                System.out.print("What item number would you like to remove? ");
                try 
                {
                    input = scan.nextInt();
                    app.remove_item(input);
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    scan.next(); 
                }
            } 
            else if (input == 3) 
            {
                app.view_cart();
            } 
            else if (input == 4) 
            {
                app.place_order();
                app.finished = true;
            } 
            else 
            {
                System.out.println("Invalid input");
            }
        }

        scan.close();
    }
}