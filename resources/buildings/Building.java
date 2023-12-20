package resources.buildings;

import java.util.Map;

import inventory.Inventory;
import resources.Resource;

public abstract class Building extends Resource implements Cloneable
{    
    private String buildingName;
    private Inventory<Resource> costs;

    public Building(String _buildingName, Map<Resource, Integer> _costs)
    {
        super(_buildingName);
        costs = new Inventory<>(_costs);
    }
    
    public abstract void DoBuildingEffect(Inventory<Resource> _inventory);

    @Override
    public boolean equals(Object obj)
    {
        if (obj.getClass() != this.getClass())
        {
            throw new IllegalArgumentException("Object passed in should be a building. " +
            "It is a " + obj.getClass() + " instead.");
        }

        Building objAsBuilding = (Building) obj;

        return this.buildingName == objAsBuilding.GetBuildingName();
    }

    //#region Getters
    public Map<Class, Integer> GetCosts()
    {
        return costs.GetAllItems();
    }

    public String GetBuildingName()
    {
        return buildingName;
    }
    //#endregion
}