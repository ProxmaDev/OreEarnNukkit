package SchdowNVIDIA.OreEarn;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import me.onebone.economyapi.EconomyAPI;

public class MainClass extends PluginBase implements Listener {

    @Override
    public void onEnable() {

        getLogger().info("Plugin aktiviert!");
        getServer().getPluginManager().registerEvents(this, this);
        this.saveResource("messages.yml");
        this.saveDefaultConfig();
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Block block = event.getBlock();
        int blockid = block.getId();

        Player player = event.getPlayer();

        Config messages = new Config(this.getDataFolder() + "/messages.yml", Config.YAML);
        if(player.getGamemode() != 1 || player.getGamemode() != 3) {
            switch (blockid) {
                case Block.STONE:
                    double stoneEarn = this.getConfig().get("earnings.stoneEarn", 0);
                    EconomyAPI.getInstance().addMoney(player, stoneEarn);
                case Block.COAL_ORE:
                    double coalEarn = this.getConfig().get("earnings.coalEarn", 0);
                    EconomyAPI.getInstance().addMoney(player, coalEarn);
                    if (this.getConfig().get("enablePopup", true)) {
                        player.sendPopup(PopupConvert(messages.get("coalEarn", "Message Config Error!"), coalEarn));
                    }
                    break;
                case Block.IRON_ORE:
                    double ironEarn = this.getConfig().get("earnings.ironEarn", 0);
                    EconomyAPI.getInstance().addMoney(player, ironEarn);
                    if (this.getConfig().get("enablePopup", true)) {
                        player.sendPopup(PopupConvert(messages.get("ironEarn", "Message Config Error!"), ironEarn));
                    }
                    event.setDrops(new Item[]{Item.get(Item.IRON_INGOT, 0, 1)});
                    break;
                case Block.GOLD_ORE:
                    double goldEarn = this.getConfig().get("earnings.goldEarn", 0);
                    EconomyAPI.getInstance().addMoney(player, goldEarn);
                    if (this.getConfig().get("enablePopup", true)) {
                        player.sendPopup(PopupConvert(messages.get("goldEarn", "Message Config Error!"), goldEarn));
                    }
                    event.setDrops(new Item[]{Item.get(Item.GOLD_INGOT, 0, 1)});
                    break;
                case Block.REDSTONE_ORE:
                case Block.GLOWING_REDSTONE_ORE:
                    double redstoneEarn = this.getConfig().get("earnings.redstoneEarn", 0);
                    EconomyAPI.getInstance().addMoney(player, redstoneEarn);
                    if (this.getConfig().get("enablePopup", true)) {
                        player.sendPopup(PopupConvert(messages.get("redstoneEarn", "Message Config Error!"), redstoneEarn));
                    }
                    break;
                case Block.QUARTZ_ORE:
                    double quartzEarn = this.getConfig().get("earnings.quartzEarn", 0);
                    EconomyAPI.getInstance().addMoney(player, quartzEarn);
                    if (this.getConfig().get("enablePopup", true)) {
                        player.sendPopup(PopupConvert(messages.get("quartzEarn", "Message Config Error!"), quartzEarn));
                    }
                    break;
                case Block.DIAMOND_ORE:
                    double diamondEarn = this.getConfig().get("earnings.diamondEarn", 0);
                    EconomyAPI.getInstance().addMoney(player, diamondEarn);
                    if (this.getConfig().get("enablePopup", true)) {
                        player.sendPopup(PopupConvert(messages.get("diamondEarn", "Message Config Error!"), diamondEarn));
                    }
                    break;
                case Block.LAPIS_ORE:
                    double lapisEarn = this.getConfig().get("earnings.lapisEarn", 0);
                    EconomyAPI.getInstance().addMoney(player, lapisEarn);
                    if (this.getConfig().get("enablePopup", true)) {
                        player.sendPopup(PopupConvert(messages.get("lapisEarn", "Message Config Error!"), lapisEarn));
                    }
                    break;
                case Block.EMERALD_ORE:
                    double emeraldEarn = this.getConfig().get("earnings.emeraldEarn", 0);
                    EconomyAPI.getInstance().addMoney(player, emeraldEarn);
                    if (this.getConfig().get("enablePopup", true)) {
                        player.sendPopup(PopupConvert(messages.get("emeraldEarn", "Message Config Error!"), emeraldEarn));
                    }
                    break;
            }
        }

    }

    private String PopupConvert(String string, double earning) {
        return string.replace("{money}", "" + earning);
    }

}
