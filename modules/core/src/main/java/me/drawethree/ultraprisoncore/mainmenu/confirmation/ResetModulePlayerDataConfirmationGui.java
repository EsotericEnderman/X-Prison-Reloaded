package me.drawethree.ultraprisoncore.mainmenu.confirmation;

import me.drawethree.ultraprisoncore.UltraPrisonCore;
import me.drawethree.ultraprisoncore.UltraPrisonModule;
import me.drawethree.ultraprisoncore.utils.gui.ConfirmationGui;
import me.drawethree.ultraprisoncore.utils.player.PlayerUtils;
import org.bukkit.entity.Player;

public class ResetModulePlayerDataConfirmationGui extends ConfirmationGui {
	private final UltraPrisonModule module;

	public ResetModulePlayerDataConfirmationGui(Player player, UltraPrisonModule module) {
		super(player, module == null ? "Reset all player data ?" : "Reset " + module.getName() + " player data?");
		this.module = module;
	}

	@Override
	public void confirm(boolean confirm) {
		if (confirm) {
			if (module == null) {
				UltraPrisonCore.getInstance().getModules().forEach(module1 -> UltraPrisonCore.getInstance().getPluginDatabase().resetData(module1));
				PlayerUtils.sendMessage(this.getPlayer(), "&aSuccessfully reset player data of all modules.");
			} else {
				UltraPrisonCore.getInstance().getPluginDatabase().resetData(this.module);
				PlayerUtils.sendMessage(this.getPlayer(),"&aSuccessfully reset player data of &e&l" + this.module.getName() + " &amodule.");
			}

		}
		this.close();
	}
}
