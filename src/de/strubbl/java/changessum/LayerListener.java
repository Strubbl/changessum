package de.strubbl.java.changessum;

import org.openstreetmap.josm.gui.MainApplication;
import org.openstreetmap.josm.gui.layer.MainLayerManager.ActiveLayerChangeEvent;
import org.openstreetmap.josm.gui.layer.MainLayerManager.ActiveLayerChangeListener;
import org.openstreetmap.josm.tools.Logging;
import org.openstreetmap.josm.gui.layer.OsmDataLayer;

public class LayerListener implements ActiveLayerChangeListener{
	private final ChangeListener changeListener = new ChangeListener();

	@Override
	public void activeOrEditLayerChanged(ActiveLayerChangeEvent e) {
		Logging.info("ChangesSumPlugin LayerListener activeOrEditLayerChanged: ActiveLayerChangeEvent=" + e);
		OsmDataLayer old = e.getPreviousDataLayer();
		if (old != null) {
			old.getDataSet().removeDataSetListener(changeListener);
		}
		OsmDataLayer newL = MainApplication.getLayerManager().getEditLayer();
		if (newL != null) {
			newL.getDataSet().addDataSetListener(changeListener);
		}
	}
}
