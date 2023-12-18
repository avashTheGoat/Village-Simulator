package Items;
public class Item
{
    private String itemName;

    public Item(String _itemName)
    {
        itemName = _itemName;
    }

    //#region Getters
    public String GetItemName() { return itemName; }
    //#endregion
}