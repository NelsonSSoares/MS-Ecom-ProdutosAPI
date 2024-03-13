package nelsonssoares.ecomproductsapi.entrypoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import nelsonssoares.ecomproductsapi.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static nelsonssoares.ecomproductsapi.commons.ControllerConstants.API_BASE_URL;
import static nelsonssoares.ecomproductsapi.commons.ProductConstants.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Test
    public void createProduct_withValidInput_shouldReturnCreated() throws Exception {

        when(productService.save(VALID_PRODUCTDTO)).thenReturn(VALID_PRODUCT_RESPONSE);
        mockMvc.perform(post(API_BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(VALID_PRODUCTDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void createProduct_withInvalidInput_shouldReturnBadRequest() throws Exception {

        when(productService.save(INVALID_PRODUCTDTO)).thenReturn(INVALID_PRODUCT_BADREQUESTRESPONSE);
        mockMvc.perform(post(API_BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(INVALID_PRODUCTDTO)))
                .andExpect(status().isBadRequest());
    }

}
