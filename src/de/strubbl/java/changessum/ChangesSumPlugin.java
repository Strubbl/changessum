package de.strubbl.java.changessum;

import javax.swing.JLabel;

import org.openstreetmap.josm.gui.MainApplication;
import org.openstreetmap.josm.gui.MapFrame;
import org.openstreetmap.josm.gui.MapStatus;
import org.openstreetmap.josm.plugins.Plugin;
import org.openstreetmap.josm.plugins.PluginInformation;
import org.openstreetmap.josm.spi.preferences.Config;
import org.openstreetmap.josm.tools.Logging;

public class ChangesSumPlugin extends Plugin {
	private LayerListener l;
	private MapFrame mf;
	private JLabel changesLabel;
	private int changesSum;

	/**
	 * Will be invoked by JOSM to bootstrap the plugin
	 *
	 * @param info information about the plugin and its local installation
	 */
	public ChangesSumPlugin(PluginInformation info) {
		super(info);
		// init your plugin
		Logging.info("ChangesSumPlugin constructor");
		changesSum = 0;
		l = new LayerListener(this);
		MainApplication.getLayerManager().addLayerChangeListener(l);
	}

	public void mapFrameInitialized(MapFrame oldF, MapFrame newF) {
		if (oldF == null && newF != null) {
			addChangesSumToStatusBar();
		}
	}

	private void addChangesSumToStatusBar() {
		mf = MainApplication.getMap();
		MapStatus ms = mf.statusLine;
		if (ms != null && Config.getPref().getBoolean("statusline.visible", true)) {
			changesLabel = new JLabel("sum:" + changesSum);
			ms.add(changesLabel);
		}
	}

	public void updateChangesSumLabel(int newSum) {
		Logging.info("ChangesSumPlugin updateChangesSumLabel: newSum=" + newSum);
		changesSum = newSum;
		changesLabel.setText("sum: " + changesSum);
	}
}
