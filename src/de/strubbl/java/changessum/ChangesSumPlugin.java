package de.strubbl.java.changessum;

import org.openstreetmap.josm.gui.MainApplication;
import org.openstreetmap.josm.plugins.Plugin;
import org.openstreetmap.josm.plugins.PluginInformation;
import org.openstreetmap.josm.tools.Logging;

public class ChangesSumPlugin extends Plugin {
    /**
     * Will be invoked by JOSM to bootstrap the plugin
     *
     * @param info  information about the plugin and its local installation    
     */
     public ChangesSumPlugin(PluginInformation info) {
        super(info);
        // init your plugin
        Logging.info("ChangesSumPlugin init");
     }
}
