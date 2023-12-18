import java.util.HashMap;

import Items.*;

public class Main
{
    public static void main(String[] args)
    {
        Inventory playerInventory = new Inventory(new HashMap<>());
        playerInventory.AddItem(ItemFactory.CreateWood(), 4);
        System.out.println(playerInventory.GetItem(ItemFactory.CreateWood()));
    }
}