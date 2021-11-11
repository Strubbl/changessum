package de.strubbl.java.changessum;

import org.openstreetmap.josm.gui.MainApplication;
import org.openstreetmap.josm.gui.layer.Layer;
import org.openstreetmap.josm.gui.layer.LayerManager.LayerAddEvent;
import org.openstreetmap.josm.gui.layer.LayerManager.LayerChangeListener;
import org.openstreetmap.josm.gui.layer.LayerManager.LayerOrderChangeEvent;
import org.openstreetmap.josm.gui.layer.LayerManager.LayerRemoveEvent;
import org.openstreetmap.josm.gui.layer.MainLayerManager.ActiveLayerChangeEvent;
import org.openstreetmap.josm.gui.layer.MainLayerManager.ActiveLayerChangeListener;
import org.openstreetmap.josm.gui.layer.OsmDataLayer;
import org.openstreetmap.josm.tools.Logging;

public class LayerListener implements LayerChangeListener, ActiveLayerChangeListener {
	private final ChangeListener changeListener;
	public ChangesSumPlugin p;

	public LayerListener(ChangesSumPlugin p) {
		super();
		this.p = p;
		changeListener = new ChangeListener(this);
	}

	@Override
	public void layerAdded(LayerAddEvent e) {
		Logging.debug("ChangesSumPlugin layerAdded");
		Layer addedL = e.getAddedLayer();
		if (addedL instanceof OsmDataLayer) {
			Logging.debug("ChangesSumPlugin layerAdded: added layer is instance of OsmDataLayer");
			((OsmDataLayer) addedL).getDataSet().addDataSetListener(changeListener);
		}
	}

	@Override
	public void layerOrderChanged(LayerOrderChangeEvent e) {
		Logging.debug("ChangesSumPlugin layerOrderChanged");
	}

	@Override
	public void layerRemoving(LayerRemoveEvent e) {
		Logging.debug("ChangesSumPlugin layerRemoving");
		Layer removedL = e.getRemovedLayer();
		if (removedL instanceof OsmDataLayer) {
			Logging.debug("ChangesSumPlugin layerRemoving: removed layer is instance of OsmDataLayer");
			((OsmDataLayer) removedL).getDataSet().removeDataSetListener(changeListener);
		}
	}

	@Override
	public void activeOrEditLayerChanged(ActiveLayerChangeEvent e) {
		Logging.debug("ChangesSumPlugin LayerListener activeOrEditLayerChanged: ActiveLayerChangeEvent=" + e);
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
