package nelsonssoares.ecomproductsapi.entrypoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import nelsonssoares.ecomproductsapi.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static nelsonssoares.ecomproductsapi.commons.ControllerConstants.*;
import static nelsonssoares.ecomproductsapi.commons.ProductConstants.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    @Test
    public void createProduct_withExistingProduct_shouldReturnConflict() throws Exception {

        when(productService.save(VALID_PRODUCTDTO)).thenReturn(CONFLICT);
        mockMvc.perform(post(API_BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(VALID_PRODUCTDTO)))
                .andExpect(status().isConflict());
    }

    @Test
    public void getProduct_withValidId_shouldReturnOk() throws Exception {

        when(productService.getById(1)).thenReturn(VALID_PRODUCT_GETRESPONSE);
        mockMvc.perform(get(API_BASE_URL + ID, 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(VALID_PRODUCT)))
                .andExpect(status().isOk());
    }

    @Test
    public void getProduct_withInvalidId_shouldReturnNotFound() throws Exception {

        when(productService.getById(0)).thenReturn(INVALID_PRODUCT_GETRESPONSE);
        mockMvc.perform(get(API_BASE_URL + ID, 0)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(INVALID_PRODUCT)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getProduct_whithExistingName_shouldProduct() throws Exception {

        when(productService.getByName("Samsung")).thenReturn(VALID_LISTPRODUCTDTO_RESPONSE);
        mockMvc.perform(get(API_BASE_URL + NAME, "Samsung")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(VALID_PRODUCTDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void getProduct_whithNonExistingName_shouldReturnNotFound() throws Exception {

        when(productService.getByName("Asus")).thenReturn(INVALID_LIST_RESPONSE);
        mockMvc.perform(get(API_BASE_URL + NAME, "Asus")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(VALID_PRODUCTDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void upadateProduct_withValidInput_shouldReturnOk() throws Exception {

        when(productService.updateProduct(1,VALID_PRODUCTDTO)).thenReturn(VALID_PRODUCT_RESPONSE);
        mockMvc.perform(post(API_BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(VALID_PRODUCTDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void upadateProduct_withInvalidId_shouldReturnNotFound() throws Exception {

        when(productService.updateProduct(0,INVALID_PRODUCTDTO)).thenReturn(INVALID_PRODUCT_GETRESPONSE);
        mockMvc.perform(put(API_BASE_URL+ID,0)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(INVALID_PRODUCTDTO)))
                .andExpect(status().isNotFound());

    }

    @Test
    public void upadateProduct_withInvalidInput_shouldReturnBadRequest() throws Exception {

        when(productService.updateProduct(1,INVALID_PRODUCTDTO)).thenReturn(INVALID_PRODUCT_BADREQUESTRESPONSE);
        mockMvc.perform(put(API_BASE_URL+ID,1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(INVALID_PRODUCTDTO)))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void deleteProduct_withValidId_shouldReturnNoContent() throws Exception {

        when(productService.deleteProduct(1)).thenReturn(NO_CONTENT);
        mockMvc.perform(MockMvcRequestBuilders.delete(API_BASE_URL + ID, 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(VALID_PRODUCT)))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteProduct_withInvalidId_shouldReturnNotFound() throws Exception {

        when(productService.deleteProduct(0)).thenReturn(INVALID_PRODUCT_GETRESPONSE);
        mockMvc.perform(MockMvcRequestBuilders.delete(API_BASE_URL + ID, 0)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(INVALID_PRODUCT)))
                .andExpect(status().isNotFound());
    }



}
