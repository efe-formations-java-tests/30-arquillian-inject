	package fr.formation;
	
	import javax.inject.Inject;
	
	import org.jboss.arquillian.container.test.api.Deployment;
	import org.jboss.arquillian.junit.Arquillian;
	import org.jboss.shrinkwrap.api.ShrinkWrap;
	import org.jboss.shrinkwrap.api.asset.EmptyAsset;
	import org.jboss.shrinkwrap.api.spec.JavaArchive;
	import org.junit.Assert;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	
	@RunWith(Arquillian.class)
	public class HelloTest {
	
		@Inject
		Hello hello;
	
		@Deployment
		public static JavaArchive createDeployment() {
			return ShrinkWrap
					.create(JavaArchive.class)
					.addClass(Hello.class)
					.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		}
	
		@Test
		public void should_create_greeting() {
			Assert.assertEquals("Hello, World !", hello.sayHello("World"));
		}
	}

	
	