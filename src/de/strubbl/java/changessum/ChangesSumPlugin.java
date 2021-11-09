package de.strubbl.java.changessum;

import org.openstreetmap.josm.gui.MapFrame;
import org.openstreetmap.josm.plugins.Plugin;
import org.openstreetmap.josm.plugins.PluginInformation;
import org.openstreetmap.josm.tools.Logging;

public class ChangesSumPlugin extends Plugin {
	/**
	 * Will be invoked by JOSM to bootstrap the plugin
	 *
	 * @param info information about the plugin and its local installation
	 */
	public ChangesSumPlugin(PluginInformation info) {
		super(info);
		// init your plugin
		Logging.debug("ChangesSumPlugin constructor");
	}

	public void mapFrameInitialized(MapFrame oldFrame, MapFrame newFrame) {
		if (oldFrame == null && newFrame != null) { // map frame added
			Logging.debug("ChangesSumPlugin mapFrameInitialized: map frame added");
		}
	}

}
