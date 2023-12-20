package resources;

public abstract class Resource
{
    private String itemName;

    public Resource(String _resourceName)
    {
        itemName = _resourceName;
    }

    //#region Getters
    public String GetResourceName() { return itemName; }
    //#endregion
}