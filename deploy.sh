#!/bin/bash
set -eux
#cp ../../dist/changessum.jar ~/.local/share/JOSM/plugins/
cp ../../dist/changessum.jar ~/tmp/josm-dev-home/plugins/
cp ../../dist/changessum.jar ~/git/changessum/dist/
cp -r * ~/git/changessum/
