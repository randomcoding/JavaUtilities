/*
 * (c) Tym The Enchanter (tymtheenchanter@randomcoding.co.uk), 5 Jun 2010
 */
package uk.co.randomcoding.java.util.collection;

import java.util.Collection;
import java.util.HashSet;

/**
 * <p>
 * Class to provide operations for typed collections.
 * </p>
 * Created on: 5 Jun 2010<br>
 * 
 * @author Tym the Enchanter <tymtheenchanter@randomcoding.co.uk>
 */
public class TypedCollectionUtilities
{
	/**
	 * Creates a new collection of the elements in the source collection that are also of the target collection type
	 * <p>
	 * Added by: Tym the Enchanter <tymtheenchanter@randomcoding.co.uk><br>
	 * On: 5 Jun 2010<br>
	 * </p>
	 * 
	 * @param <T> The type of the returned collection
	 * @param sourceCollection The source collection to get the elements from
	 * @param targetCollectionType The type of the returned collection
	 * @return A collection of the specified type, containing those elements from the source collection that are of the
	 *         required type
	 */
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> extractTypedCollection(Collection<?> sourceCollection, Class<T> targetCollectionType)
	{
		Collection<T> typedCollection = new HashSet<T>();

		for (Object sourceObject : sourceCollection)
		{
			if (targetCollectionType.isAssignableFrom(sourceObject.getClass()))
			{
				typedCollection.add((T) sourceObject);
			}
		}

		return typedCollection;
	}
}
