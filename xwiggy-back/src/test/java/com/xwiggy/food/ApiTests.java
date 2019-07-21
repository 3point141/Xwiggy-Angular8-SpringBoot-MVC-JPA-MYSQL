package com.xwiggy.food;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xwiggy.food.controller.CartController;
import com.xwiggy.food.controller.FoodController;
import com.xwiggy.food.controller.LoginController;
import com.xwiggy.food.controller.RegistrationController;
import com.xwiggy.food.dao.CartDaoImpl;
import com.xwiggy.food.dao.FoodDaoImpl;
import com.xwiggy.food.dao.UserDao;
import com.xwiggy.food.dao.UserDaoImpl;
import com.xwiggy.food.model.Cart;
import com.xwiggy.food.model.Login;
import com.xwiggy.food.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({LoginController.class,RegistrationController.class, FoodController.class, CartController.class})
public class ApiTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    UserDao userDao;

    @MockBean
    UserDaoImpl userDaoImpl;

    @MockBean
    FoodDaoImpl foodDao;

    @MockBean
    CartDaoImpl cartDao;

    /*@Test
    public void postLoginAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/login")
                .content(asJsonString(new Login("amank","abcd1234")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
*/
    @Test
    public void getLoginApi() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                    .get("/login")
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());
    }

    @Test
    public void getRegisterApi() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .get("/api/register")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postRegisterAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/register")
                .content(asJsonString(new User("aman","abcd1234","bbbb","bbbb","b@gmail.com","bbbb",1234,true)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void postCheckUsernameApi() throws Exception{
        mvc.perform( MockMvcRequestBuilders
                .post("/checkUserName")
                .content("amank").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getMenuApi() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .get("/menu")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /*@Test
    public void getTotalCartApi() throws Exception{
        mvc.perform( MockMvcRequestBuilders
                .post("/cart")
                .content(asJsonString(new Cart(1,1,1,1,1,1)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }*/

    @Test
    public void getChangeDBCartApi() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .get("/changeDB")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
