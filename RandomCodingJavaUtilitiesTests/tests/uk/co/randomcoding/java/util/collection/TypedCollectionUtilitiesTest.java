/*
 * (c) Tym The Enchanter (tymtheenchanter@randomcoding.co.uk), 5 Jun 2010
 */
package uk.co.randomcoding.java.util.collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.Collection;
import java.util.HashSet;

import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Created on: 5 Jun 2010<br>
 * 
 * @author Tym the Enchanter <tymtheenchanter@randomcoding.co.uk>
 */
@SuppressWarnings("synthetic-access")
public class TypedCollectionUtilitiesTest
{
	@Test
	public void testExtractTypedCollection() throws Exception
	{
		Collection<TestClass> testCollection = new HashSet<TypedCollectionUtilitiesTest.TestClass>();
		testCollection.add(new TestClass());
		testCollection.add(new TestClass());
		testCollection.add(new TestSubClass());
		testCollection.add(new TestSubClass());
		testCollection.add(new TestSubSubClass());
		testCollection.add(new TestSubSubClass());

		assertThat(TypedCollectionUtilities.extractTypedCollection(testCollection, TestSubClass.class), hasSize(4));
		assertThat(TypedCollectionUtilities.extractTypedCollection(testCollection, TestSubSubClass.class), hasSize(2));
		assertThat(TypedCollectionUtilities.extractTypedCollection(testCollection, OtherTestClass.class), Matchers.<OtherTestClass> empty());
		assertThat(TypedCollectionUtilities.extractTypedCollection(testCollection, OtherTestSubClass.class), Matchers.<OtherTestSubClass> empty());
		assertThat(TypedCollectionUtilities.extractTypedCollection(testCollection, Object.class), hasSize(6));
	}

	@Test
	public void testExtractTypedCollectionOfSuperTypes() throws Exception
	{
		Collection<TestSubClass> testCollection = new HashSet<TypedCollectionUtilitiesTest.TestSubClass>();
		testCollection.add(new TestSubClass());
		testCollection.add(new TestSubClass());
		testCollection.add(new TestSubClass());
		testCollection.add(new TestSubSubClass());
		testCollection.add(new TestSubSubClass());

		assertThat(TypedCollectionUtilities.extractTypedCollection(testCollection, TestClass.class), hasSize(5));
		assertThat(TypedCollectionUtilities.extractTypedCollection(testCollection, Object.class), hasSize(5));
	}

	private static class TestClass
	{
		// empty class
	}

	private static class TestSubClass extends TestClass
	{
		// empty class
	}

	private static class TestSubSubClass extends TestSubClass
	{
		// empty class
	}

	private static class OtherTestClass
	{
		// empty class
	}

	private static class OtherTestSubClass extends OtherTestClass
	{
		// empty class
	}
}
