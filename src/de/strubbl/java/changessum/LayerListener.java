package de.strubbl.java.changessum;

import org.openstreetmap.josm.gui.MainApplication;
import org.openstreetmap.josm.gui.layer.Layer;
import org.openstreetmap.josm.gui.layer.LayerManager.LayerAddEvent;
import org.openstreetmap.josm.gui.layer.LayerManager.LayerChangeListener;
import org.openstreetmap.josm.gui.layer.LayerManager.LayerOrderChangeEvent;
import org.openstreetmap.josm.gui.layer.LayerManager.LayerRemoveEvent;
import org.openstreetmap.josm.gui.layer.MainLayerManager.ActiveLayerChangeEvent;
import org.openstreetmap.josm.gui.layer.MainLayerManager.ActiveLayerChangeListener;
import org.openstreetmap.josm.tools.Logging;
import org.openstreetmap.josm.gui.layer.OsmDataLayer;

public class LayerListener implements LayerChangeListener, ActiveLayerChangeListener {
	private final ChangeListener changeListener = new ChangeListener();

	@Override
	public void layerAdded(LayerAddEvent e) {
		Logging.info("ChangesSumPlugin layerAdded");
		Layer addedL = e.getAddedLayer();
		if (addedL instanceof OsmDataLayer) {
			Logging.info("ChangesSumPlugin layerAdded: added layer is instance of OsmDataLayer");
			((OsmDataLayer) addedL).getDataSet().addDataSetListener(changeListener);
		}
	}

	@Override
	public void layerOrderChanged(LayerOrderChangeEvent e) {
		Logging.info("ChangesSumPlugin layerOrderChanged");
	}

	@Override
	public void layerRemoving(LayerRemoveEvent e) {
		Logging.info("ChangesSumPlugin layerRemoving");
	}

	@Override
	public void activeOrEditLayerChanged(ActiveLayerChangeEvent e) {
		Logging.info("ChangesSumPlugin LayerListener activeOrEditLayerChanged: ActiveLayerChangeEvent=" + e);
		OsmDataLayer oldL = e.getPreviousDataLayer();
		if (oldL != null) {
			oldL.getDataSet().removeDataSetListener(changeListener);
		}
		OsmDataLayer newL = MainApplication.getLayerManager().getEditLayer();
		if (newL != null) {
			newL.getDataSet().addDataSetListener(changeListener);
		}
	}
}
