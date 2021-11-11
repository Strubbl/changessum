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
	public LayerListener l;

	public ChangeListener(LayerListener l) {
		super();
		this.l = l;
	}

	@Override
	public void dataChanged(DataChangedEvent e) {
		Logging.debug("ChangesSumPlugin ChangeListener dataChanged: e=" + e);
		l.p.updateChangesSumLabel(getObjectChangesSum());
	}

	@Override
	public void nodeMoved(NodeMovedEvent e) {
		Logging.debug("ChangesSumPlugin ChangeListener nodeMoved: e=" + e);
		l.p.updateChangesSumLabel(getObjectChangesSum());
	}

	@Override
	public void otherDatasetChange(AbstractDatasetChangedEvent e) {
		Logging.debug("ChangesSumPlugin ChangeListener otherDatasetChange: e=" + e);
		l.p.updateChangesSumLabel(getObjectChangesSum());
	}

	@Override
	public void primitivesAdded(PrimitivesAddedEvent e) {
		Logging.debug("ChangesSumPlugin ChangeListener primitivesAdded: e=" + e);
		l.p.updateChangesSumLabel(getObjectChangesSum());
	}

	@Override
	public void primitivesRemoved(PrimitivesRemovedEvent e) {
		Logging.debug("ChangesSumPlugin ChangeListener primitivesRemoved: e=" + e);
		l.p.updateChangesSumLabel(getObjectChangesSum());
	}

	@Override
	public void relationMembersChanged(RelationMembersChangedEvent e) {
		Logging.debug("ChangesSumPlugin ChangeListener relationMembersChanged: e=" + e);
		l.p.updateChangesSumLabel(getObjectChangesSum());
	}

	@Override
	public void tagsChanged(TagsChangedEvent e) {
		Logging.debug("ChangesSumPlugin ChangeListener tagsChanged: e=" + e);
		l.p.updateChangesSumLabel(getObjectChangesSum());
	}

	@Override
	public void wayNodesChanged(WayNodesChangedEvent e) {
		Logging.debug("ChangesSumPlugin ChangeListener wayNodesChanged: e=" + e);
		l.p.updateChangesSumLabel(getObjectChangesSum());
	}

	private int getObjectChangesSum() {
		Logging.debug("ChangesSumPlugin ChangeListener getObjectChangesSum");
		APIDataSet apiData = new APIDataSet(MainApplication.getLayerManager().getEditDataSet());
		List<OsmPrimitive> l = apiData.getPrimitives();
		Logging.debug("ChangesSumPlugin getObjectChangesSum: l.size()=" + l.size());
		return l.size();
	}
}
