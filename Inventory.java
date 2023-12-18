import java.util.Map;

import Items.Item;

public class Inventory
{
    private Map<String, Integer> inventory;

    public Inventory(Map<String, Integer> _initialInventory)
    {
        inventory = _initialInventory;
    }

    public void AddItem(Item _item)
    {
        if (inventory.containsKey(_item.GetItemName()))
        {
            inventory.put(_item.GetItemName(), inventory.get(_item.GetItemName()) + 1);
        }

        else
        {
            inventory.put(_item.GetItemName(), 1);
        }
    }

    public void AddItem(Item _item, int _count)
    {
        if (inventory.containsKey(_item.GetItemName()))
        {
            inventory.put(_item.GetItemName(), inventory.get(_item.GetItemName()) + _count);
        }

        else
        {
            inventory.put(_item.GetItemName(), _count);
        }
    }

    public boolean RemoveItem(Item _item)
    {
        if (!inventory.containsKey(_item.GetItemName()))
        {
            return false;
        }

        int _newItemCount = inventory.get(_item.GetItemName()) - 1;

        if (_newItemCount <= 0)
        {
            inventory.remove(_item.GetItemName());
        }

        return true;
    }

    public int RemoveItem(Item _item, int _count)
    {
        if (!inventory.containsKey(_item.GetItemName()))
        {
            return -1;
        }

        int _newItemCount = inventory.get(_item.GetItemName()) - _count;

        if (_newItemCount <= 0)
        {
            inventory.remove(_item.GetItemName());
            return _newItemCount + _count;
        }

        return _count;
    }

    public int GetItem(Item _item)
    {
        if (!inventory.containsKey(_item.GetItemName()))
        {
            return -1;
        }

        return inventory.get(_item.GetItemName());
    }
}