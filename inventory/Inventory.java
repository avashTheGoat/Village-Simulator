package inventory;

import java.util.Map;

import resources.Resource;

import java.util.HashMap;

public class Inventory<T extends Resource>
{
    private Map<Class, Integer> inventory;

    public Inventory(Map<T, Integer> _initialInventory)
    {
        inventory = new HashMap<>();
        
        for (T _item : _initialInventory.keySet())
        {
            int _itemCount = _initialInventory.get(_item);

            if (_itemCount < 0)
            {
                throw new IllegalArgumentException("Item count for item \"" + _item.GetResourceName() + "\" " +
                "should not be negative. It is " + _itemCount);
            }

            if (_itemCount == 0)
            {
                continue;
            }

            AddItem(_item, _itemCount);
        }
    }

    //#region Setters
    public void AddItem(T _item)
    {
        if (inventory.containsKey(_item.getClass()))
        {
            inventory.put(_item.getClass(), inventory.get(_item.getClass()) + 1);
        }

        else
        {
            inventory.put(_item.getClass(), 1);
        }
    }

    public void AddItem(T _item, int _count)
    {
        if (inventory.containsKey(_item.getClass()))
        {
            inventory.put(_item.getClass(), inventory.get(_item.getClass()) + _count);
        }

        else
        {
            inventory.put(_item.getClass(), _count);
        }
    }

    public boolean RemoveItem(T _item)
    {
        if (!inventory.containsKey(_item.getClass()))
        {
            return false;
        }

        int _newItemCount = inventory.get(_item.getClass()) - 1;

        if (_newItemCount <= 0)
        {
            inventory.remove(_item.getClass());
        }

        return true;
    }

    public int RemoveItem(T _item, int _count)
    {
        if (!inventory.containsKey(_item.getClass()))
        {
            return -1;
        }

        int _newItemCount = inventory.get(_item.getClass()) - _count;

        if (_newItemCount <= 0)
        {
            inventory.remove(_item.getClass());
            return _newItemCount + _count;
        }

        return _count;
    }
    //#endregion

    //#region Getters
    public int GetItem(T _item)
    {
        if (!inventory.containsKey(_item.getClass()))
        {
            return -1;
        }

        return inventory.get(_item.getClass());
    }
    
    public Map<Class, Integer> GetAllItems()
    {
        return new HashMap<>(inventory);
    }
    //#endregion
}