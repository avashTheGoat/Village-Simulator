package resources.buildings.lumbermills;

import java.util.HashMap;

import inventory.Inventory;
import resources.*;
import resources.buildings.Building;

public class BasicLumberMill extends Building
{
    private int woodProduction;
    
    public BasicLumberMill()
    {
        super("Lumber mill (basic)", new HashMap<>());
        woodProduction = 1;
    }

    @Override
    public void DoBuildingEffect(Inventory<Resource> _inventory)
    {
        _inventory.AddItem(new Wood(), woodProduction);
    }

    //#region Getters
    public int GetWoodProduction()
    {
        return woodProduction;
    }
    //#endregion
}