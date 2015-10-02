package com.rakuten.productMgmt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import com.rakuten.productMgmt.entities.User;
import com.rakuten.productMgmt.repositories.UserRepository;
import com.rakuten.productMgmt.services.UserService;

@RunWith(PowerMockRunner.class)
public class UserServiceTest extends TestCase {

	@Mock
	private UserRepository userRepositoryMock;

	@InjectMocks
	private UserService userService;

	@Test
	public void testFindAll() throws Exception {
		MockitoAnnotations.initMocks(this);

		List<User> productList = new ArrayList<User>();
		productList.add(new User());
		Mockito.when(userRepositoryMock.findAll()).thenReturn(productList);
		List<User> userList = userService.findAll();
		Assert.assertNotNull(userList);

	}

	@Test
	public void testCreate() throws Exception {
		MockitoAnnotations.initMocks(this);

		User user = new User();
		user.setDob(new Date());
		user.setEmail("test@test.com");
		user.setId(1);
		user.setName("testUser");
		user.setPassword("123456");
		
		Mockito.when(userRepositoryMock.save(user)).thenReturn(user);

		User userResult = userService.create(user);
		Assert.assertNotNull(userResult);
		Assert.assertEquals("testUser", userResult.getName());

	}

	@Test
	public void testFindById() throws Exception {
		MockitoAnnotations.initMocks(this);

		User user = new User();
		user.setDob(new Date());
		user.setEmail("test@test.com");
		user.setId(1);
		user.setName("testUser");
		user.setPassword("123456");
		
		Mockito.when(userRepositoryMock.findOne(1)).thenReturn(user);

		User userResult = userService.findUserById(1);
		Assert.assertNotNull(userResult);
		Assert.assertEquals("testUser", userResult.getName());

	}

	@Test
	public void testUpdate() throws Exception {
		MockitoAnnotations.initMocks(this);

		User user = new User();
		user.setDob(new Date());
		user.setEmail("test@test.com");
		user.setId(1);
		user.setName("testUser");
		user.setPassword("123456");

		Mockito.when(userRepositoryMock.save(user)).thenReturn(user);

		User  userResult = userService.update(user);
		Assert.assertNotNull(userResult);
		Assert.assertEquals("testUser", userResult.getName());

	}

	@Test
	public void testDelete() throws Exception {
		MockitoAnnotations.initMocks(this);

		User user = new User();
		user.setDob(new Date());
		user.setEmail("test@test.com");
		user.setId(1);
		user.setName("testUser");
		user.setPassword("123456");

		Mockito.doNothing().when(userRepositoryMock).delete(user);

		userService.deleteUser(1);

		Mockito.verify(userRepositoryMock, Mockito.atLeastOnce()).delete(1);
		Mockito.verify(userRepositoryMock, Mockito.never()).delete(2);

	}

}
