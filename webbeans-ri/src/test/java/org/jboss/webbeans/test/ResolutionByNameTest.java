package org.jboss.webbeans.test;

import static org.jboss.webbeans.util.BeanFactory.createSimpleBean;

import javax.webbeans.manager.Bean;

import org.jboss.webbeans.test.beans.Cod;
import org.jboss.webbeans.test.beans.Haddock;
import org.jboss.webbeans.test.beans.Plaice;
import org.jboss.webbeans.test.beans.Salmon;
import org.jboss.webbeans.test.beans.SeaBass;
import org.jboss.webbeans.test.beans.Sole;
import org.jboss.webbeans.test.beans.Tuna;
import org.testng.annotations.Test;

@SpecVersion("20081206")
public class ResolutionByNameTest extends AbstractTest
{

   @Test(groups={"stub", "el"}) @SpecAssertion(section="5.11")
   public void testELResolver()
   {
      assert false;
   }
   
   @Test(groups={"stub", "el"})  @SpecAssertion(section="5.11.2")
   public void testELResolverRegisteredWithJsf()
   {
      assert false;
   }
   
   @Test(groups={"stub", "el"})  @SpecAssertion(section="5.11.2")
   public void testELResolverRegisteredWithServlet()
   {
      assert false;
   }
   
   @Test @SpecAssertion(section="5.11.1")
   public void testNamedBasedResolution()
   {
      
      Bean<Tuna> tunaBean = createSimpleBean(Tuna.class);
      Bean<Cod> codBean = createSimpleBean(Cod.class);
      Bean<Salmon> salmonBean = createSimpleBean(Salmon.class);
      Bean<Sole> soleBean = createSimpleBean(Sole.class);
      Bean<SeaBass> seaBassBean = createSimpleBean(SeaBass.class);
      Bean<Haddock> haddockBean = createSimpleBean(Haddock.class);
      Bean<Plaice> plaiceBean = createSimpleBean(Plaice.class);
      
      manager.addBean(tunaBean);
      manager.addBean(codBean);
      manager.addBean(salmonBean);
      manager.addBean(soleBean);
      manager.addBean(haddockBean);
      manager.addBean(seaBassBean);
      
      assert manager.resolveByName("salmon").size() == 1;
      assert manager.resolveByName("salmon").contains(salmonBean);
      
      assert manager.resolveByName("whitefish").size() == 2;
      assert manager.resolveByName("whitefish").contains(codBean);
      assert manager.resolveByName("whitefish").contains(soleBean);
      
      manager.addBean(plaiceBean);
      
      assert manager.resolveByName("whitefish").size() == 1;
      assert manager.resolveByName("whitefish").contains(plaiceBean);
   }
   
   @Test(groups="resolution") @SpecAssertion(section="5.11.1")
   public void testNoWebBeansFound() throws Exception
   {
      Bean<Cod> codBean = createSimpleBean(Cod.class);
      Bean<Salmon> salmonBean = createSimpleBean(Salmon.class);
      
      manager.addBean(codBean);
      manager.addBean(salmonBean);
      
      assert manager.resolveByName("foo").size() == 0;
   }
   
   @Test(groups="stub") @SpecAssertion(section="5.11.1")
   public void testOnlyHigestPrecedenceResolved()
   {
      assert false;
   }
   
   /*

   @Test(groups="el") @SpecAssertion(section="5.11")
   public void test
   {
      assert false;
   }

    */
   
}
