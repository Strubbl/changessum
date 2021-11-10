package de.strubbl.java.changessum;

import org.openstreetmap.josm.gui.MainApplication;
import org.openstreetmap.josm.gui.MapFrame;
import org.openstreetmap.josm.plugins.Plugin;
import org.openstreetmap.josm.plugins.PluginInformation;
import org.openstreetmap.josm.tools.Logging;

public class ChangesSumPlugin extends Plugin {
	private LayerListener l;

	/**
	 * Will be invoked by JOSM to bootstrap the plugin
	 *
	 * @param info information about the plugin and its local installation
	 */
	public ChangesSumPlugin(PluginInformation info) {
		super(info);
		// init your plugin
		Logging.info("ChangesSumPlugin constructor");
		l = new LayerListener();
		MainApplication.getLayerManager().addLayerChangeListener(l);
	}

	@Override
	public void mapFrameInitialized(MapFrame oldFrame, MapFrame newFrame) {
		Logging.info("ChangesSumPlugin mapFrameInitialized");
		if (oldFrame == null && newFrame != null) { // map frame added
			Logging.info("ChangesSumPlugin mapFrameInitialized: map frame added");
		}
	}

}
