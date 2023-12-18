package Items;

public class ItemFactory
{
    public static Item CreateWood()
    {
        return new Item("Wood");
    }

    public static Item CreateFood()
    {
        return new Item("Food");
    }
}