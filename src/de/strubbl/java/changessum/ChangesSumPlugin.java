package de.strubbl.java.changessum;

import java.util.List;

import org.openstreetmap.josm.data.APIDataSet;
import org.openstreetmap.josm.data.osm.OsmPrimitive;
import org.openstreetmap.josm.gui.MainApplication;
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
		getObjectChangesSum();
	}

	private int getObjectChangesSum() {
		APIDataSet apiData = new APIDataSet(MainApplication.getLayerManager().getEditDataSet());
		List<OsmPrimitive> l = apiData.getPrimitives();
		Logging.info("ChangesSumPlugin getObjectChangesSum: l.size()=" + l.size());
		return l.size();
	}
}
