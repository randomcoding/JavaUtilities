/*
 * Licensed under the EPL v 1.0 (http://www.eclipse.org/legal/epl-v10.html)
 *
 * (c) Tym The Enchanter (tymtheenchanter@randomcoding.co.uk), 25 Aug 2010
 */
package uk.co.randomcoding.java.util.collection.map;

import java.util.HashMap;

/**
 * <p>
 * Map class that uses {@link IKeyProperty} objects as keys.
 * <p>
 * The implementors of {@link IKeyProperty} are expected to be enums, but this is not really required
 * </p>
 * </p> Created on: 25 Aug 2010<br>
 * 
 * @author Tym the Enchanter
 * @param <V> The value type that is stored in this map
 */
public class PropertyValueMap<V> extends HashMap<IKeyProperty, V>
{
	private static final long serialVersionUID = -2796216569471898508L;

	// has no methods as it is effectively a restrictive definition of HashMap
}
