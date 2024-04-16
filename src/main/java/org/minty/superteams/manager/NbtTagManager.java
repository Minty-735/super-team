package org.minty.superteams.manager;



import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.inventory.ItemStack;

public class NbtTagManager {

    public static String getNBTTag(ItemStack item, String key) {
        NBTItem nbti = new NBTItem(item);
        String tagValue = nbti.getString(key);
        return tagValue;
    }

    public static ItemStack setNBTTag(ItemStack item, String key, String value) {
        NBTItem nbti = new NBTItem(item);
        nbti.setString(key, value); // Устанавливаем значение тега "myTag"
        return nbti.getItem();
    }


}
