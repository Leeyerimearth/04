package com.model2.mvc.service.purchase.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/commonservice.xml"})
public class PurchaseServiceTest{

	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	//@Test
	public void testAddPurchase() throws Exception
	{
		Purchase purchase = new Purchase();
		User user = new User();
		user.setUserId("testUserId");
		purchase.setBuyer(user);
		purchase.setDivyAddr("안양시 동안구");
		purchase.setDivyDate("20201212");
		purchase.setDivyRequest("넣어지나 봐주세요!");
		//purchase.setOrderDate(orderDate);
		purchase.setPaymentOption("0");
		Product product = productService.getProduct(10000);
		System.out.println(product.getProdNo());
		purchase.setPurchaseProd(product);
		//등등 .. db에서 확인해바방.
		
		purchaseService.addPurchase(purchase);
		
		//purchase =purchaseService.getPurchase2(10000);
		
		Assert.assertEquals("testUserId",purchase.getBuyer().getUserId());
		Assert.assertEquals("안양시 동안구", purchase.getDivyAddr());
		Assert.assertEquals("20201212", purchase.getDivyDate());
		Assert.assertEquals("넣어지나 봐주세요!",purchase.getDivyRequest());
	}
	
	@Test
	public void testGetPurchase() throws Exception
	{
		
		/*Purchase purchase = new Purchase();
		User user = new User();
		user.setUserId("testUserId");
		purchase.setBuyer(user);
		purchase.setDivyAddr("안양시 동안구");
		purchase.setDivyDate("20201212");
		purchase.setDivyRequest("넣어지나 봐주세요!");
		//purchase.setOrderDate(orderDate);
		purchase.setPaymentOption("0");
		Product product = productService.getProduct(10000);
		System.out.println(product.getProdNo());
		purchase.setPurchaseProd(product);
		//등등 .. db에서 확인해바방.
		*/
		
		Purchase purchase = purchaseService.getPurchase(10000);
		System.out.println(purchase);
		Assert.assertEquals("user01", purchase.getBuyer().getUserId());
		Assert.assertEquals("10001",purchase.getPurchaseProd().getProdNo());
	}
	
	@Test
	public void testGetPurchase2()
	{
		//Search search = new Search();
		//search.setCurrentPage(1);
		//search.setPageSize(3);
		//purchaseService.getPurchase2(prodNo);
		Purchase purchase = purchaseService.getPurchase2(prodNo);
	}
	
	//@Test
	public void testGetPurchaseList()
	{
		
	}
	
	//@Test
	public void testGetSaleList()
	{
		
	}
	
	//@Test
	public void testUpdatePurcahse()
	{
		
	}
	
	//@Test
	public void testUpdateTranCode()
	{
		
	}
}
