package de.strubbl.java.changessum;

import java.util.List;

import org.openstreetmap.josm.data.APIDataSet;
import org.openstreetmap.josm.data.osm.OsmPrimitive;
import org.openstreetmap.josm.data.osm.event.AbstractDatasetChangedEvent;
import org.openstreetmap.josm.data.osm.event.DataChangedEvent;
import org.openstreetmap.josm.data.osm.event.DataSetListener;
import org.openstreetmap.josm.data.osm.event.NodeMovedEvent;
import org.openstreetmap.josm.data.osm.event.PrimitivesAddedEvent;
import org.openstreetmap.josm.data.osm.event.PrimitivesRemovedEvent;
import org.openstreetmap.josm.data.osm.event.RelationMembersChangedEvent;
import org.openstreetmap.josm.data.osm.event.TagsChangedEvent;
import org.openstreetmap.josm.data.osm.event.WayNodesChangedEvent;
import org.openstreetmap.josm.gui.MainApplication;
import org.openstreetmap.josm.tools.Logging;

public class ChangeListener implements DataSetListener {

	@Override
	public void dataChanged(DataChangedEvent e) {
		getObjectChangesSum();
	}

	@Override
	public void nodeMoved(NodeMovedEvent e) {
		getObjectChangesSum();
	}

	@Override
	public void otherDatasetChange(AbstractDatasetChangedEvent e) {
		getObjectChangesSum();
	}

	@Override
	public void primitivesAdded(PrimitivesAddedEvent e) {
		getObjectChangesSum();
	}

	@Override
	public void primitivesRemoved(PrimitivesRemovedEvent e) {
		getObjectChangesSum();
	}

	@Override
	public void relationMembersChanged(RelationMembersChangedEvent e) {
		getObjectChangesSum();
	}

	@Override
	public void tagsChanged(TagsChangedEvent e) {
		getObjectChangesSum();
	}

	@Override
	public void wayNodesChanged(WayNodesChangedEvent e) {
		getObjectChangesSum();
	}
	
	private int getObjectChangesSum() {
		APIDataSet apiData = new APIDataSet(MainApplication.getLayerManager().getEditDataSet());
		List<OsmPrimitive> l = apiData.getPrimitives();
		Logging.info("ChangesSumPlugin getObjectChangesSum: l.size()=" + l.size());
		return l.size();
	}
}
