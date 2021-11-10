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
		Logging.info("ChangesSumPlugin ChangeListener dataChanged: e=" + e);
		getObjectChangesSum();
	}

	@Override
	public void nodeMoved(NodeMovedEvent e) {
		Logging.info("ChangesSumPlugin ChangeListener nodeMoved: e=" + e);
		getObjectChangesSum();
	}

	@Override
	public void otherDatasetChange(AbstractDatasetChangedEvent e) {
		Logging.info("ChangesSumPlugin ChangeListener otherDatasetChange: e=" + e);
		getObjectChangesSum();
	}

	@Override
	public void primitivesAdded(PrimitivesAddedEvent e) {
		Logging.info("ChangesSumPlugin ChangeListener primitivesAdded: e=" + e);
		getObjectChangesSum();
	}

	@Override
	public void primitivesRemoved(PrimitivesRemovedEvent e) {
		Logging.info("ChangesSumPlugin ChangeListener primitivesRemoved: e=" + e);
		getObjectChangesSum();
	}

	@Override
	public void relationMembersChanged(RelationMembersChangedEvent e) {
		Logging.info("ChangesSumPlugin ChangeListener relationMembersChanged: e=" + e);
		getObjectChangesSum();
	}

	@Override
	public void tagsChanged(TagsChangedEvent e) {
		Logging.info("ChangesSumPlugin ChangeListener tagsChanged: e=" + e);
		getObjectChangesSum();
	}

	@Override
	public void wayNodesChanged(WayNodesChangedEvent e) {
		Logging.info("ChangesSumPlugin ChangeListener wayNodesChanged: e=" + e);
		getObjectChangesSum();
	}

	private int getObjectChangesSum() {
		Logging.info("ChangesSumPlugin ChangeListener getObjectChangesSum");
		APIDataSet apiData = new APIDataSet(MainApplication.getLayerManager().getEditDataSet());
		List<OsmPrimitive> l = apiData.getPrimitives();
		Logging.info("ChangesSumPlugin getObjectChangesSum: l.size()=" + l.size());
		return l.size();
	}
}
