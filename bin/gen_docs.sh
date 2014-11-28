#! /bin/bash

mvn scala:run -DmainClass="me.grison.scalocco.Scalocco" -DaddArgs="$1|$2"
