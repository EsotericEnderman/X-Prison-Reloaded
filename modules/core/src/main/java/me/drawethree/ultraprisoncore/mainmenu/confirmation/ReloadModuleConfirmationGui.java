package me.drawethree.ultraprisoncore.mainmenu.confirmation;

import me.drawethree.ultraprisoncore.UltraPrisonCore;
import me.drawethree.ultraprisoncore.UltraPrisonModule;
import me.drawethree.ultraprisoncore.utils.gui.ConfirmationGui;
import me.drawethree.ultraprisoncore.utils.player.PlayerUtils;
import org.bukkit.entity.Player;

public class ReloadModuleConfirmationGui extends ConfirmationGui {

	private final UltraPrisonModule module;

	public ReloadModuleConfirmationGui(Player player, UltraPrisonModule module) {
		super(player, module == null ? "Reload all modules ?" : "Reload module " + module.getName() + "?");
		this.module = module;
	}

	@Override
	public void confirm(boolean confirm) {
		if (confirm) {
			if (module == null) {
				UltraPrisonCore.getInstance().getModules().forEach(module1 -> UltraPrisonCore.getInstance().reloadModule(module1));
				PlayerUtils.sendMessage(this.getPlayer(), "&aSuccessfully reloaded all modules.");
			} else {
				UltraPrisonCore.getInstance().reloadModule(module);
				PlayerUtils.sendMessage(this.getPlayer(), "&aSuccessfully reloaded &e&l" + this.module.getName() + " &amodule.");
			}
		}
		this.close();
	}
}
