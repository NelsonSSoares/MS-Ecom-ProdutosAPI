package nelsonssoares.ecomproductsapi.entrypoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import nelsonssoares.ecomproductsapi.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static nelsonssoares.ecomproductsapi.commons.CategoryConstants.*;
import static nelsonssoares.ecomproductsapi.commons.ControllerConstants.API_BASE_URL;
import static nelsonssoares.ecomproductsapi.commons.ControllerConstants.CATEGORY;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void createCategory_withValidInput_shouldReturnCreated() throws Exception {

        when(categoryService.save(VALID_CATEGORYDTO)).thenReturn(VALID_CATEGORY_RESPONSE);
        mockMvc.perform(post(API_BASE_URL+CATEGORY)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(VALID_CATEGORYDTO)))
                .andExpect(status().isCreated());

    }

    @Test
    public void createCategory_withInvalidInput_shouldReturnBadRequest() throws Exception {

        when(categoryService.save(INVALID_CATEGORYDTO)).thenReturn(VALID_CATEGORY_BADREQUEST);
        mockMvc.perform(post(API_BASE_URL+CATEGORY)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(INVALID_CATEGORYDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createCategory_withExistingCategory_shouldReturnConflict() throws Exception {

        when(categoryService.save(VALID_CATEGORYDTO)).thenReturn(VALID_CATEGORY_CONFLICT);
        mockMvc.perform(post(API_BASE_URL+CATEGORY)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(VALID_CATEGORYDTO)))
                .andExpect(status().isConflict());
    }


}
