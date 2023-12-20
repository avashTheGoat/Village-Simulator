import java.lang.reflect.Constructor;
import java.util.HashMap;

import inventory.Inventory;
import resources.Food;
import resources.Resource;
import resources.Wood;
import resources.buildings.Building;
import resources.buildings.lumbermills.BasicLumberMill;

public class Main
{
    public static void main(String[] args)
    {
        Inventory<Resource> basicResourceInventory = new Inventory<>(new HashMap<>());
        basicResourceInventory.AddItem(new Wood(), 4);
        basicResourceInventory.AddItem(new Food());
        for (Class _basicResource : basicResourceInventory.GetAllItems().keySet())
        {
            Constructor[] _buildingConstructors = _basicResource.getConstructors();
            for (Constructor _constructor : _buildingConstructors)
            {
                Class[] _parameters = _constructor.getParameterTypes();

                System.out.println("Parameters: ");
                for (Class _parameterClass : _parameters)
                {
                    System.out.println(_parameterClass);
                }
            }
        }

        Inventory<Building> buildings = new Inventory<>(new HashMap<>());
        buildings.AddItem(new BasicLumberMill());
        for (Class _building : buildings.GetAllItems().keySet())
        {
            System.out.println(_building);
        }
    }
}