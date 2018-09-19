/*
 * Notify.java
 *
 * Tigase Jabber/XMPP Server
 * Copyright (C) 2004-2017 "Tigase, Inc." <office@tigase.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://www.gnu.org/licenses/.
 */
package tigase.server.amp.action;

import tigase.kernel.beans.Bean;
import tigase.server.Packet;
import tigase.server.amp.ActionAbstract;
import tigase.server.amp.AmpComponent;
import tigase.xml.Element;
import tigase.xmpp.PacketErrorTypeException;

/**
 * Created: Apr 27, 2010 5:36:03 PM
 *
 * @author <a href="mailto:artur.hefczyc@tigase.org">Artur Hefczyc</a>
 * @version $Rev$
 */
@Bean(name = "notify", parent = AmpComponent.class, active = true)
public class Notify
		extends ActionAbstract {

	private static final String name = "notify";

	@Override
	public boolean execute(Packet packet, Element rule) {
		try {
			if (packet.getStanzaFrom() != null && packet.getStanzaFrom().getBareJID().getLocalpart() != null) {
				Packet result = prepareAmpPacket(packet, rule);
				resultsHandler.addOutPacket(result);
			}

		} catch (PacketErrorTypeException ex) {

			// Ignore
		}

		return true;
	}

	@Override
	public String getName() {
		return name;
	}
}